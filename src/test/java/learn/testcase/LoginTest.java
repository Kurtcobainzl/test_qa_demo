package learn.testcase;


import java.util.ArrayList;
import java.util.Arrays;

public class LoginTest {
    /**
     *
     */

//    @Test(description = "��ȡ������֤��", priority = 1, dataProvider = "getPhones", dataProviderClass = TestParam.class)
    public void login() {

    }

    public static void main(String[] args) {


        System.out.println("" + (int) Math.sqrt(2));
        ArrayList<String> arr = new ArrayList<>();
        arr.add("abc");
        arr.add("bcd");
        arr.add("abd");
        Object[] objects = arr.toArray();
        Arrays.sort(objects);
        for (Object str : objects) {
            System.out.println(str);
        }
    }

}
