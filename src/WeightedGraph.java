import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V>{
    private final boolean undirected;
    private final Map<V, Vertex<V>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V vert) {
        map.put(vert, new Vertex<>(vert));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source)){
            addVertex((source));
        }
        if (!hasVertex(dest)){
            addVertex(dest);
        }
        if (hasEdge(source, dest) || source.equals(dest)){
            return;
        }
        map.get(source).addAdjacentVertex(map.get(dest), weight);
        if (undirected){
            map.get(dest).addAdjacentVertex(map.get(source), weight);
        }
    }

    public int getVerticesCount() {
        return map.size();
    }

    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public void delete(V vert){
        map.remove(vert);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) {return false;}
        if(map.get(source).getAdjacent_vertices() == null){
            return false;
        }
        return map.get(source).getAdjacent_vertices().containsKey(map.get(dest));
    }

    public Double getWeight(V source, V dest){
        if(!hasEdge(source, dest)) {
            return Double.POSITIVE_INFINITY;
        }
        return map.get(source).getAdjacent_vertices().get(map.get(dest));
    }

    public Vertex<V> getVertex(V data){
        return map.get(data);
    }
    public Iterable<V> getAdjacent_vertices(){
        return  map.keySet();
    }
}