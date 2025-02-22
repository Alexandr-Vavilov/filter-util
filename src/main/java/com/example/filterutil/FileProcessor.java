package com.example.filterutil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
    private DataStorage storage;

    public FileProcessor(DataStorage storage) {
        this.storage = storage;
    }

    public void processFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Файл не найден или не является файлом: " + fileName);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                processLine(line, fileName, lineNumber);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла " + fileName + ": " + e.getMessage());
        }
    }

    private void processLine(String line, String fileName, int lineNumber) {
        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            return;
        }
        try {
            long intValue = Long.parseLong(trimmed);
            storage.addInteger(intValue);
        } catch (NumberFormatException e1) {
            try {
                double floatValue = Double.parseDouble(trimmed);
                storage.addFloat(floatValue);
            } catch (NumberFormatException e2) {
                storage.addString(trimmed);
            }
        }
    }
}
