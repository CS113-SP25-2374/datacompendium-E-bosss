package CS113.interfaces;

public interface GraphInterface {
    // Add a node to the graph
    public void addNode(String node);

    // Add an edge to the graph
    public void addEdge(String node1, String node2, boolean directed);

    // Get neighbors of a node
    public List<String> getNeighbors(String node);

    // Print the graph
    public void printGraph();
}
