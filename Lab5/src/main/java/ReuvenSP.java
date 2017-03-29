import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import se.kth.id1020.Edge;
import se.kth.id1020.Graph;


/**
 * Created by alexander on 2016-12-11.
 */


public class ReuvenSP {

    private Edge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public ReuvenSP(Graph g, int s) {
        edgeTo = new Edge[g.numberOfVertices()];
        distTo = new double[g.numberOfVertices()];
        pq = new IndexMinPQ<Double>(g.numberOfVertices());

        for (int i = 0; i < g.numberOfVertices(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(g, pq.delMin());
        }
    }

    private void relax(Graph g, int v) {
        for (Edge e : g.adj(v)) {
            int w = e.to;
            if (distTo[w] > distTo[v] + e.weight) {
                distTo[w] = distTo[v] + e.weight;
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<Edge>();
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.from])
            path.push(e);
        return path;
    }
}
