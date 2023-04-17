package exception.homeWork3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String[] strings = dataInput();
        try {
            dataValidation(strings);
        } catch (IncorrectlyEnteredDataException e) {
            throw new RuntimeException(e);
        }
        createFile(strings);
    }

    private static String[] dataInput() {
        System.out.println("Введите данные через пробел " +
                "(Фамилия Имя Отчество датарождения номертелефона пол):");

        String[] resultArray;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String enteredData = reader.readLine();
            resultArray = enteredData.split(" ");
            if (resultArray.length > 6) {
                throw new RuntimeException("Колличество введеных данных больше чем требуется!");
            } else if (resultArray.length < 6) {
                throw new RuntimeException("Колличество введеных данных меньше чем требуется!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultArray;
    }

    private static void dataValidation(String[] array) throws IncorrectlyEnteredDataException {
        boolean isDate = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d")
                .matcher(array[3]).matches();
        if (!isDate) {
            throw new IncorrectlyEnteredDataException("Дата введена не корректно!");
        }

        try {
            Long.parseLong(array[4]);
        } catch (NumberFormatException e) {
            throw new IncorrectlyEnteredDataException("Номер телефона введен не корректно!");
        }

//        boolean isSex = Pattern.compile("[f] | [m]").matcher(array[5]).matches();
        if (!(array[5].equals("f")||array[5].equals("m"))) {
            throw new IncorrectlyEnteredDataException("Пол введен не корректно!");
        }
    }

    private static void createFile(String[] array) {
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\musli\\IdeaProjects\\HomeWorkAlgorithmsGB\\src\\main\\java\\exception\\homeWork3\\NewFile.txt")) {
            for (String s : array) {
                fileWriter.write("<");
                fileWriter.write(s);
                fileWriter.write(">");
            }
            fileWriter.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
