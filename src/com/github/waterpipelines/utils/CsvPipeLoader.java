package com.github.waterpipelines.utils;

import com.github.waterpipelines.models.PipeModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvPipeLoader extends CSVReader{

    public CsvPipeLoader(String path) {
        super(path);
    }

    public ArrayList<PipeModel> Load() throws IOException {
        List<String[]> raw = this.ReadCSV();
        ArrayList<PipeModel> result = new ArrayList<>(0);
        for (String[] i:raw) {
            PipeModel model = new PipeModel();
            model.setIdX(i[0]);
            model.setIdY(i[1]);
            model.setDistance(Integer.parseInt(i[2]));
            result.add(model);
        }
        return result;
    }
}
