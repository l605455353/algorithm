package sort;

public class SortImpl implements Sort {


    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 寻找[i, arr.length)区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            //交换位置
            int a = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = a;
        }
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 寻找元素arr[i]合适的插入位置
         /* 写法2
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    //交换位置
                    int a = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] =a;
                }else break;
            }*/

            // 写法2
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int a = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = a;
            }

        }
    }

    public void insertTionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            int j; // j保存元素e应该插入的位置
            for (j = i; j > 0 && arr[j - 1] > e; j--) arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }
}
