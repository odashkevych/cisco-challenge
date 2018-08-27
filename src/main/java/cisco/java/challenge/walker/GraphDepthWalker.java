package cisco.java.challenge.walker;

import cisco.java.challenge.domain.GNode;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * Executes graph walk with a Depth-first search algorithm and returns a list of the visited elements.
 */
public class GraphDepthWalker implements GraphWalker {


    @Override
    public List<GNode> walkGraph(GNode startingNode) {
        if (startingNode == null || startingNode.getChildren() == null || StringUtils.isBlank(startingNode.getName())) {
            return Collections.emptyList();
        }

        return null;
    }
}
