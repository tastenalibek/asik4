import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;
    private Map<Vertex<V>, Vertex<V>> edgeTo;
    private PriorityQueue<Vertex<V>> pq;

    public DijkstraSearch() {
        super();
        this.distTo = new HashMap<>();
        this.edgeTo = new HashMap<>();
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> source, Vertex<V> dest) {
        dijkstra(source);
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> x = dest; x != null; x = edgeTo.get(x)) {
            path.add(x);
        }
        Collections.reverse(path);
        return path;
    }

    private void dijkstra(Vertex<V> source) {
        pq = new PriorityQueue<>(Comparator.comparing(distTo::get));
        distTo.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
                relax(v, entry.getKey(), entry.getValue());
            }
        }
    }

    private void relax(Vertex<V> v, Vertex<V> w, double weight) {
        double dist = distTo.getOrDefault(v, Double.POSITIVE_INFINITY) + weight;
        if (dist < distTo.getOrDefault(w, Double.POSITIVE_INFINITY)) {
            distTo.put(w, dist);
            edgeTo.put(w, v);
            pq.add(w);
        }
    }
}




