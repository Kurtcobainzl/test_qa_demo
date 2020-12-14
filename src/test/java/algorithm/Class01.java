package algorithm;

public class Class01 {


    public static void main(String[] args) {
        System.out.println(fun1("AAAA"));
        System.out.println(fun1("Aaaa"));
        System.out.println(fun1("aaaA"));
        System.out.println(fun1("aaaa"));
        System.out.println(fun1("AaAa"));
        System.out.println(fun1("AAAa"));
        System.out.println(fun1("aaaA"));
        System.out.println(fun1("2aaa"));

    }


    /**
     * 全部为大写 ，全部为小写，首字母大写，其他为小写  返回true
     * else  返回false
     *
     * @param str
     * @return
     */

    public static boolean fun1(String str) {
        if (str == null || str.length() == 0)//空字符串  false
            return false;
        
        if (!str.matches("[a-zA-Z]+"))//字符串中有非字符，false
            return false;

        if (str.equals(str.toUpperCase()) || str.equals(str.toLowerCase()) || (str.substring(0, 1).equals(str.substring(0, 1).toUpperCase()) && str.substring(1).equals(str.substring(1).toLowerCase()))) {
            return true;
        }

        return false;

    }
}
