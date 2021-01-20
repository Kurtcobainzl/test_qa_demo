package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeAlgorithm {

    public static void main(String[] args) {

//        System.out.println(new TreeNodeAlgorithm().selfDividingNumbers(1, 22));

        System.out.println(new TreeNodeAlgorithm().trailingZeroes(6));
    }


    //阶乘中的0
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            int num = n;
            while (num % 5 == 0) {
                count++;
                num /= 5;
            }
            if (n % 5 == 0) {
                n -= 5;
            } else {
                n--;
            }

        }
        return count;
    }


    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1 || nums.length == 2)
            return true;
        if (nums[0] > nums[1]) {
            nums[0] = 1;
        } else if (nums[nums.length - 1] < nums[nums.length - 2]) {
            nums[nums.length - 1] = nums[nums.length - 2];
        } else {
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i - 1] > nums[i + 1] && nums[i - 1] < nums[i]) {
                    nums[i + 1] = nums[i];
                    break;
                }
                if (nums[i - 1] > nums[i + 1] && nums[i - 1] > nums[i]) {
                    nums[i - 1] = nums[i];
                    break;
                }

                //i-1<i+1     i>i+1    i=i+1

                if (nums[i - 1] < nums[i + 1] && nums[i] > nums[i + 1]) {
                    nums[i] = nums[i + 1];
                    break;
                }

                //-1<i+1   i<i-1  :  i=i-1
                if (nums[i - 1] < nums[i + 1] && nums[i] < nums[i - 1]) {
                    nums[i] = nums[i - 1];
                    break;
                }

            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }


    //自除数
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        while (left <= right) {
            int num = left;
            if (num < 10) {
                list.add(num);
                left++;
            } else {
                while (num >= 0) {
                    if (num % 10 == 0 || left % (num % 10) != 0) {
                        break;
                    }
                    num = num / 10;
                    if (num == 0) {
                        list.add(left);
                    }
                }
                left++;
            }
        }
        return list;
    }


    public static String tree2str(TreeNode t) {
        if (t == null)
            return "";
        StringBuilder builder = new StringBuilder();

        doTreeString(t, builder);

        return builder.toString();
    }

    private static void doTreeString(TreeNode t, StringBuilder builder) {
        if (t != null) {
            builder.append(t.val);
            if (t.left != null || t.right != null) {

                builder.append("(");
                doTreeString(t.left, builder);
                builder.append(")");

                if (t.right != null) {
                    builder.append("(");
                    doTreeString(t.right, builder);
                    builder.append(")");
                }
            }
        }
    }


}
