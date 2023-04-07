import algorithms.homeWork1.HeapSort;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{
                5, 2, 8, 1, 2, 9, 5, 2, 0, 10
        };
        printArray(array);
        HeapSort.sort(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
