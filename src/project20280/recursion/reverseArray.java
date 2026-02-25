package project20280.recursion;

public class reverseArray {
    public static void reverse(int[] arr, int i, int j) {
        if(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            System.out.println("reverseArray ("+ i + " "+ j + ")" + " = swaps (" + arr[i] + " " + arr[j] + ")");
            printArray(arr);
            reverse(arr, i + 1, j - 1);

        }


    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        int[] A = {12, 5, 19, 6, 11, 3, 9, 34, 2, 1, 15};
        System.out.println("Original Array : ");
        printArray(A);
        reverse(A, 0, A.length - 1);
    }
}
