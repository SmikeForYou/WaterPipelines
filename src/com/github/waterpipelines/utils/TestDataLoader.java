package com.github.waterpipelines.utils;

import com.github.waterpipelines.models.PipeModel;
import com.github.waterpipelines.models.TestDataModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDataLoader extends CSVReader {

    public TestDataLoader(String path) {
        super(path);
    }

    public ArrayList<TestDataModel> Load() throws IOException {
        List<String[]> raw = this.ReadCSV();
        ArrayList<TestDataModel> result = new ArrayList<>(0);
        for (String[] i:raw) {
            TestDataModel model = new TestDataModel();
            model.setIdA(i[0]);
            model.setIdB(i[1]);
            result.add(model);
        }
        return result;
    }
}
