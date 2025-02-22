package com.example.filterutil;

public class CommandLineParser {

    public static AppConfig parse(String[] args) {
        AppConfig config = new AppConfig();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-o":
                    if (i + 1 < args.length) {
                        config.setOutputDir(args[++i]);
                    } else {
                        System.err.println("Опция -o требует указания директории.");
                        printUsage();
                        System.exit(1);
                    }
                    break;
                case "-p":
                    if (i + 1 < args.length) {
                        config.setPrefix(args[++i]);
                    } else {
                        System.err.println("Опция -p требует указания префикса.");
                        printUsage();
                        System.exit(1);
                    }
                    break;
                case "-a":
                    config.setAppend(true);
                    break;
                case "-s":
                    config.setShortStats(true);
                    break;
                case "-f":
                    config.setFullStats(true);
                    break;
                default:
                    config.addInputFile(arg);
                    break;
            }
        }
        if (!config.isFullStats() && !config.isShortStats()) {
            config.setShortStats(true);
        }
        return config;
    }


    public static void printUsage() {
        System.out.println("Использование: java -jar util.jar [опции] <входной_файл1> <входной_файл2> ...");
        System.out.println("Опции:");
        System.out.println("  -o <outputDir>   Задает директорию для выходных файлов (по умолчанию текущая папка).");
        System.out.println("  -p <prefix>      Задает префикс для имён выходных файлов.");
        System.out.println("  -a               Режим добавления в существующие файлы.");
        System.out.println("  -s               Краткая статистика (только количество элементов).");
        System.out.println("  -f               Полная статистика (для чисел: мин, макс, сумма, среднее; для строк: длина мин и макс).");
    }
}
