package cisco.java.challenge.graph.domain;

import java.util.Arrays;

public class MutableGNodeWrapper {

    private GNode node;
    private boolean childrenCopied;
    private int nextChildToVisitPointer = 0;
    private MutableGNodeWrapper[] children;
    private int lastChildPointer = -1;

    private MutableGNodeWrapper(GNode node) {
        this.node = node;
        this.children = new MutableGNodeWrapper[node.getChildren().length];
    }

    public static MutableGNodeWrapper copy(GNode node) {
        return new MutableGNodeWrapper(node);
    }

    public boolean childrenAreVisited() {
        return nextChildToVisitPointer == children.length;
    }

    private void addChildrenIfNotCopied() {
        if (!childrenCopied) {
            for (GNode child : node.getChildren()) {
                children[++lastChildPointer] = copy(child);
            }
            childrenCopied = true;
        }
    }

    public boolean hasNoChild() {
        addChildrenIfNotCopied();
        return lastChildPointer == -1;
    }

    public int getChildrenSize() {
        addChildrenIfNotCopied();
        return children.length;
    }

    public MutableGNodeWrapper getChild(int index) {
        addChildrenIfNotCopied();
        return children[index];
    }

    public GNode getNode() {
        return node;
    }

    @Override
    public String toString() {
        return "MutableGNodeWrapper{" +
            "node=" + node +
            ", childrenCopied=" + childrenCopied +
            ", children=" + Arrays.toString(children) +
            ", lastChildPointer=" + lastChildPointer +
            '}';
    }

    public int getNextChildToVisitPointer() {
        return nextChildToVisitPointer;
    }

    public void setNextChildToVisitPointer(int nextChildToVisitPointer) {
        this.nextChildToVisitPointer = nextChildToVisitPointer;
    }
}
