package com.test.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Date;


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
        System.out.println(sourceFile);
        String[] strs = sourceFile.split("\\.");
        System.out.println("strs:" + strs.length);
        for (String st : strs) {
            System.out.println(st);
        }
        if (strs[strs.length - 1].equals("xls")) {
            FileInputStream is = new FileInputStream(sourceFile);
            wb = new HSSFWorkbook(is);
        } else if (strs[strs.length - 1].equals("xlsx")) {
            FileInputStream is = new FileInputStream(sourceFile);
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheet(caseName);


        String[][] args = new String[sheet.getLastRowNum() ][sheet.getRow(0).getLastCellNum()];
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

//        for (int i = 0; i < sheet.getLastRowNum(); i++) {
//            for (int j = 0; j < sheet.getRow(i).getRowNum(); j++) {
//                System.out.println("getRow：" + sheet.getRow(i).getCell(j).getV());
//
//            }
//        }
//        System.out.println("sheet.getLastRowNum：" + sheet.getLastRowNum());
//        System.out.println("getRow：" + sheet.getRow(0).getCell(0).getStringCellValue());


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
        // TODO: 2020/10/26
        // Date -> LocalDateTime -> String
//        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
//        ZoneId zone = ZoneId.systemDefault();
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(),zone);
//        return df.format(localDateTime);
        return "todo";
    }
}


