package cisco.java.challenge.graph.service;

import cisco.java.challenge.graph.domain.DefaultGNode;
import cisco.java.challenge.graph.domain.GNode;
import cisco.java.challenge.graph.service.impl.GraphDepthWalker;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphDepthWalkerTest extends GeneralGraphTest {
    private final GraphWalker graphWalker = new GraphDepthWalker();

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
    }
}
