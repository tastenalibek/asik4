import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V>{
    public BreadthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }
    private void bfs(MyGraph<V> graph, V current) {
        marked.add(current);
        Queue<V> q = new LinkedList<>();
        q.add(current);
        while (!q.isEmpty()) {
            V v = q.remove();
            for (Vertex<V> vertex : graph.getVertex(v).getAdjacent_vertices().keySet()) {
                if (!marked.contains(vertex.getData())) {
                    marked.add(vertex.getData());
                    edgeTo.put(vertex.getData(), v);
                    q.add(vertex.getData());
                }
            }
        }
    }
}



