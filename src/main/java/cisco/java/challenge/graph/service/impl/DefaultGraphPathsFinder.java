package cisco.java.challenge.graph.service.impl;

import cisco.java.challenge.graph.domain.GNode;
import cisco.java.challenge.graph.domain.MutableGNodeWrapper;
import cisco.java.challenge.graph.service.GraphPathsFinder;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Executes graph walk with a depth-first search algorithm and returns a list of the visited elements.
 */
public class DefaultGraphPathsFinder implements GraphPathsFinder {

    @Override
    public List<List<GNode>> paths(GNode startingNode) {
        if (startingNode == null || startingNode.getChildren() == null || StringUtils.isBlank(startingNode.getName())) {
            return Collections.emptyList();
        }

        Stack<MutableGNodeWrapper> iterativeStack = new Stack<>();
        List<List<GNode>> resultList = new LinkedList<>();

        iterativeStack.add(MutableGNodeWrapper.copy(startingNode));

        while (!iterativeStack.empty()) {
            MutableGNodeWrapper currentNodeWrapper = iterativeStack.peek();

            if (currentNodeWrapper.hasNoChild()) {
                List<GNode> path = iterativeStack.stream().map(MutableGNodeWrapper::getNode).collect(Collectors.toList());
                resultList.add(path);
            }
            if (currentNodeWrapper.childrenAreVisited()) {
                iterativeStack.pop();
            } else {

                int index = currentNodeWrapper.getNextChildToVisitPointer();
                if (index < currentNodeWrapper.getChildrenSize()) {
                    MutableGNodeWrapper child = currentNodeWrapper.getChild(index);
                    iterativeStack.push(child);
                }
                currentNodeWrapper.setNextChildToVisitPointer(++index);
            }
        }
        return resultList;
    }
}
