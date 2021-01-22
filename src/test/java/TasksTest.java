import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TasksTest {
    private final Tasks tasks;

    TasksTest() {
        tasks = new Tasks();
    }

    static Stream<Arguments> getFibonacciTest() {
        return Stream.of(
                Arguments.arguments(0, 0),
                Arguments.arguments(1, 1),
                Arguments.arguments(2, 1),
                Arguments.arguments(3, 2),
                Arguments.arguments(4, 3),
                Arguments.arguments(5, 5),
                Arguments.arguments(6, 8),
                Arguments.arguments(7, 13),
                Arguments.arguments(8, 21)
        );
    }

    @ParameterizedTest(name = "Get fibonacci. Data input: {0}, {1}")
    @MethodSource("getFibonacciTest")
    public void getFibonacciTestMain(int number, int expected) {
        int actual = tasks.getFibonacci(number);
        assertEquals(expected, actual);
    }
    @Test
    public void getFibonacciTestException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tasks.getFibonacci(-5);
        }, Tasks.EXCEPTION);
    }

    //=======================================================================================
    static Stream<Arguments> getFactorialTest() {
        return Stream.of(
                Arguments.arguments(0, 1),
                Arguments.arguments(1, 1),
                Arguments.arguments(2, 2),
                Arguments.arguments(3, 6),
                Arguments.arguments(4, 24),
                Arguments.arguments(5, 120),
                Arguments.arguments(6, 720),
                Arguments.arguments(7, 5040)
        );
    }

    @ParameterizedTest(name = "Get factorial. Data input: {0}, {1}")
    @MethodSource("getFactorialTest")
    public void getFactorialTestMain(int number, int expected) {
        int actual = tasks.getFactorial(number);
        assertEquals(expected, actual);
    }
    @Test
    public void getFactorialTestException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tasks.getFactorial(-5);
        }, Tasks.EXCEPTION);
    }

    //=======================================================================================
    static Stream<Arguments> getExponentiationTest() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.arguments(0, 2, 0),
                org.junit.jupiter.params.provider.Arguments.arguments(1, 2, 1),
                org.junit.jupiter.params.provider.Arguments.arguments(2, 3, 8),
                org.junit.jupiter.params.provider.Arguments.arguments(3, 2, 9),
                org.junit.jupiter.params.provider.Arguments.arguments(10, 2, 100),
                org.junit.jupiter.params.provider.Arguments.arguments(9, 3, 729),
                org.junit.jupiter.params.provider.Arguments.arguments(10, 3, 1000),
                org.junit.jupiter.params.provider.Arguments.arguments(4, 6, 4096),
                org.junit.jupiter.params.provider.Arguments.arguments(-4, 2, 16),
                org.junit.jupiter.params.provider.Arguments.arguments(-2, 2, 4),
                org.junit.jupiter.params.provider.Arguments.arguments(-2, 3, -8),
                org.junit.jupiter.params.provider.Arguments.arguments(-2, 1, -2),
                org.junit.jupiter.params.provider.Arguments.arguments(-4, 3, -64)

        );
    }

    @ParameterizedTest(name = "Get exponentiation. Data input: {0}, {1}, {2}")
    @MethodSource("getExponentiationTest")
    public void getExponentiationTestMain(int number, int exponentiation, int expected) {
        int actual = tasks.getExponentiation(number, exponentiation);
        assertEquals(expected, actual);
    }
    @Test
    public void getExponentiationTestException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tasks.getExponentiation(6, -8);
        }, Tasks.EXCEPTION_EXP);
    }
}