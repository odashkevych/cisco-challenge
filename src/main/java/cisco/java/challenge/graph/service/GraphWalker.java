package cisco.java.challenge.graph.service;

import cisco.java.challenge.graph.domain.GNode;

import java.util.List;

/**
 * Executes graph walk and collecting child elements for income node element.
 */
public interface GraphWalker {

    /**
     * Walks a graph from starting node and returns it's child nodes {@link List}
     *
     * @param startingNode node to start
     * @return collected child elements. In case startingNode is {@code null} or it's {@link GNode#getChildren()} is empty
     * returns empty unmodifiable list.
     */
    List<GNode> walkGraph(GNode startingNode);
}
