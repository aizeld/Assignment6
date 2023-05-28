import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>,Double > adjacentVertices;

    public Vertex(V data){
        this.data= data;
        adjacentVertices = new HashMap<>();
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

}
