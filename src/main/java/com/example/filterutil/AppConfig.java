package com.example.filterutil;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {
    private String outputDir = ".";
    private String prefix = "";
    private boolean append = false;
    private boolean fullStats = false;
    private boolean shortStats = false;
    private List<String> inputFiles = new ArrayList<>();

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    public boolean isFullStats() {
        return fullStats;
    }

    public void setFullStats(boolean fullStats) {
        this.fullStats = fullStats;
    }

    public boolean isShortStats() {
        return shortStats;
    }

    public void setShortStats(boolean shortStats) {
        this.shortStats = shortStats;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public void addInputFile(String inputFile) {
        this.inputFiles.add(inputFile);
    }
}
