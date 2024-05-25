import java.util.*;

public class MyGraph<V> extends WeightedGraph<V> {
    public MyGraph(boolean undirected) {
        super(undirected);
    }

    public void addEdge(V source, V dest) {
        super.addEdge(source, dest, 1.0);
    }
}

