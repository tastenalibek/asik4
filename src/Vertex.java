import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    // Getters and setters
    public V getData() { return data; }
    public void setData(V data) { this.data = data; }
    public Map<Vertex<V>, Double> getAdjacentVertices() { return adjacentVertices; }
}

