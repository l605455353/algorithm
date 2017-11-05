package sort;


import utils.SwapUtils;

public class BubbleSort {

    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        Boolean swapped ;
        do {
            swapped =false;
            for (int i = 1; i < n; i++)
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    SwapUtils.swap(arr, i - 1, i);
                    swapped = true;
                }
            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            n--;
        } while (swapped);
    }
}
