import java.util.*;
public class Main {
    public static void main(String[] args) {
        CityLayout city = new CityLayout();

        // Adding intersections
        city.addIntersection("A");
        city.addIntersection("B");
        city.addIntersection("C");
        city.addIntersection("D");
        city.addIntersection("E");

        // Adding roads between intersections
        city.addRoad("AB","A", "B", 500,true);
        city.addRoad("AC","A", "C", 300,true);
        city.addRoad("BD","B", "D", 400,true);
        city.addRoad("CD","C", "D", 200,true);
        city.addRoad("BE","B", "E", 200,true);
        city.addRoad("CE","C", "E", 200,true);
        city.addRoad("DE","D", "E", 200,true);

        // Display the city layout
        city.displayLayout();
        Vehicle vehicle=new Vehicle(city.getNodes().get("A"),city.getNodes().get("E"),30);
        while (!vehicle.isDestinationReached()){
            vehicle.move();
        }
        System.out.println(vehicle.getTotalTime());
    }

}