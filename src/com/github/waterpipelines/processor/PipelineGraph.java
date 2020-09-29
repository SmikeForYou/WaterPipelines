package com.github.waterpipelines.processor;

import java.util.HashSet;
import java.util.Set;

public class PipelineGraph {
    private Set<PipelineNode> nodes = new HashSet<>();

    public void addNode(PipelineNode nodeA) {
        nodes.add(nodeA);
    }

    public PipelineNode getNode(String name){
        for(PipelineNode n: this.nodes){
            if (n.getName().equals(name)) {
                return n;
            }
        }
        return null;
    }
    public int getDistance(String startNode, String endNode) {
        PipelineGraph calculated =  PathFind.calculateShortestPathFromSource(this, this.getNode(startNode));
        for (PipelineNode n:calculated.nodes) {
            if (n.getName().equals(endNode)) {
                return n.getDistance();
            }
        }
        return Integer.MAX_VALUE;
    }

}
