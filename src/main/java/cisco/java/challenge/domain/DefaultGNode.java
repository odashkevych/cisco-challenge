package cisco.java.challenge.domain;

public class DefaultGNode implements GNode{
    @Override
    public String getName() {
        return null;
    }

    @Override
    public GNode[] getChildren() {
        return new GNode[0];
    }
}
