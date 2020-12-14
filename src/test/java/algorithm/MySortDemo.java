package algorithm;

public class MySortDemo {

    public static int[] arr = new int[]{6, 8, 3, 9, 0, 7, 2, 1, 5, 4};

    public static void main(String[] args) {
//        MaoPao();
//        KuaiSu(arr, 0, arr.length - 1);
        chaRu();
        printArray();
    }


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
}
