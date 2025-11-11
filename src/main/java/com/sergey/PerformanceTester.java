package com.sergey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для тестирования и сравнения производительности реализаций интерфейса List
 */
public class PerformanceTester {

    private final int operationsCount;
    private final Object element = new Object();

    /**
     * Создает тестер производительности
     * @param operationsCount количество операций для каждого теста
     */
    public PerformanceTester(int operationsCount) {
        this.operationsCount = operationsCount;
    }

    /**
     * Запускает полный набор тестов для ArrayList и LinkedList
     */
    public void runTests() {
        System.out.println("--- Тестирование ArrayList ---");
        testList(new ArrayList<>());

        System.out.println("\n--- Тестирование LinkedList ---");
        testList(new LinkedList<>());
    }

    /**
     * Проводит серию из 9 тестов производительности для конкретной реализации List
     * @param list экземпляр списка (например, new ArrayList<>())
     */
    private void testList(List<Object> list) {
        printHeader();

        // Для медленных операций будем использовать меньшее количество, чтобы не ждать вечность.
        int slowOpsCount = operationsCount / 100;

        // --- ГРУППА ТЕСТОВ: ADD ---
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.add(element); // Этот тест заодно наполняет список.
        }
        long endTime = System.currentTimeMillis();
        printResult("Добавление в конец", operationsCount, endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < slowOpsCount; i++) {
            list.add(list.size() / 2, element);
        }
        endTime = System.currentTimeMillis();
        printResult("Добавление в середину", slowOpsCount, endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < slowOpsCount; i++) {
            list.add(0, element);
        }
        endTime = System.currentTimeMillis();
        printResult("Добавление в начало", slowOpsCount, endTime - startTime);

        // --- ГРУППА ТЕСТОВ: GET ---
        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.get(0);
        }
        endTime = System.currentTimeMillis();
        printResult("Чтение с начала", operationsCount, endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.get(list.size() / 2);
        }
        endTime = System.currentTimeMillis();
        printResult("Чтение из середины", operationsCount, endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.get(list.size() - 1);
        }
        endTime = System.currentTimeMillis();
        printResult("Чтение с конца", operationsCount, endTime - startTime);

        // --- ГРУППА ТЕСТОВ: REMOVE ---
        startTime = System.currentTimeMillis();
        for (int i = 0; i < slowOpsCount; i++) {
            list.remove(list.size() - 1);
        }
        endTime = System.currentTimeMillis();
        printResult("Удаление с конца", slowOpsCount, endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < slowOpsCount; i++) {
            list.remove(list.size() / 2);
        }
        endTime = System.currentTimeMillis();
        printResult("Удаление из середины", slowOpsCount, endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < slowOpsCount; i++) {
            list.remove(0);
        }
        endTime = System.currentTimeMillis();
        printResult("Удаление с начала", slowOpsCount, endTime - startTime);

        printFooter();
    }

    // --- Вспомогательные методы ---
    private void printHeader() {
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("| %-25s | %-15s | %-15s |\n", "Метод", "Количество", "Время (ms)");
        System.out.println("---------------------------------------------------------------------");
    }

    private void printFooter() {
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Красивый вывод. Теперь он принимает реальное количество операций
     */
    private void printResult(String operation, int count, long time) {
        System.out.printf("| %-25s | %-15d | %-15d |\n", operation, count, time);
    }
}