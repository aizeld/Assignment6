import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DjikstraSearch<V> implements Search<V> {

    private WeightedGraph<V> graph;

    public DjikstraSearch(WeightedGraph<V> graph){
        this.graph = graph;
    }
    @Override
    public List<V> SearchPath(V source, V dest) {
        if(!graph.hasVertex(source)) throw new IllegalArgumentException("Нету твоего вертекса ");
        if(!graph.hasVertex(dest)) throw new IllegalArgumentException("Нету твоего вертекса");


        HashMap<V, Double> distances = new HashMap<>();
        HashMap<V, Double> distanceMap = new HashMap<>();
        HashMap<V, Double> previousVertices = new HashMap<>();
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparing(distanceMap::get));




    }
}
