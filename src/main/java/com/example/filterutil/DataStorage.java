package com.example.filterutil;
import java.util.ArrayList;
import java.util.List;


public class DataStorage {
    private List<Long> integers = new ArrayList<>();
    private List<Double> floats = new ArrayList<>();
    private List<String> strings = new ArrayList<>();

    public List<Long> getIntegers() {
        return integers;
    }
    public List<Double> getFloats() {
        return floats;
    }
    public List<String> getStrings() {
        return strings;
    }

    public void addInteger(long value) {
        integers.add(value);
    }
    public void addFloat(double value) {
        floats.add(value);
    }
    public void addString(String value) {
        strings.add(value);
    }
}
