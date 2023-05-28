import java.util.HashMap;
import java.util.Map;

public class Vertex<V> implements Comparable<Vertex<V>> {
    private V data;
    private Map<Vertex<V>,Double > adjacentVertices;
    private double distance;
    public Vertex(V data){
        this.data= data;
        adjacentVertices = new HashMap<>();
        distance = 100000000.0;
    }
    public void addAdjacentVertices(Vertex<V> destination, double weight){
        adjacentVertices.put(destination, weight);
    }

    public Double getWeight(Vertex<V> dest){
        return adjacentVertices.get(dest);
    }


   public V getData(){
        return data;
   }
   public void setData(){
        this.data = data;
   }
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public double getDistance(){
        return distance;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }


    @Override
    public int compareTo(Vertex<V> o) {
        return Double.compare(this.distance, o.distance);
    }
}
