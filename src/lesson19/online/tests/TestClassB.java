package lesson19.online.tests;

import lesson19.online.annotations.AfterSuite;
import lesson19.online.annotations.Test;

public class TestClassB {

    @Test(priority = 2)
    void test1() {
        System.out.println("B Test 1, default accessor, priority = 2");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("B Test 2, public accessor, priority = 2");
    }

    @Test(priority = 3)
    private void test3() {
        System.out.println("B Test 3, private accessor, priority = 3");
    }

    @AfterSuite
    private void after() {
        System.out.println("AfterSuite B!");
    }
}
