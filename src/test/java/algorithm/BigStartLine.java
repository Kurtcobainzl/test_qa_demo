package algorithm;

public class BigStartLine {
    //最大前缀


    public static void main(String[] args) {

        String[] strings = {"abc", "abd", "abee", "abcc"};
        System.out.println(fun(strings));


    }

    public static String fun(String[] strs) {

        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];


        String value = compare(strs[0], strs[1]);
        if (strs.length > 2) {
            for (int i = 2; i < strs.length; i++) {
                value = compare(strs[i], value);
            }
        }

        return value;
    }


    public static String compare(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0)
            return "";
        for (int i = Math.min(str1.length(), str2.length()); i > 0; i--) {
            if (str1.substring(0, i).equals(str2.substring(0, i))) {

                return str1.substring(0, i);
            }
        }
        return "";
    }
}
