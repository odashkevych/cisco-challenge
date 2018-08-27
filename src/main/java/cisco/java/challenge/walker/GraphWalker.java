package cisco.java.challenge.walker;

import cisco.java.challenge.domain.GNode;

import java.util.List;

/**
 * Executes graph walk and collecting child elements for income node element.
 */
public interface GraphWalker {

    List<GNode> walkGraph(GNode startingNode);
}
