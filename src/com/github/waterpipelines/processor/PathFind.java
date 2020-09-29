package com.github.waterpipelines.processor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class PathFind {

    private static PipelineNode getLowestDistanceNode(Set<PipelineNode> unsettledNodes) {
        PipelineNode lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (PipelineNode node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(PipelineNode evaluationNode,
                                                 Integer edgeWeigh, PipelineNode sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<PipelineNode> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static PipelineGraph calculateShortestPathFromSource(PipelineGraph graph, PipelineNode source) {
        source.setDistance(0);

        Set<PipelineNode> settledNodes = new HashSet<>();
        Set<PipelineNode> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            PipelineNode currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<PipelineNode, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                PipelineNode adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
}
