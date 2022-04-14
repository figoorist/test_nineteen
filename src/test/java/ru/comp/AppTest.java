package ru.comp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Unit test for simple App.
 */
class AppTest
{
    private App _app;

    // тестовые данные
    static Stream<Arguments> inputArrayAndOutputString() {
        return Stream.of(
            arguments(Arrays.asList("qwe", "wqe", "qwee", "a", "a"), "a = 3, 4 eqw = 0, 1"),
            arguments(Arrays.asList("qwe", "wqe", "weq", "qwee", "a", "a"), "a = 4, 5 eqw = 0, 1, 2"),
            arguments(Arrays.asList("stop", "qq", "qq", "tops", "q"), "qq = 1, 2 opst = 0, 3"),
            arguments(Arrays.asList("stop", "qq", "qs", "qwerty", "q"), ""),
            arguments(Arrays.asList(), ""),
            arguments(Arrays.asList("q", "qq"), "")
        );
    }

    @BeforeEach
    public void setUp()
    {
        _app = new App();
    }

    @ParameterizedTest
    @MethodSource("inputArrayAndOutputString")
    public void symbolSetEqualsTest(List<String> inputArray, String expected)
    {
        assertEquals(expected, _app.symbolSetEquals(inputArray));
    }
}

