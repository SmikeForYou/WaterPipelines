package com.github.waterpipelines.services;

import com.github.waterpipelines.models.PipeModel;
import com.github.waterpipelines.processor.PipelineGraph;
import com.github.waterpipelines.processor.PipelineNode;

import java.util.*;

public class GraphInitializer {
    public static List<PipelineNode> SetUpNodes(List<PipeModel> pipes) {
        HashMap<String, PipelineNode> res = new HashMap<>();
        for (PipeModel p: pipes) {
            String nameX = p.getIdX();
            String nameY = p.getIdY();
            if (res.get(nameX) == null) {
                res.put(nameX, new PipelineNode(nameX));
            }
            if (res.get(nameY) == null) {
                res.put(nameY, new PipelineNode(nameY));
            }
            res.get(nameX).addDestination(res.get(nameY), p.getDistance());
        }
        return new ArrayList<>(res.values());
    }
    public static PipelineGraph SetUpGraph(List<PipelineNode> nodes){
        PipelineGraph graph = new PipelineGraph();
        for (PipelineNode n:nodes) {
            graph.addNode(n);
        }
        return graph;
    }

}
