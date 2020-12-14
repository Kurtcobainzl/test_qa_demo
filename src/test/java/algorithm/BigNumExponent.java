package algorithm;

import java.util.HashMap;

public class BigNumExponent {


    public static void main(String[] args) {
        BigNumExponent bigNumExponent = new BigNumExponent();
        System.out.println(bigNumExponent.power(0, -1));
        System.out.println(bigNumExponent.power(2, 1));
        System.out.println(bigNumExponent.power(2, 2));
        System.out.println(bigNumExponent.power(2, 3));
        System.out.println(bigNumExponent.power(2, 5));
    }


    boolean isInvalid = false;

    public double power(double base, int exponent) {

        if (exponent > 0) {
            return powerCode(base, exponent);
        } else if (exponent < 0) {
            if (base == 0) {
                //  throw new NumberFormatException("0 没有负数幂");
                return -10000;
            }
            return 1 / (powerCode(base, -exponent));
        } else {
            return 1;//任何数的0次方都是1
        }
    }


    public double powerCode(double base, int exponent) {

        if (exponent == 1) {
            return base;
        }
        if (exponent == 0) {
            return 1;
        }
        double result = powerCode(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;


    }


}
