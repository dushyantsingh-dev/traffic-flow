import java.util.*;
import java.util.stream.Stream;

public class Node implements Comparable<Node> {

    public Integer calcTimeToReach(int speed){
        return (distance*cars*15)/(10*speed);
    }

    public String getName() {
        return name;
    }
    public Integer getDistance() {
        return distance;
    }
    public List<Node> getShortestPath() {
        return shortestPath;
    }
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
        System.out.println("Set Shortest path to: "+ shortestPath);
    }
    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
    public Integer getCars() {
        return cars;
    }
    public void setCars(Integer cars) {
        this.cars = cars;
    }

    public Node(String name) {
        this.name = name;
//        this.distance = distance;
//        this.shortestPath = shortestPath;
//        this.adjacentNodes = adjacentNodes;
    }

    private final String name;
    private Integer distance= Integer.MAX_VALUE;
    private List<Node> shortestPath= new LinkedList<>();
    private Map<Node, Integer> adjacentNodes = new HashMap<>();
    private Integer cars=0;
    public void addAdjacentNode(Node node, int weight){
        adjacentNodes.put(node, weight);
    }
    public int compareTo(Node node){
        return Integer.compare(this.distance, node.getDistance());
    }
}
