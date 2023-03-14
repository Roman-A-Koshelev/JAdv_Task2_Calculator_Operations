import java.util.Scanner;

public class Main {
    /**
     * Метод выполняет операции калькулятора (сложение, вычитание, деление или
     * умножение) над дробными числами.
     * @param a Первое дробное число
     * @param b Второе дробное число
     * @param op Операция выполняемая над дробными числами.
     */
    private static void calc(double a, double b, String op) {
        if (1 != op.length()) {
            System.err.println("Операция \"" + op + "\" не поддерживается!");
            return;
        }

        double res;
        switch(op.charAt(0)) {
            case '+':
                res = a + b;
                break;

            case '-':
                res = a - b;
                break;

            case '*':
                res = a * b;
                break;

            case '/':
                if (0 == b) {
                    System.err.println("Делитель не должен быть равен нулю!");
                    return;
                }
                res = a / b;
                break;

            default:
                System.err.println("Операция \"" + op + "\" не поддерживается!");
                return ;
        }

        System.out.printf("Результат операции = %.4f", res);
    }

    /**
     * Калькулятор
      */
    private static void calc() {
        Scanner in = new Scanner(System.in);
        System.out.println("Необходимо ввести два дробных числа и знак операции (‘+’, ‘-’, ‘*’ или ‘/’).");

        System.out.print("Введите первое число:   ");
        double a = in.nextDouble();

        System.out.print("Введите второе число:   ");
        double b = in.nextDouble();

        System.out.print("Введите знак операции:  ");
        String op = in.next();

        calc(a, b, op);
    }

    /**
     * Поиск максимального элемента в массиве
     */
    private static void strMaxLengthInArray() {
        Scanner in = new Scanner(System.in);

        System.out.println("Программа среди заданных строк находит строку максимальной длины.\n" +
                "Если таких строк будет много, то выведет первую.");
        System.out.print("Введите количество строк:    ");
        int n = in.nextInt();
        if (n <= 0) {
            System.err.println("Ошибка! Количество строк должно быть положительным числом.");
            return;
        }

        String[] rows = new String[n];
        for (int i = 0; i < n; ++i) {
            System.out.print("Введите строку " + (i+1) + ": ");
            rows[i] = in.next();
        }

        int numRow = 0;
        int maxLength = rows[0].length();
        for (int i = 1; i < n; ++i) {
            if (maxLength < rows[i].length()) {
                maxLength = rows[i].length();
                numRow = i;
            }
        }

        System.out.println("Итоговая строка: " + rows[numRow]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер задачи (1 - Калькулятор, 2 - Массив строк): ");
        String op = in.next();

        if (1 != op.length()) {
            System.err.println("Операция \"" + op + "\" не поддерживается!");
            return;
        }

        switch(op.charAt(0)) {
            case '1':
                calc();
                break;

            case '2':
                strMaxLengthInArray();
                break;

            default:
                System.err.println("Операция \"" + op + "\" не поддерживается!");
                return ;
        }
    }
}