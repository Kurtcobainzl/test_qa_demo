package algorithm;

import java.util.logging.Logger;

public class MySortDemo {

    public static int[] arr = new int[]{6, 8, 3, 9, 0, 7, 2, 1, 5, 4};


    /**
     * 冒泡
     */
    public static void MaoPao() {
        int stmp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    stmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = stmp;
                }
            }
        }
        printArray();
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param leftIndex
     * @param rightIndex
     */

    public static void KuaiSu(int[] arr, int leftIndex, int rightIndex) {

        if (leftIndex >= rightIndex)
            return;
        int finalLeft = leftIndex;
        int finalRight = rightIndex;
        int key = arr[leftIndex];
        while (leftIndex < rightIndex) {
            while (rightIndex > leftIndex && arr[rightIndex] >= key) {
                rightIndex--;
            }
            arr[leftIndex] = arr[rightIndex];

            while (leftIndex < rightIndex && arr[leftIndex] <= key) {
                leftIndex++;
            }
            arr[rightIndex] = arr[leftIndex];
        }
        arr[leftIndex] = key;
        KuaiSu(arr, finalLeft, leftIndex - 1);
        KuaiSu(arr, leftIndex + 1, finalRight);

    }


    /**
     * 对于少量元素的排序，它是一个有效的算法
     */
    public static void chaRu() {

        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }


    public static void duiPaixu() {

    }


    public static void xiEr() {

    }


    public static void erChaShu() {

    }


    public static void printArray() {
        for (int a : arr) {
            System.out.print(a + "\t");
        }
        System.out.println();

    }


    public static void main(String[] args) {
//        MaoPao();
//        KuaiSu(arr, 0, arr.length - 1);
//        chaRu();
//        printArray();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(7);
        ListNode l6 = new ListNode(8);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(10);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;


        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(8);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode value = mergeTwoLists(l1, a1);
        while (value != null) {
            System.out.print("" + value.val + ",");   //1,2,3,4,7,8,9,10,
            value = value.next;
        }


    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode value = null;

        ListNode temp1 = null, temp2 = null, tempValue = null;
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                value = l1;
                tempValue = l1;
                temp1 = l1.next;
                temp2 = l2;
            } else {
                value = l2;
                tempValue = l2;
                temp1 = l1;
                temp2 = l2.next;
            }
        }


        if (l1 != null)
            temp1 = l1.next;
        if (l2 != null)
            temp2 = l2.next;

        while (temp1 != null || temp2 != null) {

            if (temp1 == null) {
                tempValue.next = temp2;
                tempValue = tempValue.next;
                temp2 = temp2.next;
                continue;
            }
            if (temp2 == null) {
                tempValue.next = temp1;
                tempValue = tempValue.next;
                temp1 = temp1.next;
                continue;
            }

            if (temp1.val < temp2.val) {
                tempValue.next = temp1;
                temp1 = temp1.next;
            } else {
                tempValue.next = temp2;
                temp2 = temp2.next;
            }

            tempValue = tempValue.next;

        }


        return value;

    }


}
