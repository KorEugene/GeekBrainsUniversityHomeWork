package lesson1.online;

public class HW1 {
    public static void main(String[] args) {

        // 2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte myByte = 5;
        short myShort = 1300;
        int myInt = 30123;
        long myLong = 3500000000L;
        float myFloat = 7.7f;
        double myDouble = 33.33;
        char myChar = 'x';
        String myString = "My string";
        boolean myBoolean = false;

        /*
         3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
         где a, b, c, d – аргументы этого метода, имеющие тип float.
         */
        System.out.println("Calculated result = " + calculateExpression(1.2f, 1.3f, 1.4f, 1.5f));

        /*
         4. Написать метод, принимающий на вход два целых числа и проверяющий,
         что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
         */
        System.out.println("Sum of numbers in range: " + isInTheRange(3, 7)); // true(10)
        System.out.println("Sum of numbers in range: " + isInTheRange(3, 6)); // false(9)
        System.out.println("Sum of numbers in range: " + isInTheRange(11, 9)); // true(20)
        System.out.println("Sum of numbers in range: " + isInTheRange(11, 10)); // false(21)

        /*
         5. Написать метод, которому в качестве параметра передается целое число,
         метод должен напечатать в консоль, положительное ли число передали или отрицательное.
         Замечание: ноль считаем положительным числом.
         */
        System.out.println("number is: " + isPositiveOrNegative(5));
        System.out.println("number is: " + isPositiveOrNegative(-5));
        System.out.println("number is: " + isPositiveOrNegative(0));

        /*
         6. Написать метод, которому в качестве параметра передается целое число.
         Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
         */
        System.out.println("number is negative: " + isPositiveOrNegative2(-1)); // true
        System.out.println("number is negative: " + isPositiveOrNegative2(0)); // false
        System.out.println("number is negative: " + isPositiveOrNegative2(1)); // false

        /*
         7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
         Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
         */
        greet("Ivan");
        greet("Petr");
        greet("Masha");
        greet("Sasha");

        /*
         8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
         Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
         */
        isLeapYear(400); // каждый 400-ый високосный
        isLeapYear(800); // каждый 400-ый високосный
        isLeapYear(300); // каждый 100-ый невисокосный
        isLeapYear(500); // каждый 100-ый невисокосный
        isLeapYear(1440); // каждый 4-ый високосный
        isLeapYear(1980); // каждый 4-ый високосный
        isLeapYear(1111); // все остальные невисокосные
        isLeapYear(333); // все остальные невисокосные
    }

    /*
     3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     где a, b, c, d – аргументы этого метода, имеющие тип float.
     */
    public static float calculateExpression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    /*
     4. Написать метод, принимающий на вход два целых числа и проверяющий,
     что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    public static boolean isInTheRange(int number1, int number2) {
        return (number1 + number2) >= 10 && (number1 + number2) <= 20;
    }

    /*
     5. Написать метод, которому в качестве параметра передается целое число,
     метод должен напечатать в консоль, положительное ли число передали или отрицательное.
     Замечание: ноль считаем положительным числом.
     */
    public static String isPositiveOrNegative(int magicNumber) {
        return magicNumber < 0 ? "Negative" : "Positive";
    }

    /*
     * 6. Написать метод, которому в качестве параметра передается целое число.
     * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    public static boolean isPositiveOrNegative2(int magicNumber) {
        return magicNumber < 0;
    }

    /*
     7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
     Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
     */
    public static void greet(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /*
     8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
     Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static void isLeapYear(int year) {
        if (year % 400 == 0) {
            System.out.println(year + " - год високосный!");
        } else if (year % 100 == 0) {
            System.out.println(year + " - год невисокосный!");
        } else if (year % 4 == 0) {
            System.out.println(year + " - год високосный!");
        } else {
            System.out.println(year + " - год невисокосный!");
        }
    }
}
