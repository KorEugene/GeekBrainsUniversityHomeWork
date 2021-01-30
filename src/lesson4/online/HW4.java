package lesson4.online;

public class HW4 {

    public static void main(String[] args) {

        Employee employee1 = new Employee();

        // 4 Вывести при помощи методов из пункта 3 ФИО и должность;
        System.out.println("Employee first name: " + employee1.getFirstName());
        System.out.println("Employee last name: " + employee1.getLastName());
        System.out.println("Employee middle name: " + employee1.getMiddleName());
        System.out.println("Employee position: " + employee1.getPosition());

        Employee employee2 = new Employee("Mikhail", "Mishanin", "Mikhaylovich", "middle java developer", "89992222222", 20000, 25);
        Employee employee3 = new Employee("Vasiliy", "Vasilyev", "Vasilyevich", "junior java developer", "89993333333", 10000, 20);
        Employee employee4 = new Employee("Mefodiy", "Mefodiev", "Mefodievich", "product manager", "89994444444", 15000, 45);
        Employee employee5 = new Employee("Oleg", "Olegov", "Olegovich", "account manager", "89995555555", 10000, 40);

        // 5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        Employee[] employees = {employee1, employee2, employee3, employee4, employee5};
        System.out.println("\n" + "Employees over 40: ");
        for (Employee employee : employees) {
            if (isEmployeeOverCertainAge(employee, 40)) {
                System.out.println(employee.toString());
            }
        }

        // 6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
        raiseTheSalary(employees, 35, 10000);
        System.out.println("\n" + "After salary increase:");
        printEmployees(employees);

        // 7*
        System.out.println("\n" + "Next employee will have employeeID=" + Employee.getUUID());
    }

    private static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    private static boolean isEmployeeOverCertainAge(Employee employee, int age) {
        return employee.getAge() > age;
    }

    // 6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
    private static void raiseTheSalary(Employee[] employees, int age, int salaryIncrease) {
        for (Employee employee : employees) {
            if (isEmployeeOverCertainAge(employee, age)) {
                employee.setSalary(employee.getSalary() + salaryIncrease);
            }
        }
    }
}
