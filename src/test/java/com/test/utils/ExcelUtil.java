package com.test.utils;

import com.csvreader.CsvReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ExcelUtil {

    public String fileName;
    public String caseName;
    static String sourceFile;

    public ExcelUtil(String fileName, String caseName) {
        super();
        this.fileName = fileName;
        this.caseName = caseName;
    }

    public String[][] readExcel() throws Exception {
        Workbook wb = null;
        File directory = new File(".");
        sourceFile = directory.getCanonicalPath() + "/src/test/resources/data/"
                + fileName;
        File file = new File(sourceFile);
        if (!file.exists()) {
            throw new Exception("文件不存在");
        }
        String[] strs = sourceFile.split("\\.");
        if (strs[strs.length - 1].equals("csv")) {
            return readCSV(sourceFile);
        }

        if (strs[strs.length - 1].equals("xls")) {
            FileInputStream is = new FileInputStream(sourceFile);
            wb = new HSSFWorkbook(is);
        } else if (strs[strs.length - 1].equals("xlsx")) {
            FileInputStream is = new FileInputStream(sourceFile);
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheet(caseName);


        String[][] args = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // 循环row，如果第一行是字段，则 numRow = 1
        for (int numRow = 1; numRow <= sheet.getLastRowNum(); numRow++) {
            Row row = sheet.getRow(numRow);
            if (row == null) {
                continue;
            }
            // 循环cell
            for (int numCell = 0; numCell < row.getLastCellNum(); numCell++) {
                Cell cell = row.getCell(numCell);
                if (cell == null) {
                    continue;
                }
                // 打印数据
                args[numRow - 1][numCell] = getValue(cell);
            }
        }
        return args;
    }


    public static String[][] readCSV(String filePath) {
        return readCSV(filePath, "UTF-8");

    }

    public static String[][] readCSV(String filePath, String charSet) {
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            reader = new CsvReader(filePath, ',', Charset.forName(charSet));
            // 读取表头
            reader.readHeaders();
//            String[] headArray = reader.getHeaders();//获取标题
            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                dataList.add(reader.getValues());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        String[][] strings = new String[dataList.size()][dataList.get(0).length];
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; j < dataList.get(i).length; j++) {
                strings[i][j] = dataList.get(i)[j];
            }
        }

        return strings;
    }


    public static final int CELL_TYPE_NUMERIC = 0;
    public static final int CELL_TYPE_STRING = 1;
    public static final int CELL_TYPE_FORMULA = 2;
    public static final int CELL_TYPE_BLANK = 3;
    public static final int CELL_TYPE_BOOLEAN = 4;
    public static final int CELL_TYPE_ERROR = 5;


    public String getValue(Cell cell) {
        String val = null;
        switch (cell.getCellType()) {
            case CELL_TYPE_FORMULA:  //公式类型
                // 先计算表达式
                val = String.valueOf(cell.getNumericCellValue());
                break;
            case CELL_TYPE_BOOLEAN:  //布尔类型
                val = String.valueOf(cell.getBooleanCellValue());
                break;
            case CELL_TYPE_STRING:   // 字符串类型
                val = cell.getStringCellValue().trim();
                break;
            case CELL_TYPE_NUMERIC:  // 数值类型
                // 日期格式
                if (DateUtil.isCellDateFormatted(cell)) {
                    val = Date2Str(cell.getDateCellValue(), "yyyy-MM-dd HH:mm:ss");
                } else {
                    // 四舍五入
                    val = new DecimalFormat("#.####").format(cell.getNumericCellValue());
                }
                break;
            default: //其它类型
                break;
        }
        return val;
    }


    public String Date2Str(Date date, String format) {
        String seconds = "" + date.getTime();
        if (StringUtils.isEmpty(seconds)) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.format(new Date(Long.valueOf(seconds)));

        } catch (Exception e) {
            return seconds;
        }
    }
}


