package algorithm;

public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(fun(0));
        System.out.println(fun(12345));
        System.out.println(fun(-12345));
        System.out.println(fun(1534236469));
        System.out.println(fun(-120));

    }

    //翻转int


    public static int fun(int x) {

        long value = 0;
        while (x != 0) {
            value = value * 10 + x % 10;
            x /= 10;
        }
        return (int) value == value ? (int) value : 0;
    }


//    public static int fun(int x) {
//
//        if (x == 0)
//            return x;
//        String str = x >= 0 ? "" : "-";
//        x = Math.abs(x);
//        while (x > 0) {
//            str += x % 10;
//            x = x / 10;
//        }
//        try {
//            return Integer.valueOf(str);
//        }catch (Exception e){
//            return 0;
//        }
//    }
}
