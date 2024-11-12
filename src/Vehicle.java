import java.util.LinkedList;
import java.util.List;

public class Vehicle {
    private final Node startingNode;
    private Node currentNode;
    private final Node endingNode;
    private List<Node> route= new LinkedList<>();
    private int speed;
    private int totalTime;
    private int currentNodeTime;
    private boolean destinationReached=false;

    public Vehicle(Node startingNode, Node endingNode, int speed) {
        this.startingNode = startingNode;
        currentNode = startingNode;
        this.endingNode = endingNode;
        this.speed=speed;
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

    public void calcRoute(){
        Dijkstra dijkstra=new Dijkstra();
        dijkstra.calculateShortestPath(currentNode);
        route= endingNode.getShortestPath();
//        route.add(endingNode);
    }

    public void moveNode(){
        calcRoute();
        if (!(route.size()<=1)){
            currentNode=route.get(1);
            route.removeFirst();
            currentNodeTime=route.get(1).calcTimeToReach(speed);
            currentNode.setCars(currentNode.getCars()+1);
        }else{
            destinationReached=true;
        }
    }

    public void move(){
        if(currentNodeTime!=0){
            currentNodeTime-=1;
            totalTime+=1;
        }
        else{
            moveNode();
        }
    }
}
