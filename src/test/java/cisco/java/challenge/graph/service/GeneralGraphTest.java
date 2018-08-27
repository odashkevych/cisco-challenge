package cisco.java.challenge.graph.service;

import cisco.java.challenge.graph.domain.DefaultGNode;
import cisco.java.challenge.graph.domain.GNode;
import org.junit.Before;

import java.util.LinkedList;
import java.util.List;

public class GeneralGraphTest {

    /*
     * Defines graph test data in the view of
     *
     *              г---[111]
     *              |          г--[1121]
     *         г--[11]--[112]--|
     *         |    |          L--[1122]
     *         |    |
     * [1] ----|--[12]--[121]-----[1211]
     *         |
     *         |
     *         L--[13]
     *
     * */

    List<GNode> allNodes;
    DefaultGNode root1Node;
    DefaultGNode child11Node;
    DefaultGNode child12Node;
    DefaultGNode child13Node;
    DefaultGNode child111Node;
    DefaultGNode child112Node;
    DefaultGNode child113Node;
    DefaultGNode child121Node;
    DefaultGNode child1121Node;
    DefaultGNode child1122Node;
    DefaultGNode child1211Node;

    @Before
    public void setUp() {
        allNodes = new LinkedList<>();
        root1Node = new DefaultGNode("1");

        /* first level children */
        child11Node = new DefaultGNode("11");
        child12Node = new DefaultGNode("12");
        child13Node = new DefaultGNode("13");
        root1Node.setChildren(child11Node, child12Node, child13Node);

        /* second level children */
        child111Node = new DefaultGNode("111");
        child112Node = new DefaultGNode("112");
        child113Node = new DefaultGNode("113");
        child11Node.setChildren(child111Node, child112Node, child113Node);

        child121Node = new DefaultGNode("121");
        child12Node.setChildren(child11Node, child121Node); // '11' node is child for '1' and '12' nodes.

        /* third level children */
        child1121Node = new DefaultGNode("1121");
        child1122Node = new DefaultGNode("1122");
        child112Node.setChildren(child1121Node, child1122Node);

        child1211Node = new DefaultGNode("1211");
        child121Node.setChildren(child1211Node);

        allNodes.add(root1Node);
        allNodes.add(child11Node);
        allNodes.add(child12Node);
        allNodes.add(child13Node);
        allNodes.add(child111Node);
        allNodes.add(child112Node);
        allNodes.add(child113Node);
        allNodes.add(child121Node);
        allNodes.add(child1121Node);
        allNodes.add(child1122Node);
        allNodes.add(child1211Node);
    }

}
