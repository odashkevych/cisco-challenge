package cisco.java.challenge.graph.domain;

/**
 * GNode defines a graph element.
 */
public interface GNode {

    String getName();

    GNode[] getChildren();
}
