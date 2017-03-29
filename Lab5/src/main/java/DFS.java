import se.kth.id1020.Edge;
import se.kth.id1020.Graph;

/**
 * Created by alexander on 2016-12-09.
 */

public class DFS {

    private boolean[] marked;
    private int count;
    public int[] id;

    public DFS(Graph g) {
        marked = new boolean[g.numberOfVertices()];
        id = new int [g.numberOfVertices()];
        for (int j = 0; j < g.numberOfVertices(); j++) {
            if (!marked(j)) {
                dfs(g, j);
                count++;
            }
        }
    }

    private void dfs(Graph g, int i) {
        marked[i] = true;
        id[i] = count;
        for (Edge e : g.adj(i)) {
            if (!marked[e.to]) {
                dfs(g, e.to);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }

}
