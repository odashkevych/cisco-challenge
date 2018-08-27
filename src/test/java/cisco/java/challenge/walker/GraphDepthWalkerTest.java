package cisco.java.challenge.walker;

import cisco.java.challenge.domain.DefaultGNode;
import cisco.java.challenge.domain.GNode;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphDepthWalkerTest {

    private final GraphWalker graphWalker = new GraphDepthWalker();
    private DefaultGNode root1Node;
    private List<GNode> allNodes;

    @Before
    public void setUp() {
        allNodes = new LinkedList<>();
        root1Node = new DefaultGNode("1");

        /* first level children */
        DefaultGNode child11Node = new DefaultGNode("11");
        DefaultGNode child12Node = new DefaultGNode("12");
        DefaultGNode child13Node = new DefaultGNode("13");
        root1Node.setChildren(child11Node, child12Node, child13Node);

        /* second level children */
        DefaultGNode child111Node = new DefaultGNode("111");
        DefaultGNode child112Node = new DefaultGNode("112");
        DefaultGNode child113Node = new DefaultGNode("113");
        child11Node.setChildren(child111Node, child112Node, child113Node);

        DefaultGNode child121Node = new DefaultGNode("121");
        child12Node.setChildren(child11Node, child121Node); // '11' node is child for '1' and '12' nodes.

        /* third level children */
        DefaultGNode child1121Node = new DefaultGNode("1121");
        DefaultGNode child1122Node = new DefaultGNode("1122");
        child112Node.setChildren(child1121Node, child1122Node);

        DefaultGNode child1211Node = new DefaultGNode("1211");
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

    @Test
    public void testGraphWithNullInput() {
        List<GNode> result = graphWalker.walkGraph(null);
        assertThat(result).isEmpty();
    }

    @Test
    public void testGraphWithEmptyChildrenList() {
        DefaultGNode aloneNode = new DefaultGNode("some ID");
        List<GNode> result = graphWalker.walkGraph(aloneNode);
        assertThat(result).containsOnly(aloneNode);
    }

    @Test
    public void testReturnedAllUniqueGraphElements() {
        List<GNode> result = graphWalker.walkGraph(root1Node);
        assertThat(result).containsOnlyOnce(allNodes.toArray(new GNode[0]));
        System.out.println(result);
    }
}
