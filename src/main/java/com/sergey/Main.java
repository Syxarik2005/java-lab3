package com.sergey;

public class Main {
    // Определим количество операций как константу.
    // Начнем со 100 000, чтобы разница была заметна.
    private static final int OPERATIONS_COUNT = 100_000;

    public static void main(String[] args) {
        PerformanceTester tester = new PerformanceTester(OPERATIONS_COUNT);
        tester.runTests();
    }
}