package com.sergey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

 /**
 * Класс для тестирования и сравнения производительности
 */
public class PerformanceTester {

    private final int operationsCount;

     /**
      * Создает тестер производительности
      * @param operationsCount количество операций для каждого теста.
      */
    public PerformanceTester(int operationsCount) {
        this.operationsCount = operationsCount;
    }

     /**
      * Запускает полный набор тестов для ArrayList и LinkedList.
      */
    public void runTests() {
        System.out.println("--- Тестирование ArrayList ---");
        testList(new ArrayList<>());

        System.out.println("\n--- Тестирование LinkedList ---");
        testList(new LinkedList<>());
    }

     /**
      * Проводит серию тестов для конкретной реализации List.
      * @param list экземпляр списка (ArrayList или LinkedList).
      */
    private void testList(List<Object> list) {
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("| %-25s | %-15s | %-15s |\n", "Метод", "Количество", "Время");
        System.out.println("---------------------------------------------------------------------");
        Object element = new Object();

        // --- Тест 1: Добавление в конец ---
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.add(element);
        }
        long endTime = System.currentTimeMillis();
        printResult("Добавление в конец", endTime - startTime);

        // --- Тест 2: Чтение из середины ---
        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.get(list.size() / 2);
        }
        endTime = System.currentTimeMillis();
        printResult("Чтение из середины", endTime - startTime);

        // --- Тест 3: Добавление в середину ---
        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount / 100; i++) { // Уменьшаем число операций, иначе будет СЛИШКОМ долго
            list.add(list.size() / 2, element);
        }
        endTime = System.currentTimeMillis();
        // Приводим результат к общему масштабу для сравнения
        printResult("Добавление в середину", (endTime - startTime) * 100);

        // --- Тест 4: Удаление с конца ---
        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            // Удаляем с конца, пока список не станет маленьким
            if (list.size() > 10) {
                list.remove(list.size() - 1);
            }
        }
        endTime = System.currentTimeMillis();
        printResult("Удаление с конца", endTime - startTime);

        // --- Тест 3: Добавление в начало ---
        list.clear();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            list.add(0, element);
        }
        endTime = System.currentTimeMillis();
        printResult("Добавление в начало", endTime - startTime);

        // --- Тест 4: Удаление из начала ---
        startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsCount; i++) {
            if (!list.isEmpty()) {
                list.remove(0);
            }
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