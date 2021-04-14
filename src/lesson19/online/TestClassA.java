package lesson19.online;

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
        System.out.println("A Test 1, default accessor.");
    }

    @Test(priority = 10)
    private void test2() {
        System.out.println("A Test 2, private accessor.");
    }

    @Test
    public void test3() {
        System.out.println("A Test 3, public accessor.");
    }

    @AfterSuite
    private void after() {
        System.out.println("AfterSuite A!");
    }
}
