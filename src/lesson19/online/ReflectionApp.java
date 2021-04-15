package lesson19.online;

import lesson19.online.tests.TestClassA;
import lesson19.online.tests.TestClassC;

public class ReflectionApp {

    public static void main(String[] args) {

        System.out.println("Full test with excess method:");
        System.out.println("_____________________________");
        TestEngine.start(TestClassA.class);
        System.out.println("_____________________________");
        System.out.println("\n" + "No @BeforeSuite test:");
        System.out.println("_____________________________");
        TestEngine.start("lesson19.online.tests.TestClassB");
        System.out.println("_____________________________");
        System.out.println("\n" + "Excess @BeforeSuite test(throw RuntimeException):");
        System.out.println("_____________________________");
        TestEngine.start(TestClassC.class);
        System.out.println("_____________________________");
    }
}
