package Heap;


// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(Item[] arr) {
        int n = arr.length;
        capacity= n;
        data = (Item[]) new Comparable[n + 1];
        for (int i = 0; i < n; i++) data[i + 1] = arr[i];

        count =n;

        for (int i=count/2;i>=1;i--) shifDown(i);
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 最大堆中插入一个新的元素 item
    public void insert(Item item) {

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }


    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {

        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void shifDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;// 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) j ++;
            if (data[k].compareTo(data[j]) > 0) break;
            swap(k, j);
            k = j;
        }
    }

    /**
     *
     *  从最大堆中取出堆顶元素, 即堆中所存储的最大数据
     * @return
     */
    public Item extractMax() {
        if (count > 0) {
            Item max = data[1];
            swap(1, count);
            count--;
            shifDown(1);
            return max;
        }
        return null;
    }
    // 获取最大堆中的堆顶元素
    public Item getMax(){
        assert( count > 0 );
        return data[1];
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++)
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        System.out.println(maxHeap.size());

    }
}