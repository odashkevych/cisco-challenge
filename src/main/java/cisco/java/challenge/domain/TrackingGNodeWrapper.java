package cisco.java.challenge.domain;

import java.util.Arrays;

public class TrackingGNodeWrapper implements GNode {

    private GNode node;
    private boolean childrenCopied;
    private int nextChildToVisitPointer;

    private TrackingGNodeWrapper[] children;

    private int lastChildPointer = -1;

    private TrackingGNodeWrapper(GNode node) {
        this.node = node;
        this.children = new TrackingGNodeWrapper[node.getChildren().length];
    }

    public static TrackingGNodeWrapper copy(GNode node) {
        return new TrackingGNodeWrapper(node);
    }

    public boolean isVisited() {
        return nextChildToVisitPointer == children.length;
    }

    private synchronized void addChildrenIfNotCopied() {
        if (!childrenCopied) {
            for (GNode child : node.getChildren()) {
                children[++lastChildPointer] = copy(child);
            }
            childrenCopied = true;
        }
    }

    public boolean hasChildren() {
        addChildrenIfNotCopied();
        return lastChildPointer != -1;
    }

    @Override
    public String getName() {
        return node.getName();
    }

    @Override
    public TrackingGNodeWrapper[] getChildren() {
        addChildrenIfNotCopied();
        return children;
    }

    public GNode getNode() {
        return node;
    }

    @Override
    public String toString() {
        return "TrackingGNodeWrapper{" +
            "node=" + node +
            ", childrenCopied=" + childrenCopied +
            ", children=" + Arrays.toString(children) +
            ", lastChildPointer=" + lastChildPointer +
            '}';
    }

    public int getNextChildToVisitPointer() {
        return nextChildToVisitPointer++;
    }
}
