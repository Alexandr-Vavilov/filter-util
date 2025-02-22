package com.example.filterutil;
import java.util.Collections;

public class StatisticsPrinter {
    private DataStorage storage;
    private AppConfig config;

    public StatisticsPrinter(DataStorage storage, AppConfig config) {
        this.storage = storage;
        this.config = config;
    }

    public void printStatistics() {
        System.out.println("=== Статистика ===");
        printIntegersStatistics();
        printFloatsStatistics();
        printStringsStatistics();
    }

    private void printIntegersStatistics() {
        if (!storage.getIntegers().isEmpty()) {
            int count = storage.getIntegers().size();
            System.out.println("Целые числа: количество = " + count);
            if (config.isFullStats()) {
                long min = Collections.min(storage.getIntegers());
                long max = Collections.max(storage.getIntegers());
                long sum = 0;
                for (long val : storage.getIntegers()) {
                    sum += val;
                }
                double avg = (double) sum / count;
                System.out.println("  Минимальное: " + min);
                System.out.println("  Максимальное: " + max);
                System.out.println("  Сумма: " + sum);
                System.out.println("  Среднее: " + avg);
            }
        } else {
            System.out.println("Целых чисел не найдено.");
        }
    }

    private void printFloatsStatistics() {
        if (!storage.getFloats().isEmpty()) {
            int count = storage.getFloats().size();
            System.out.println("Вещественные числа: количество = " + count);
            if (config.isFullStats()) {
                double min = Collections.min(storage.getFloats());
                double max = Collections.max(storage.getFloats());
                double sum = 0.0;
                for (double val : storage.getFloats()) {
                    sum += val;
                }
                double avg = sum / count;
                System.out.println("  Минимальное: " + min);
                System.out.println("  Максимальное: " + max);
                System.out.println("  Сумма: " + sum);
                System.out.println("  Среднее: " + avg);
            }
        } else {
            System.out.println("Вещественных чисел не найдено.");
        }
    }

    private void printStringsStatistics() {
        if (!storage.getStrings().isEmpty()) {
            int count = storage.getStrings().size();
            System.out.println("Строки: количество = " + count);
            if (config.isFullStats()) {
                int minLength = Integer.MAX_VALUE;
                int maxLength = Integer.MIN_VALUE;
                for (String s : storage.getStrings()) {
                    int len = s.length();
                    if (len < minLength) {
                        minLength = len;
                    }
                    if (len > maxLength) {
                        maxLength = len;
                    }
                }
                System.out.println("  Длина самой короткой строки: " + minLength);
                System.out.println("  Длина самой длинной строки: " + maxLength);
            }
        } else {
            System.out.println("Строк не найдено.");
        }
    }
}
