
import java.util.*;

public class DjikstraSearch<V> implements Search<V>{
        private WeightedGraph<V> graph;
        public DjikstraSearch(WeightedGraph<V> graph ){
            this.graph = graph;
        }

    @Override
    public List<V> SearchPath(V source, V dest) {
        HashMap<Vertex<V>, Double> distances = new HashMap<>();
        HashMap<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>();

        Vertex<V> sourceVertex = graph.getVertex(source);
        Vertex<V>destVertex = graph.getVertex(dest);


        for(Vertex<V> vertex : graph.getVertices().values()){
            distances.put(vertex, 100000000.0);
            previousVertices.put(vertex, null); //заполняем
        }

        sourceVertex.setDistance(0.0);
        queue.offer(sourceVertex);


        while(!queue.isEmpty()){
            Vertex<V> currentVertex = queue.poll();

            if(destVertex == currentVertex){
                break; // достиг своей цели
            }

            Double currentDistance = currentVertex.getDistance();

            for(Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()){//используем интерфейс Map чтобы было удобно
                Vertex<V> neighbour = entry.getKey(); // пользоваться GetKey или GetValue(боже что я несу, надеюсь поймете)
                double weight = entry.getValue();
                double newDistance = currentDistance+weight;

                if(newDistance < neighbour.getDistance()){
                        neighbour.setDistance(newDistance);
                        previousVertices.put(neighbour, currentVertex);
                        queue.offer(neighbour);
                }
            }


            Iterator iterator = currentVertex.getAdjacentVertices().entrySet().iterator(); //какое из них лучше? создание итератора или вот то что выше?
            while(iterator.hasNext()){
                Map.Entry count = (Map.Entry) iterator.next();
                System.out.println(count.getKey());
                System.out.println(count.getValue());
                System.out.println("_______");
            }


        }

        List<V> path= new ArrayList<>();
        Vertex<V> current = destVertex;

        while(current !=null ){
            path.add(current.getData());
            current = previousVertices.get(current);

        }
        Collections.reverse(path);
        return path;


    }





}

