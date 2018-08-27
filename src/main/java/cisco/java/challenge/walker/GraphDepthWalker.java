package cisco.java.challenge.walker;

import cisco.java.challenge.domain.GNode;
import cisco.java.challenge.domain.TrackingGNodeWrapper;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Executes graph walk with a depth-first search algorithm and returns a list of the visited elements.
 */
public class GraphDepthWalker implements GraphWalker {

    @Override
    public List<GNode> walkGraph(GNode startingNode) {
        if (startingNode == null || startingNode.getChildren() == null || StringUtils.isBlank(startingNode.getName())) {
            return Collections.emptyList();
        }

        Stack<TrackingGNodeWrapper> iterativeStack = new Stack<>();
        List<GNode> resultList = new LinkedList<>();

        resultList.add(startingNode);
        iterativeStack.add(TrackingGNodeWrapper.copy(startingNode));

        while (!iterativeStack.empty()) {
            TrackingGNodeWrapper currentNode = iterativeStack.peek();

            if (!currentNode.hasChildren() || currentNode.isVisited()) {
                iterativeStack.pop();
                // [TODO] here we can copy result list as a single path and clean it
            } else {
                TrackingGNodeWrapper[] children = currentNode.getChildren();

                int i = currentNode.getNextChildToVisitPointer();
                if (i < children.length) {
                    TrackingGNodeWrapper child = children[i];
                    if (!resultList.contains(child.getNode())) {
                        iterativeStack.push(child);
                        resultList.add(child.getNode());
                    }
                }
            }
        }
        return resultList;
    }
}
