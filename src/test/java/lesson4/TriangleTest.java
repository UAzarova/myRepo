package lesson4;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {
    //@BeforeAll
    //static void beforeAll() {
    //    System.out.println("@BeforeAll");
    //}

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

    //@AfterEach
    //void afterEach() {
    //    System.out.println("@AfterEach");
    //}

    //@AfterAll
    //static void afterAll() {
    //    System.out.println("@AfterAll");
    //}
}
