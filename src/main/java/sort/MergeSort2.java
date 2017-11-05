package sort;

import utils.SortTestHelper;

import java.util.*;

// 优化的Merge Sort算法
public class MergeSort2{


    private MergeSort2(){}


    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);


        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){
                arr[k] = aux[i-l]; i ++;
            }
            else{
                arr[k] = aux[j-l]; j ++;
            }
        }
    }


    private static void sort(Comparable[] arr, int l, int r) {

        // 优化2: 对于小规模数组, 使用插入排序 因为当n小到一定程度的时候,插入排序比归并排序性能
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if( arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    // 测试MergeSort2
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort(".MergeSort2", arr);

        return;
    }
}
