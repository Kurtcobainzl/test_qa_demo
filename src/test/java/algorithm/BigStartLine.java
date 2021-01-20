package algorithm;

import java.util.HashMap;
import java.util.Map;

public class BigStartLine {
    //最大前缀


    public static void main(String[] args) {

//        String[] strings = {"abc", "abd", "abee", "abcc"};
//        System.out.println(fun(strings));
//        System.out.println("--" + rob(new int[]{2, 1, 1, 2}));
//        System.out.println(lengthOfLongestSubstring("au"));

        int[] arr1 = new int[]{1, 3};
        int[] arr2 = new int[]{2};

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }


    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] num2s = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            if (i == 0) {
                num2s[i] = nums[i];
            } else if (i == 1) {
                num2s[i] = Math.max(nums[0], nums[1]);
            } else {
                num2s[i] = Math.max(nums[i] + num2s[i - 2], num2s[i - 1]);
            }
        }
        return Math.max(num2s[num2s.length - 1], num2s[num2s.length - 2]);
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


    //最长子串
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        int length = 0;
        int start = -1;
        int end = -1;
        Map<Character, Integer> map = new HashMap();
        while (++end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            length = Math.max(length, end - start);
            map.put(s.charAt(end), end);
        }
        return length;
    }

    //寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0))
            return 0.0;

        if (nums1 == null || nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return ((double) (nums2[nums2.length / 2]) + nums2[nums2.length / 2 - 1]) / 2;
            }
        }

        if (nums2 == null || nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return ((double) (nums1[nums1.length / 2]) + nums1[nums1.length / 2 - 1]) / 2;
            }
        }
        int countLength = nums1.length + nums2.length;
        int index1 = 0;
        int index2 = 0;
        int cur1 = 0, cur2 = 0;
        while ((index1 + index2) < countLength / 2 + 1) {
            cur1 = cur2;
            if (index2 == nums2.length) {
                cur2 = nums1[index1++];
                continue;
            }
            if (index1 == nums1.length || nums1[index1] >= nums2[index2]) {
                cur2 = nums2[index2++];
            } else {
                cur2 = nums1[index1++];
            }
        }

        if (countLength % 2 == 0) {
            return (double) (cur1 + cur2) / 2;
        } else {
            return cur2;
        }
    }


}
