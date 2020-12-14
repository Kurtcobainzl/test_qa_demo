package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongthOfSubString {
//最大不重复子串问题
    public static void main(String[] args) {
        System.out.println(fun("abddcdaabc"));
        System.out.println(fun(""));

    }

    public static int fun(String str) {
        if (str.length() <= 1)
            return str.length();
        int start = 0;
        int end = 0;
        int max = 0;
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap();

        for (; end < chars.length; end++) {
            if (map.containsKey(chars[end])) {
                start = Math.max(start, map.get(chars[end]));
            }
            max = Math.max(max, end - start);
            map.put(chars[end], end);
        }

        return max;
    }
}
