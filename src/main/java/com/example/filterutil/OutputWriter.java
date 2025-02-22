package com.example.filterutil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWriter {
    private AppConfig config;

    public OutputWriter(AppConfig config) {
        this.config = config;
    }

    public void writeOutputs(DataStorage storage) {
        File outDir = new File(config.getOutputDir());
        if (!outDir.exists()) {
            if (!outDir.mkdirs()) {
                System.err.println("Не удалось создать директорию: " + config.getOutputDir());
                return;
            }
        }
        if (!storage.getIntegers().isEmpty()) {
            String intFileName = config.getOutputDir() + File.separator + config.getPrefix() + "integers.txt";
            writeListToFile(storage.getIntegers(), intFileName);
        }
        if (!storage.getFloats().isEmpty()) {
            String floatFileName = config.getOutputDir() + File.separator + config.getPrefix() + "floats.txt";
            writeListToFile(storage.getFloats(), floatFileName);
        }
        if (!storage.getStrings().isEmpty()) {
            String stringFileName = config.getOutputDir() + File.separator + config.getPrefix() + "strings.txt";
            writeListToFile(storage.getStrings(), stringFileName);
        }
    }

    private void writeListToFile(List<?> list, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, config.isAppend()))) {
            for (Object obj : list) {
                bw.write(obj.toString());
                bw.newLine();
            }
            System.out.println("Записан файл: " + path);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла " + path + ": " + e.getMessage());
        }
    }
}
