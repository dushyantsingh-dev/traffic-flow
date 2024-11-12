import java.util.LinkedList;
import java.util.List;

public class Vehicle {
    private final Node startingNode;
    private Node currentNode;
    private final Node endingNode;
    private LinkedList<Node> route = new LinkedList<>(); // Changed to LinkedList
    private int speed;
    private int totalTime;
    private int currentNodeTime;
    private boolean destinationReached = false;
    private int turns=-1;
    public Vehicle(Node startingNode, Node endingNode, int speed) {
        this.startingNode = startingNode;
        currentNode = startingNode;
        this.endingNode = endingNode;
        this.speed = speed;
        calcRoute();
    }

    public int getTotalTime() {
        return totalTime;
    }

    public boolean isDestinationReached() {
        return destinationReached;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void calcRoute() {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.calculateShortestPath(currentNode);
        route = new LinkedList<>(endingNode.getShortestPath()); // Ensuring it's a LinkedList
    }

    public void moveNode() {
        if (route.size()>turns+2) {
            turns+=1;
            currentNode = route.get(turns);
            currentNodeTime = route.get(turns+1).calcTimeToReach(speed);
            currentNode.setCars(currentNode.getCars() + 1);
        } else if(route.size()==turns+2){
            turns+=1;
            currentNode = route.get(turns);
            currentNodeTime = endingNode.calcTimeToReach(speed);
            currentNode.setCars(currentNode.getCars() + 1);
        } else {
            destinationReached = true;
        }
    }

    public void move() {
        if (currentNodeTime != 0) {
            currentNodeTime -= 1;
            totalTime += 1;
        } else {
            moveNode();
        }
    }
}
