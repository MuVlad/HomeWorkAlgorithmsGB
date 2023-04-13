package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
  вместо этого, необходимо повторно запросить у пользователя ввод данных.
2. Если необходимо, исправьте данный код
 (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

Дан следующий код, исправьте его там, где требуется
 (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println(inputNumber()); // 1 задача

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!"); // 3 задача
        } catch (Throwable ex) {                        // класс который выше по ирархии должен проверяться самы последний
            System.out.println("Что-то пошло не так...");
        }

        System.out.println(inputString()); // 4 задача
    }

    private static float inputNumber() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите дробное число: ");
            String stringNumber = reader.readLine();
            float floatNumber = 0;
            try {
                floatNumber = Float.parseFloat(stringNumber);
            } catch (NumberFormatException e) {
                System.out.println("Это не число!");
                inputNumber();
            }
            return floatNumber;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода");
        }
    }

    // 2 задача
//        try {
//            int d = 0;
//            double catchedRes1 = intArray[8] / d;               не совсем понял задание, тут оштбка в том что мы делим на ноль нужно просто заменить значение у переменной
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.out.println("Catching exception: " + e);
//        }
private static void printSum(Integer a, Integer b) // throws FileNotFoundException  <- тут излишний проброс ошибки потому что оно никогда не выбростся
{
    System.out.println(a + b);
}

    private static String inputString() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите строку: ");
            String stringNumber = reader.readLine();
            if (stringNumber.isEmpty()) {
                throw new RuntimeException("Пустые строки вводить нельзя!");
            }
            return stringNumber;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода");
        }
    }
}