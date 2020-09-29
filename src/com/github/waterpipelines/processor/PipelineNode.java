package com.github.waterpipelines.processor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PipelineNode {
    private String name;

    private List<PipelineNode> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<PipelineNode, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(PipelineNode destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public PipelineNode(String name) {
        this.name = name;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public Map<PipelineNode, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setShortestPath(List<PipelineNode> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<PipelineNode> getShortestPath() {
        return shortestPath;
    }

    public String getName() {
        return name;
    }
}
