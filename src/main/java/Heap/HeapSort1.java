package Heap;

public class HeapSort1 {
    /**
     *
     // 对整个arr数组使用HeapSort1排序
     // HeapSort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
     // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
     // 整个堆排序的整体时间复杂度为O(nlogn)
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr.length);
        //将元素一个个插入到堆中
        for (int i=0;i<arr.length;i++) maxHeap.insert(arr[i]);
        //由于最大堆的特性 然后将其从堆中取出
        for (int i=arr.length-1;i>=0;i--) arr[i]=maxHeap.extractMax();
    }
}
