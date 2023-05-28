import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WeightedGraph<V> {
    private final boolean undirected;
    private HashMap<V, Vertex<V>> vertices = new HashMap<>();

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        vertices = new HashMap<>();
    };



    public void addVertex(V v){
        if(!hasVertex(v)){
            Vertex<V> vertex = new Vertex<>(v);
            vertices.put(v, vertex);
        }


    };


    public void addEdge(V source, V dest, double weight){
        if(!hasVertex(source)) addVertex(source);

        if(!hasVertex(dest))  addVertex(dest);

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        sourceVertex.addAdjacentVertices(destVertex, weight);

        if(undirected){
            destVertex.addAdjacentVertices(sourceVertex, weight);
        }



    };
    public boolean hasEdge(V source, V dest){

        if(!hasVertex(source)) return false;
        if(!hasVertex(dest)) return false;


        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        return sourceVertex.getWeight(destVertex) != null;


    };
    public boolean hasVertex(V v){
        return vertices.containsKey(v);

    }




    public int getVerticesCount(){return vertices.size();}


    public int getEdgesCount(){
        int count= 0;
        for(Vertex<V> v : vertices.values()){
            count += v.getAdjacentVertices().size();
        }
        if(undirected){
            count/=2;
        }
        return count;
    }

    public boolean hasAdjacentVertices(Vertex<V> dest){
        return !dest.getAdjacentVertices().isEmpty();
    };

 public Iterable<V> adjacencylist(V v){
     if(hasVertex(v)){
         List<V> adjlist = new ArrayList<>();
         Vertex<V> vertex = vertices.get(v);

         for(Vertex<V> adjacent : vertex.getAdjacentVertices().keySet()){
             adjlist.add(adjacent.getData());
         }
         return adjlist;
     }
     return Collections.emptyList();
   }

   public Double getWeight(V source, V dest){
        return vertices.get(source).getWeight(vertices.get(dest));///это я помню с урока)))

   }


}
