package com.sergey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для проведения тестов производительности.
 * Создает список объектов Result с результатами тестов.
 */
public class PerformanceTester {

    private final int operationsCount;
    private final Object element = new Object();

    /**
     * Создает тестер производительности.
     * @param operationsCount базовое количество операций для быстрых тестов.
     */
    public PerformanceTester(int operationsCount) {
        this.operationsCount = operationsCount;
    }

    /**
     * Проводит серию из 9 тестов производительности для конкретной реализации List
     * @param list экземпляр списка
     * @return Список объектов Result с результатами тестов
     */
    public List<Result> test(List<Object> list) {
        List<Result> results = new ArrayList<>();
        int slowOpsCount = operationsCount / 100;

        // --- ADD ---
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) list.add(element);
        long endTime = System.nanoTime();
        results.add(new Result("Добавление в конец", operationsCount, endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < slowOpsCount; i++) list.add(list.size() / 2, element);
        endTime = System.nanoTime();
        results.add(new Result("Добавление в середину", slowOpsCount, endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < slowOpsCount; i++) list.add(0, element);
        endTime = System.nanoTime();
        results.add(new Result("Добавление в начало", slowOpsCount, endTime - startTime));

        // --- GET ---
        startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) list.get(0);
        endTime = System.nanoTime();
        results.add(new Result("Чтение с начала", operationsCount, endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) list.get(list.size() / 2);
        endTime = System.nanoTime();
        results.add(new Result("Чтение из середины", operationsCount, endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) list.get(list.size() - 1);
        endTime = System.nanoTime();
        results.add(new Result("Чтение с конца", operationsCount, endTime - startTime));

        // --- REMOVE ---
        startTime = System.nanoTime();
        for (int i = 0; i < slowOpsCount; i++) list.remove(list.size() - 1);
        endTime = System.nanoTime();
        results.add(new Result("Удаление с конца", slowOpsCount, endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < slowOpsCount; i++) list.remove(list.size() / 2);
        endTime = System.nanoTime();
        results.add(new Result("Удаление из середины", slowOpsCount, endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < slowOpsCount; i++) list.remove(0);
        endTime = System.nanoTime();
        results.add(new Result("Удаление с начала", slowOpsCount, endTime - startTime));

        return results;
    }
}