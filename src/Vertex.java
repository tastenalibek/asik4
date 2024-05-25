import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        Map<Vertex<V> , Double> map = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    // Getters and setters
    public static V getData() { return data; }
    public void setData(V data) { this.data = data; }
    public Map<Vertex<V>, Double> getAdjacentVertices() { return adjacentVertices; }
    public void addAdjacentVertex(Vertex<V> dest, Double weight, HashMap<K, V> map) {
        map.put(dest, weight);
    }
    public Iterable<V> getAdjacentVerticesData(HashMap<Object, Object> map) {
        return map.keySet().stream().map(Vertex::getData)::iterator;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> otherVertex = (Vertex<?>) o;

        return data.equals(otherVertex.data);
    }
}
}

