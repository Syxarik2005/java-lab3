package com.sergey;

/**
 * Класс для хранения результатов одного теста производительности
 */
public class Result {
    private final String operationName;
    private final int count;
    private final long timeInNanos;

    public Result(String operationName, int count, long timeInNanos) {
        this.operationName = operationName;
        this.count = count;
        this.timeInNanos = timeInNanos;
    }

    public String getOperationName() {
        return operationName;
    }

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