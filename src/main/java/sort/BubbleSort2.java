package sort;

import utils.SwapUtils;

public class BubbleSort2 {

    // 我们的算法类不允许产生任何实例
    private BubbleSort2() {
    }

    /**
     * 优化版本--------------------------------------------------------------------
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        int newn; // 使用newn进行优化  理论上,可以使用newn进行优化,但实际优化效果较差

        do {
            newn = 0;
            for (int i = 1; i < n; i++)
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    SwapUtils.swap(arr, i - 1, i);
                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            n = newn;
        } while (newn > 0);
    }

}
