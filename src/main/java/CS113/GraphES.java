package CS113;

import CS113.interfaces.GraphInterface;
import CS113.interfaces.List;

import java.util.ArrayList;

public class GraphES implements GraphInterface {

    class Edge {
        String fromNode;
        String toNode;
        int weight;

        public Edge(String from, String to) {
            fromNode = from;
            toNode = to;
        }
    }

    List<String> nodes = new ArrayListES<>();
    List<Edge> edges = new ArrayListES<>();

    @Override
    public void addNode(String node) {
        nodes.add(node);
    }

    @Override
    public void addEdge(String node1, String node2, boolean directed) {
        if(!nodes.contains(node1) || !nodes.contains(node2)) {
            return;
        }
        Edge edge = new Edge(node1, node2);
        if(!edges.contains(edge)) {
            edges.add(edge);
        }
        if(!directed) {
            edge = new Edge(node2, node1);
            if(!edges.contains(edge)) {
                edges.add(edge);
            }
        }
    }

    @Override
    public List<String> getNeighbors(String node) {
        List<String> neighbors = new ArrayListES<>();

        for(int i = 0; i < edges.size(); i++) {
            if(edges.get(i).fromNode.equals(node)) {
                neighbors.add(edges.get(i).toNode);
            }
        }
        return neighbors;
    }

    @Override
    public void printGraph() {
        int n = nodes.size();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n ; j++) {
                String first = nodes.get(i);
                String second = nodes.get(j);
                List<String> neighbors = getNeighbors(first);
                if(neighbors.contains(second)) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
           System.out.print("\n");
        }

    }
}
