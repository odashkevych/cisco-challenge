package cisco.java.challenge.graph.service.impl;

import cisco.java.challenge.graph.domain.GNode;
import cisco.java.challenge.graph.domain.MutableGNodeWrapper;
import cisco.java.challenge.graph.service.GraphWalker;
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

        Stack<MutableGNodeWrapper> iterativeStack = new Stack<>();
        List<GNode> resultList = new LinkedList<>();

        resultList.add(startingNode);
        iterativeStack.add(MutableGNodeWrapper.copy(startingNode));

        while (!iterativeStack.empty()) {
            MutableGNodeWrapper currentNodeWrapper = iterativeStack.peek();

            if (currentNodeWrapper.hasNoChild() || currentNodeWrapper.childrenAreVisited()) {
                iterativeStack.pop();
            } else {
                int index = currentNodeWrapper.getNextChildToVisitPointer();
                if (index < currentNodeWrapper.getChildrenSize()) {
                    MutableGNodeWrapper child = currentNodeWrapper.getChild(index);
                    if (!resultList.contains(child.getNode())) {
                        iterativeStack.push(child);
                        resultList.add(child.getNode());
                    }
                }
                currentNodeWrapper.setNextChildToVisitPointer(++index);
            }
        }
        return resultList;
    }
}
