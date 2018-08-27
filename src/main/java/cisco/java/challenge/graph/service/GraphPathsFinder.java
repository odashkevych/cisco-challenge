package cisco.java.challenge.graph.service;

import cisco.java.challenge.graph.domain.GNode;

import java.util.List;

/**
 * Makes search of possible paths to children without leaves from the given starting node.
 */
public interface GraphPathsFinder {

    /**
     * Collects the list of possible paths grouped in the {@link List} of nodes
     *
     * @param startingNode node to start search
     * @return collected paths
     */
    List<List<GNode>> paths(GNode startingNode);
}
