package com.sergey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTester {

    private final int operationsCount;

    public PerformanceTester(int operationsCount) {
        this.operationsCount = operationsCount;
    }

    public void runTests() {
        System.out.println("--- Тестирование ArrayList ---");
        testList(new ArrayList<>());

        System.out.println("\n--- Тестирование LinkedList ---");
        testList(new LinkedList<>());
    }

    private void testList(List<Object> list) {
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("| %-25s | %-15s | %-15s |\n", "Метод", "Количество", "Время");
        System.out.println("---------------------------------------------------------------------");

        // --- Тесты на добавление (add) ---
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.add(new Object()); // Добавление в конец
        }
        long endTime = System.currentTimeMillis();
        printResult("Добавление в конец", endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.add(0, new Object()); // Добавление в начало
        }
        endTime = System.currentTimeMillis();
        printResult("Добавление в начало", endTime - startTime);

        // --- Тесты на чтение (get) ---
        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.get(list.size() / 2); // Чтение из середины
        }
        endTime = System.currentTimeMillis();
        printResult("Чтение из середины", endTime - startTime);

        // --- Тесты на удаление (remove) ---
        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.remove(0); // Удаление из начала
        }
        endTime = System.currentTimeMillis();
        printResult("Удаление из начала", endTime - startTime);

        System.out.println("---------------------------------------------------------------------");
    }


    // Вспомогательный метод для красивого вывода
    private void printResult(String operation, long time) {
        System.out.printf("| %-25s | %-15d | %-15d ms |\n", operation, operationsCount, time);
    }
}