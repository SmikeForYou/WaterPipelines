package com.github.waterpipelines.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    protected String path;
    protected String separator = ";";

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public CSVReader(String path) {
        this.path = path;
    }
    protected List<String[]> ReadCSV() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(this.path));
        String row;
        List<String[]> result = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            String[] data;
            data = row.split(this.separator);
            result.add(data);
        }
        csvReader.close();
        return result;
    }
}
