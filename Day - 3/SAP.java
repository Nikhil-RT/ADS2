import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

/**
 * SAP
 */
public class SAP {

    int ancestor = -1;
    int l = Integer.MAX_VALUE; //l is length

    Digraph graph;
    BreadthFirstDirectedPaths BFSD;
    BreadthFirstDirectedPaths BFSS;

    // Constructor
    public SAP(Digraph graph) {
        this.graph = graph;
    }

    public int ancestor(int v, int w) {

        for (int i = 0; i < graph.V(); i++ ) {
            System.out.println(i);
            System.out.println(BFSD.hasPathTo(i));
            System.out.println(BFSS.hasPathTo(i));

            if (BFSD.hasPathTo(i) && BFSS.hasPathTo(i)) {

                int t = BFSS.distTo(i) + BFSD.distTo(i); // t = temp;

                System.out.println("len "+ l);
                System.out.println("temp "+ t);
                //if temp is less than len then i will be stored in ancestor
                if ( t < l ) {  
                    ancestor = i;
                }
                System.out.println(" === A n c e s t o r === " + ancestor);
            }
        }
        return ancestor;
    }

    public void BFS(Digraph graph, int s, int d) {
        BFSD = new BreadthFirstDirectedPaths(graph, d);
        BFSS = new BreadthFirstDirectedPaths(graph, s);
    }

    public int length(int v, int w) {
        int ancestor = -1;
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < graph.V(); i++ ) {
            if (BFSS.hasPathTo(i) && BFSD.hasPathTo(i)) {
                int t = BFSS.distTo(i) + BFSD.distTo(i);
                
                // If the t is less than the len then length will be t
                if ( t < l ) {
                    l = t;
                }
            }
        }
        return l;
    }

}