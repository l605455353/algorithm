package sort;

import utils.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    private MergeSort() {
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k=l;k<=r;k++) {
            if (i > mid) { // 如果左半部分元素已经全部处理完毕
                arr[k] = arr[j - l];
                j++;
            } else if (j > r) { // 如果右半部分元素已经全部处理完毕
                arr[k] = arr[i - l];
                i++;
            } else if (arr[i - l].compareTo(arr[j - l]) < 0) { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = arr[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = arr[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] clone = array.clone();
        SortTestHelper.testSort("sort.MergeSort",array);

    }
}
