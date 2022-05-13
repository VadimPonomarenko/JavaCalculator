import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static boolean CheckArabic(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7") || input.equals("8") || input.equals("9")) {
            return true;
        }
        return false;
    }

    public static boolean CheckRome(String input) {
        if (input.equals("I") || input.equals("II") || input.equals("III") || input.equals("IV") || input.equals("V") || input.equals("VI") || input.equals("VII") || input.equals("VIII") || input.equals("IX") || input.equals("X")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Введите арифметическую операцию между двумя числами");
        Scanner scanner = new Scanner(System.in);
            String x = scanner.nextLine();
            String[] array = x.split(" ");

            if (array.length!=3) {
                try {
                    throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода данных");
                    return;
                }
            }

        if (CheckArabic(array[0])&&CheckArabic(array[2])){
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[2]);
            String operation = array[1];
             if (operation.equals("+")){
                System.out.println("Результат операции: "+(a+b));
                return;
            } else if (operation.equals("-")){
                System.out.println("Результат операции: "+(a-b));
                return;
            } else if (operation.equals("*")){
                System.out.println("Результат операции: "+(a*b));
                return;
            } else if (operation.equals("/")){
                System.out.println("Результат операции: "+(a/b));
                return;
            }  else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Вы ввели неверную арифметическую операцию(+,-,*,/)");
                    return;
                }
            }
        } else if (CheckRome(array[0])&&CheckRome(array[2])){
            String a = array[0];
            String b = array[2];
            String operation = array[1];
            RomeNumber first = RomeNumber.valueOf(a);
            RomeNumber second = RomeNumber.valueOf(b);
            int aFirst = first.getArabic();
            int bSecond = second.getArabic();
            int resultArabic;

            if (operation.equals("+")) {
                resultArabic = aFirst+bSecond;
            } else if (operation.equals("-")) {
                resultArabic = aFirst-bSecond;
            } else if (operation.equals("*")) {
                resultArabic = aFirst*bSecond;
            } else if (operation.equals("/")) {
                resultArabic = aFirst/bSecond;
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Вы ввели неверную арифметическую операцию(+,-,*,/)");
                    return;
                }
            }
            if(resultArabic<1){
                System.out.println("Результатом вычеслений с римскими числами не могут быть числа меньше еденицы");
            } else {
                RomeNumber resultRome = RomeNumber.arabicToRome(resultArabic);
                System.out.println("Результат операции: "+resultRome);
                return;
            }
        } else {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Неверный формат ввода данных");
                return;
            }
        }
        }
    }

