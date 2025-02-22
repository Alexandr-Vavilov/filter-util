package com.example.filterutil;


public class FilterUtilMain {
    public static void main(String[] args) {

        AppConfig config = CommandLineParser.parse(args);
        if (config.getInputFiles().isEmpty()) {
            System.err.println("Не указаны входные файлы.");
            CommandLineParser.printUsage();
            System.exit(1);
        }

        DataStorage storage = new DataStorage();

        FileProcessor processor = new FileProcessor(storage);
        for (String fileName : config.getInputFiles()) {
            processor.processFile(fileName);
        }

        OutputWriter writer = new OutputWriter(config);
        writer.writeOutputs(storage);

        StatisticsPrinter statsPrinter = new StatisticsPrinter(storage, config);
        statsPrinter.printStatistics();
    }
}
