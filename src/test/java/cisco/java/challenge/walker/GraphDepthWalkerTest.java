package cisco.java.challenge.walker;

import cisco.java.challenge.domain.DefaultGNode;
import cisco.java.challenge.domain.GNode;
import org.junit.Test;

import java.util.List;

public class GraphDepthWalkerTest {

    private final GraphWalker graphWalker = new GraphDepthWalker();

    @Test
    public void testGraphWithNullChildrenList() {

        GNode node = new DefaultGNode();
        List<GNode> result = graphWalker.walkGraph(node);

    }
}
