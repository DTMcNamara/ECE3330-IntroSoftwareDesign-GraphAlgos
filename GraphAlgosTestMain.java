/**
 * The GraphAlgosTestMain is used
 * to test the graphAlgos class and
 * its functionality.
 */
public class GraphAlgosTestMain {

    /**
     * The main method creates a
     * graphalgo object and uses
     * it to run tests.
     *
     * @param args The main method takes
     *             no arguments.
     */
    public static void main(String[] args) {
        GraphAlgos adj=new GraphAlgos();
        String[][]adjList=adj.createStrAdjList();
    }
}
