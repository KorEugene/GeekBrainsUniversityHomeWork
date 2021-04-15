package lesson19.online.tests;

import lesson19.online.annotations.AfterSuite;
import lesson19.online.annotations.BeforeSuite;
import lesson19.online.annotations.Test;

public class TestClassA {

    @BeforeSuite
    public void before() {
        System.out.println("BeforeSuite A!");
    }

    @Test(priority = 5)
    void test1() {
        System.out.println("A Test 1, default accessor, priority = 5");
    }

    @Test(priority = 10)
    private void test2() {
        System.out.println("A Test 2, private accessor, priority = 10");
    }

    void wrongMethod() {
        System.out.println("It's not annotated method!");
    }

    @Test
    public void test3() {
        System.out.println("A Test 3, public accessor, priority = default(1)");
    }

    @AfterSuite
    private void after() {
        System.out.println("AfterSuite A!");
    }
}
