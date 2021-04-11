package lesson18.online;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ArrayContentUtilsTest {

    @ParameterizedTest
    @MethodSource("Provider0")
    void getArrayTailExceptionTest(int[] source) {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayContentUtils.getArrayTailOrThrowException(source));
    }

    static Stream<Arguments> Provider0() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{1, 2, 3, 7, 8}),
                Arguments.of(new int[]{}),
                Arguments.of(new int[]{5})
        );
    }

    @ParameterizedTest
    @MethodSource("Provider1")
    void getArrayTailTest(int[] target, int[] source) {
        Assertions.assertArrayEquals(target, ArrayContentUtils.getArrayTailOrThrowException(source));
    }

    static Stream<Arguments> Provider1() {
        return Stream.of(
                Arguments.of(new int[]{5, 6, 7}, new int[]{1, 2, 3, 4, 5, 6, 7}),
                Arguments.of(new int[]{}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{5}, new int[]{1, 2, 3, 4, 5})
        );
    }

    // All in one
    @ParameterizedTest
    @MethodSource("Provider2")
    void checkArrayContentTest(boolean target, int[] source) {
        Assertions.assertEquals(target, ArrayContentUtils.checkArrayContent(source));
    }

    static Stream<Arguments> Provider2() {
        return Stream.of(
                Arguments.of(true, new int[]{1, 1, 1, 4, 1, 4}),
                Arguments.of(true, new int[]{1, 4}),
                Arguments.of(false, new int[]{1, 1, 1}),
                Arguments.of(false, new int[]{4, 4, 4})
        );
    }

    // Only "True"
    @ParameterizedTest
    @MethodSource("Provider3")
    void checkArrayContentTestTrue(int[] source) {
        Assertions.assertTrue(ArrayContentUtils.checkArrayContent(source));
    }

    static Stream<Arguments> Provider3() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 4, 1, 4}),
                Arguments.of(new int[]{1, 4})
        );
    }

    // Only "False"
    @ParameterizedTest
    @MethodSource("Provider4")
    void checkArrayContentTestFalse(int[] source) {
        Assertions.assertFalse(ArrayContentUtils.checkArrayContent(source));
    }

    static Stream<Arguments> Provider4() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1}),
                Arguments.of(new int[]{4, 4, 4, 4})
        );
    }
}
