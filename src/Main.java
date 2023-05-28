import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(false);

        graph.addEdge("A", "B", 5.3);
        graph.addEdge("B", "C", 3.2);
        graph.addEdge("A", "C",  2.3);
        graph.addEdge("B", "D", 3.0);
        graph.addEdge("D", "E", 6.0);

        System.out.println(graph.getWeight("B", "D"));
        System.out.println(graph.getVertex("B"));

        System.out.println(graph.getVertices().values());


        DjikstraSearch<String> search = new DjikstraSearch<>(graph);

        List<String> path = search.SearchPath("A", "D");

        System.out.println(path); //A B D


    }
}