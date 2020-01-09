import java.util.NoSuchElementException;

public class Digraph {

    private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v
    
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * Adds the directed edge v→w to this digraph.
     *  v as tail vertex
     *  w as head vertex
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Returns the number of directed edges incident from vertex.
     */
    public int outdegree(int v) {
        return adj[v].size();
    }

    /**
     * Returns the number of directed edges incident to vertex.
     */
    public int indegree(int v) {
        return indegree[v];
    }
}
