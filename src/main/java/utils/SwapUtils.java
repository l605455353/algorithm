package utils;

public class SwapUtils {
    private SwapUtils() {
    }
    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
