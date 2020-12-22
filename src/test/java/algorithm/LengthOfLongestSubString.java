package algorithm;

import org.apache.http.util.TextUtils;

import java.util.HashMap;
import java.util.Map;

//求字符串中的最长不重复子串长度
public class LengthOfLongestSubString {

    public static void main(String[] args) {
        System.out.println(fun("abcdabdacdabcdefgabc"));
    }


    public static int fun(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = -1;
        int end = 0;
        int maxlength = 0;
        int subStrstart = 0;
        int subStringEnd = 1;
        char currChar;
        for (; end < str.length(); end++) {
            currChar = str.charAt(end);
            if (map.containsKey(currChar)) {
                start = Math.max(start, map.get(currChar));
            }

            if (end - start > maxlength) {
                subStrstart = start;
                subStringEnd = end;
            }
            maxlength = Math.max(maxlength, end - start);
            map.put(currChar, end);
        }
        System.out.println("subStrstart:" + subStrstart + "\tsubStringEnd" + subStringEnd);
        System.out.println(str.substring(subStrstart + 1, subStringEnd + 1));
        return maxlength;
    }






}
