package com.sergey.benchmark;

/**
 /**
 * Класс для хранения результатов одного теста производительности
 * Является неизменяемым объектом-контейнером для данных
 *
 * @author Белявцев Сергей
 * @version 1.0
 * @see PerformanceTester
 */
public class Result {
    private final String operationName;
    private final int count;
    private final long timeInNanos;

    /**
     * Создает новый объект с результатами теста
     *
     * @param operationName Название проведенной операции (например, "Добавление в конец")
     * @param count         Количество выполненных операций
     * @param timeInNanos   Затраченное время в наносекундах
     */
    public Result(String operationName, int count, long timeInNanos) {
        this.operationName = operationName;
        this.count = count;
        this.timeInNanos = timeInNanos;
    }

    /**
     * Возвращает название операции.
     * @return Название операции.
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Возвращает количество выполненных операций.
     * @return Количество операций.
     */
    public int g
    public int getCount() {
        return count;
    }

    /**
     * Возвращает время выполнения в миллисекундах для удобства отображения
     * @return время в мс с десятичной частью
     */
    public double getTimeInMillis() {
        return timeInNanos / 1_000_000.0;
    }
}