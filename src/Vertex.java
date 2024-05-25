import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private final Map<Vertex<V>, Double> adjacent_vertices = new HashMap<>();

    public Vertex(){
        this(null);
    }

    public Vertex(V data){
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacent_vertices() {
        return adjacent_vertices;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight){
        adjacent_vertices.put(destination,weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> otherVertex = (Vertex<?>) o;
        return data.equals(otherVertex.data);
    }
}

