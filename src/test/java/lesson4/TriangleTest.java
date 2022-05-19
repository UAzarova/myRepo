package lesson4;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        System.out.println("@BeforeAll");
    }

    //@BeforeEach
    //void beforeEach() {
    //    System.out.println("@BeforeEach");
    //}

    @ParameterizedTest
    @DisplayName("Проверка расчета площади треугольника c неправильно заданными сторонами")
    @CsvSource({"0, 0, 0", "-1, -1, -1" , "1, 2, 10" , "0, -1, 1"})
    void exceptionWhenTriangleHasWrongSides(int firstSide, int secondSide, int thirdSide) {
        Assertions.assertThrows(WrongSidesException.class, () -> Triangle.CalculateSumTriangleBySides(firstSide, secondSide, thirdSide));
    }

    @ParameterizedTest
    @DisplayName("Проверка расчета площади треугольника с правильно заданными сторонами")
    @CsvSource({"1, 1, 1", "3, 3, 5" , "100, 110, 120"})
    void trueTriangleSide(int firstSide, int secondSide, int thirdSide) throws Exception {
        assertThat(Triangle.CalculateSumTriangleBySides(firstSide, secondSide, thirdSide)).isGreaterThan(0);
    }

    @Test
    @DisplayName("Проверка корректного результата расчета площади треугольника с правильно заданными сторонами")
    void checkCorrectResultOfSum () throws Exception {
        Assertions.assertEquals(Triangle.CalculateSumTriangleBySides(1, 1, 1), 0.4330127018922193);
        Assertions.assertEquals(Triangle.CalculateSumTriangleBySides(3, 3, 5), 4.14578098794425);
        Assertions.assertEquals(Triangle.CalculateSumTriangleBySides(100, 110, 120), 5152.123348678679);
    }


    //@AfterEach
    //void afterEach() {
    //    System.out.println("@AfterEach");
    //}

    //@AfterAll
    //static void afterAll() {
    //    System.out.println("@AfterAll");
    //}
}
