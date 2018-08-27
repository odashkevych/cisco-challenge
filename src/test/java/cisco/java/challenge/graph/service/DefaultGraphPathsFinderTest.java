package cisco.java.challenge.graph.service;

import cisco.java.challenge.graph.domain.DefaultGNode;
import cisco.java.challenge.graph.domain.GNode;
import cisco.java.challenge.graph.service.impl.DefaultGraphPathsFinder;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultGraphPathsFinderTest extends GeneralGraphTest {

    private final GraphPathsFinder graphWalker = new DefaultGraphPathsFinder();

    @Test
    public void testGraphPathsAreEmptyWithNullInput() {
        List<List<GNode>> result = graphWalker.paths(null);
        assertThat(result).isEmpty();
    }

    @Test
    public void testGraphPathsHaveOneElementRoadForEmptyChildrenList() {
        DefaultGNode aloneNode = new DefaultGNode("some ID");
        List<List<GNode>> result = graphWalker.paths(aloneNode);
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).containsOnlyOnce(aloneNode);
    }

    @Test
    public void testReturnedCorrectGraphPath() {
        List<List<GNode>> result = graphWalker.paths(root1Node);

        assertThat(result).hasSize(10);

        assertThat(result.get(0)).hasSize(3).containsOnlyOnce(root1Node, child11Node, child111Node);
        assertThat(result.get(1)).hasSize(4).containsOnlyOnce(root1Node, child11Node, child112Node, child1121Node);
        assertThat(result.get(2)).hasSize(4).containsOnlyOnce(root1Node, child11Node, child112Node, child1122Node);
        assertThat(result.get(3)).hasSize(3).containsOnlyOnce(root1Node, child11Node, child113Node);

        assertThat(result.get(4)).hasSize(4).containsOnlyOnce(root1Node, child12Node, child11Node, child111Node);
        assertThat(result.get(5)).hasSize(5).containsOnlyOnce(root1Node, child12Node, child11Node, child112Node, child1121Node);
        assertThat(result.get(6)).hasSize(5).containsOnlyOnce(root1Node, child12Node, child11Node, child112Node, child1122Node);
        assertThat(result.get(7)).hasSize(4).containsOnlyOnce(root1Node, child12Node, child11Node, child113Node);
        assertThat(result.get(8)).hasSize(4).containsOnlyOnce(root1Node, child12Node, child121Node, child1211Node);

        assertThat(result.get(9)).hasSize(2).containsOnlyOnce(root1Node, child13Node);
    }

    @Test
    public void testReturnedCorrectGraphPathFromTheChildOfFirstLevel() {
        List<List<GNode>> result = graphWalker.paths(child12Node);

        assertThat(result).hasSize(5);

        assertThat(result.get(0)).hasSize(3).containsOnlyOnce(child12Node, child11Node, child111Node);
        assertThat(result.get(1)).hasSize(4).containsOnlyOnce(child12Node, child11Node, child112Node, child1121Node);
        assertThat(result.get(2)).hasSize(4).containsOnlyOnce(child12Node, child11Node, child112Node, child1122Node);
        assertThat(result.get(3)).hasSize(3).containsOnlyOnce(child12Node, child11Node, child113Node);
        assertThat(result.get(4)).hasSize(3).containsOnlyOnce(child12Node, child121Node, child1211Node);
    }
}
