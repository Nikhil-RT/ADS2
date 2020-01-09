import java.util.*;
public class Digraph {
    int V; // no of vertices 
    int E; //no of edges
    Bag<Integer>[] adj;
    int[] indegree;

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree(v);
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public Iterable <Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    // public static void main(String[] args) {
    //     Digraph graph = new Digraph();
    // }
}