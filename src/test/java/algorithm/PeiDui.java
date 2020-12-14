package algorithm;

import java.util.HashMap;
import java.util.Map;

public class PeiDui {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 2, 4};
        int target = 5 + 9;
        fun(arr, target);

    }

    /**
     * 给定一个数组，一个target，找出数组中两个数相加==target
     */


    public static void fun(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                System.out.println(arr[i] + "---" + map.get(arr[i]));
                break;
            }
            map.put(target - arr[i], arr[i]);
        }

    }
}
