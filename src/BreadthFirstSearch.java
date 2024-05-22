import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private Map<Vertex<V>, Vertex<V>> edgeTo;
    private Set<Vertex<V>> marked;

    public BreadthFirstSearch() {
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
    }

    public BreadthFirstSearch(V source) {
        super(source);
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> source, Vertex<V> dest) {
        bfs(source);
        List<Vertex<V>> path = new ArrayList<>();
        if (!marked.contains(dest)) return path;

        for (Vertex<V> x = dest; x != null; x = edgeTo.get(x)) {
            path.add(x);
        }
        Collections.reverse(path);
        return path;
    }

    private void bfs(Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }
}



