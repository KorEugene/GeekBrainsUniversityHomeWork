package lesson19.online;

import lesson19.online.annotations.AfterSuite;
import lesson19.online.annotations.BeforeSuite;
import lesson19.online.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
1. Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов
 с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
 передается или объект типа Class, или имя класса. Из «класса-теста» вначале должен быть запущен метод с
 аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test, а по завершению всех
 тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить
 приоритеты (int числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения,
 если приоритет одинаковый, то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite
 должны присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
 Это домашнее задание никак не связано с темой тестирования через JUnit и использованием этой библиотеки,
 то есть проект пишется с нуля.
 */

public class TestEngine {

    private static Object reflectedObject;
    private static List<Method> BEFORE_SUITE;
    private static List<Method> TEST_METHODS;
    private static List<Method> AFTER_SUITE;

    public static void start(String testClassName) {
        try {
            start(Class.forName(testClassName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class testClass) {
        BEFORE_SUITE = new ArrayList<>();
        TEST_METHODS = new ArrayList<>();
        AFTER_SUITE = new ArrayList<>();
        try {
            reflectedObject = getInstance(testClass);
            extractMethods(testClass);
            checkBeforeAfterCount();
            runTests(BEFORE_SUITE);
            sortTestsByPriority();
            runTests(TEST_METHODS);
            runTests(AFTER_SUITE);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static Object getInstance(Class testClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = testClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    private static void extractMethods(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                BEFORE_SUITE.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) throw new RuntimeException();
                TEST_METHODS.add(method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                AFTER_SUITE.add(method);
            }
        }
    }

    private static void runTests(List<Method> methodList) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methodList) {
            method.setAccessible(true);
            method.invoke(reflectedObject);
        }
    }

    private static void sortTestsByPriority() {
        TEST_METHODS.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));
    }

    private static void checkBeforeAfterCount() {
        if (BEFORE_SUITE.size() > 1 || AFTER_SUITE.size() > 1) throw new RuntimeException();
    }
}
