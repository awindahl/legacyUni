import edu.princeton.cs.introcs.StdOut;
import se.kth.id1020.DataSource;
import se.kth.id1020.Graph;

public class Paths {

    public static void main(String[] args) {

        Graph g = DataSource.load();
        // work on g

        DFS search = new DFS(g);

        if (search.count() != 0) {
            StdOut.println("The Planets Are Not Fully Connected...");
            StdOut.println("The number of sub-graphs are: " + search.count());
        } else {
            StdOut.println("Fully Connected!");
            StdOut.println("The number of sub-graphs are: 0");
        }

        int v = getNumber("Renyn");
        int w = getNumber("Parses");


        ReuvenSP sigismund = new ReuvenSP(g, v);         // with weights
        StdOut.println(sigismund.pathTo(w));
        StdOut.println("Total weight: " + sigismund.distTo(w));

        StdOut.println();

        ReuvenAP dijkstra = new ReuvenAP(g, v);          // all weights as 1
        StdOut.println(dijkstra.pathTo(w));
        StdOut.println("Total weight: " + dijkstra.distTo(w));
    }

    private static int getNumber(String s) {
        Graph g = DataSource.load();
        int v = 0;
        for (int i = 0; i < g.numberOfVertices(); i++) {
            if (s.equals(g.vertex(i).label)) {
                v = i;
            }
        }
        return v;
    }
}