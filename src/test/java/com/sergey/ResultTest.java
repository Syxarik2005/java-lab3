package com.sergey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-тесты для класса Result.
 */
class ResultTest {

    @Test
    void testResultObjectCreationAndGetters() {
        // Arrange (Подготовка)
        String opName = "Тестовая операция";
        int count = 1000;
        long timeNanos = 5_000_000; // 5 миллионов наносекунд

        // Act (Действие)
        Result result = new Result(opName, count, timeNanos);

        // Assert (Проверка)
        assertNotNull(result);
        assertEquals(opName, result.getOperationName());
        assertEquals(count, result.getCount());
    }

    @Test
    void testGetTimeInMillisConversion() {
        // Arrange
        long timeNanos = 1_500_000; // 1.5 миллиона наносекунд
        Result result = new Result("test", 1, timeNanos);

        // Act
        double timeMillis = result.getTimeInMillis();

        // Assert
        // Проверяем, что 1,500,000 наносекунд правильно конвертируются в 1.5 миллисекунды
        // Третий параметр (дельта) нужен для сравнения чисел с плавающей точкой
        assertEquals(1.5, timeMillis, 0.00001);
    }
}