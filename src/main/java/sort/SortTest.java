package sort;

import utils.SortTestHelper;



public class SortTest {
    public static void main(String[] args) {



        int[] array = SortTestHelper.generateRandomArray(10000, 0, 10000);
        int[] clone = array.clone();
        int[] clone1 = array.clone();
        double selectionSortTime = getSelectionSortTime(clone);
        System.out.println("---------------");
        double insertionSortTime = getInsertionSortTime(array);
        System.out.println("---------------");
        System.out.println("selectionSort:"+selectionSortTime);
        System.out.println("insertionSort:"+insertionSortTime);
        System.out.println("----------");
        System.out.println(insertTionSort2Time(clone1));
    }

    private static double getSelectionSortTime(int[] array) {
        Sort sort;
        sort = new SortImpl();
        long startTime = System.currentTimeMillis();
        sort.selectionSort(array);
        long endTime = System.currentTimeMillis();
        double time =(double) (endTime - startTime)/1000;
        for (int i:array) System.out.print(i+" ");
        return time;
    }
    private static double getInsertionSortTime(int[] array) {
        Sort sort;
        sort = new SortImpl();
        long startTime = System.currentTimeMillis();
        sort.insertionSort(array);
        long endTime = System.currentTimeMillis();
        double time =(double) (endTime - startTime)/1000;
        for (int i:array) System.out.print(i+" ");
        return time;
    }
    private static double insertTionSort2Time(int[] array) {
        Sort sort;
        sort = new SortImpl();
        long startTime = System.currentTimeMillis();
        sort.insertTionSort2(array);
        long endTime = System.currentTimeMillis();
        double time =(double) (endTime - startTime)/1000;
        for (int i:array) System.out.print(i+" ");
        return time;
    }
}
