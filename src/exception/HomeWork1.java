package exception;

import java.io.File;

public class HomeWork1 {
    public static void main(String[] args) {

    }

    private static double division(int a, int b) {
        return (double) a / b; // в этом методе мы можем получить арифметическое исклбчение если будем делить на 0
    }

    private static int sumArrayElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i] + array[i + 1]; // тут мы получим исключение выхода за границы массива
        }
        return sum;
    }

    public static void printFileSize(File file) {
        System.out.println(file.length()); // тут мы можем получить ошибку если путь к фалу будет не корректныый
    }

    private static int[] newArray(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Массивы разной длины");
        }
        int[] result = new int[array1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array1[i] - array2[i];
        }
        return result;
    }

    private static int[] newArray2(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Массивы разной длины");
        }
        int[] result = new int[array1.length];
        for (int i = 0; i < result.length; i++) {
            if (array2[i] != 0) {
                result[i] = array1[i] / array2[i];
            }
        }
        return result;
    }
}
