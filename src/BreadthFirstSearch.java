import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph){
        this.graph = graph;
    }



    @Override
    public List<V> SearchPath(V source, V dest) {
        Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        Vertex<V> sourceVertex = graph.getVertex(source);
        Vertex<V> destVertex = graph.getVertex(dest);

        previousVertices.put(sourceVertex, null);
        queue.offer(sourceVertex);


        while(!queue.isEmpty()){
            Vertex<V> currentVertex = queue.poll();

            if(currentVertex == destVertex){
                break;
            }

            // реализую итератор как я спрашивал в DijkstraSearch

            Iterator<Vertex<V>> iterator = currentVertex.getAdjacentVertices().keySet().iterator();
            while(iterator.hasNext()){
                Vertex<V> neighbour = iterator.next();
                if(!previousVertices.containsKey(neighbour)){
                    previousVertices.put(neighbour, currentVertex);
                    queue.offer(neighbour);
                }
            }


//            for (Vertex<V> neighbor : currentVertex.getAdjacentVertices().keySet()) {
//                if (!previousVertices.containsKey(neighbor)) {
//                    previousVertices.put(neighbor, currentVertex);
//                    queue.offer(neighbor);
//                }
//            }

        }


        List<V> path = new ArrayList<>();
        Vertex<V> current = destVertex;

        while(current!=null){
            path.add(current.getData());
            current = previousVertices.get(current);
        }
        Collections.reverse(path);

        return path;
    }
}
