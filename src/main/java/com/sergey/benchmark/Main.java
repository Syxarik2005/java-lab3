package com.sergey.benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Главный класс для запуска тестов производительности коллекций.
 * Оркестрирует выполнение тестов и выводит итоговый отчет в консоль.
 *
 * @author Белявцев Сергей
 * @version 1.0
 * @see PerformanceTester
 */
public class Main {
    private static final int OPERATIONS_COUNT = 100_000;

    /**
     * Точка входа в приложение.
     * @param args Аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        PerformanceTester tester = new PerformanceTester(OPERATIONS_COUNT);

        // Проводим тесты для ArrayList
        List<Result> arrayListResults = tester.test(new ArrayList<>());
        printTable("--- Тестирование ArrayList ---", arrayListResults);

        // Проводим тесты для LinkedList
        List<Result> linkedListResults = tester.test(new LinkedList<>());
        printTable("\n--- Тестирование LinkedList ---", linkedListResults);
    }

    /**
     * Печатает красивую таблицу с результатами тестов
     * @param title Заголовок таблицы
     * @param results Список результатов для вывода
     */
    private static void printTable(String title, List<Result> results) {
        System.out.println(title);
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-15s | %-20s |\n", "Метод", "Количество", "Время (ms)");
        System.out.println("--------------------------------------------------------------------------");

        for (Result result : results) {
            System.out.printf("| %-25s | %-15d | %-20.3f |\n",
                    result.getOperationName(),
                    result.getCount(),
                    result.getTimeInMillis());
        }
        System.out.println("--------------------------------------------------------------------------");
    }
}