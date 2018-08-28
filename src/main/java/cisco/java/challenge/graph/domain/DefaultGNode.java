package cisco.java.challenge.graph.domain;

import java.util.Arrays;
import java.util.Objects;

public class DefaultGNode implements GNode {
    private final String name;

    private DefaultGNode[] children;

    public DefaultGNode(String name) {
        this.name = name;
        this.children = new DefaultGNode[0];
    }

    @Override
    public String getName() {
        return name;
    }

    public void setChildren(DefaultGNode... children) {
        this.children = children;
    }

    @Override
    public GNode[] getChildren() {
        return Arrays.copyOf(children, children.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultGNode that = (DefaultGNode) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
