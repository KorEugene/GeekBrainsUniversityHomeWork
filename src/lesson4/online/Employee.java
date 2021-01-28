package lesson4.online;

public class Employee {

    // 7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
    private static int UUID = 0;

    // 1. Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
    private int employeeID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private String phoneNumber;
    private int salary;
    private int age;

    // 2. Конструктор класса должен заполнять эти поля при создании объекта;
    public Employee() {
        employeeID = UUID++;
        firstName = "Ivan";
        lastName = "Ivanov";
        middleName = "Ivanovich";
        position = "senior java developer";
        phoneNumber = "89991111111";
        salary = 30000;
        age = 50;
    }

    public Employee(String firstName, String lastName, String middleName, String position, String phoneNumber, int salary, int age) {
        employeeID = UUID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public static int getUUID() {
        return UUID;
    }

    // 3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName +
                ", employeeID=" + employeeID +
                ", position=" + position +
                ", phoneNumber=" + phoneNumber +
                ", salary=" + salary +
                ", age=" + age;
    }
}
