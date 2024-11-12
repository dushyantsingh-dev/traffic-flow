import java.util.*;
import java.util.stream.Collectors;

public class CityLayout {
    public Map<String, Node> getNodes() {
        return nodes;
    }


    private Map<String, Node> nodes;
    public CityLayout() {
       nodes = new HashMap<>();
    }

    public void addIntersection(String name) {
        nodes.put(name, new Node(name));
    }

    public void addRoad(String name,String fromName, String toName, int distance, boolean twoWay) {
        Node fromNode = nodes.get(fromName);
        Node toNode = nodes.get(toName);
        if (fromNode != null && toNode != null) {
            if (twoWay){
                fromNode.addAdjacentNode(toNode,distance);
                toNode.addAdjacentNode(fromNode,distance);
            }
            else{
                fromNode.addAdjacentNode(toNode,distance);
            }
            }
    }
    public void displayLayout() {
        for (Node node : nodes.values()) {
            System.out.println("Intersection " + node.getName() + " connects to:");
            for (Map.Entry<Node, Integer> entry : node.getAdjacentNodes().entrySet()) {
                System.out.println("  " + node.getName() + " -> " + entry.getKey().getName() + " (" + entry.getValue() + "m)");
            }
        }
    }
    public void shortestPathFromTo(String startNode, String endNode) {
            Dijkstra dijkstra = new Dijkstra();

            dijkstra.calculateShortestPath(nodes.get(startNode));
            dijkstra.printPaths(nodes.values().stream().toList());
            System.out.println(nodes.get(endNode).getShortestPath().stream()
                    .map(Node::getName).map(Objects::toString)
                    .collect(Collectors.joining(" -> ")));
    }
}