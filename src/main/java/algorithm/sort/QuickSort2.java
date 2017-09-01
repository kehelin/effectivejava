package algorithm.sort;

public class QuickSort2 {
    //	static int[] input = {23,4,7,9,24,32,87,6,5,32,45,4,5,6,7,7};
    private static int[] input = {3, 2};

    public static void main(String args[]) {

        for (int value : input) {
            System.out.print(value + ",");
        }
        System.out.println();
        quickSort(input, 0, input.length - 1);
        for (int value : input) {
            System.out.print(value + ",");
        }
    }

    static void quickSort(int arr[], int left, int right) {
        if (left > right)
            return;
        int j = partition(arr, left, right);
        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);
    }

    private static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp = arr[left];
        while (i < j) {
            while (i < j && arr[j] > tmp)
                j--;
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < tmp)
                i++;
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = tmp;
        return i;
    }
}

