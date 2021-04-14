package lesson19.online.tests;

import lesson19.online.annotations.AfterSuite;
import lesson19.online.annotations.BeforeSuite;
import lesson19.online.annotations.Test;

public class TestClassC {

    @BeforeSuite
    private void before() {
        System.out.println("BeforeSuite C!");
    }

    @BeforeSuite
    private void excessBefore() {
        System.out.println("This method should cause Runtime Exception!");
    }

    @Test(priority = 4)
    void test1() {
        System.out.println("C Test 1, default accessor, priority = 4");
    }

    @Test
    public void test2() {
        System.out.println("C Test 2, public accessor, priority = default(1)");
    }

    @Test(priority = 7)
    private void test3() {
        System.out.println("C Test 3, private accessor, priority = 7");
    }

    @AfterSuite
    private void after() {
        System.out.println("AfterSuite C!");
    }
}
