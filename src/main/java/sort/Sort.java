package sort;

public interface Sort {
    /**
     * 选择排序
     * @param arr
     */
    void selectionSort(int arr[]);

    /**
     * 插入排序
     * @param arr
     */
    void insertionSort(int arr[]);

    /**
     * 插入排序优化
     * @param arr
     */
    void insertTionSort2(int arr[]);
}
