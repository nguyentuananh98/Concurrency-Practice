package algorithm;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,8,7,9,3,5,1};
        divideArray(arr, 3);
        for (int [] x : divideArray(arr, 3)) {
            System.out.println(Arrays.toString(x));
        }
    }
    public static int[][] divideArray(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        int n = nums.length;
        if (n%k != 0) return new int[0][0];

        int[][] result = new int[n / k][k];

        for (int i = 0; i < n; i += k) {
            int min = nums[i];
            int max = nums[i + k - 1];
            if (max - min > k) return new int[0][0];

            for (int j = 0; j < k; j++) {
                result[i / k][j] = nums[i + j];
            }
        }
        return result;
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
