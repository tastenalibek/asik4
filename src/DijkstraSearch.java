import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<V, Double> distances = new HashMap<>();
    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        for (V vert : graph.getAdjacent_vertices()) {
            distances.put(vert, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);
        dijkstra(graph);
    }

    private void dijkstra(WeightedGraph<V> graph) {
        while (true) {
            V vertex = null;
            double minDist = Double.POSITIVE_INFINITY;
            for (V i : distances.keySet()) {
                if (!marked.contains(i) && minDist > distances.get(i)) {
                    vertex = i;
                    minDist = distances.get(i);
                }
            }
            if (vertex == null) {
                break;
            }
            marked.add(vertex);
            for (V v : graph.getAdjacent_vertices()) {
                if (!marked.contains(v)) {
                    double newDist = distances.get(vertex) + graph.getWeight(vertex, v);
                    if (newDist < distances.get(v)) {
                        distances.put(v, newDist);
                        edgeTo.put(v, vertex);
                    }
                }
            }
        }
    }
}




