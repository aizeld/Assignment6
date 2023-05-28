import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(false);

        graph.addEdge("A", "B", 5.3);
        graph.addEdge("B", "C", 3.2);
        graph.addEdge("A", "C",  2.3);
        graph.addEdge("B", "D", 3.0);
        graph.addEdge("D", "E", 6.0);
        graph.addEdge("A", "E",3.3);
        graph.addEdge("E", "D", 0.3);

        System.out.println(graph.getWeight("B", "D"));
        System.out.println(graph.getVertex("B"));

        System.out.println(graph.getVertices().values());


        Search<String> search1 = new DjikstraSearch<>(graph);

        List<String> path1 = search1.SearchPath("A", "D");

        System.out.println(path1); //A E D


        Search<String> search2 = new BreadthFirstSearch<>(graph);

        List<String> path2= search2.SearchPath("A", "E");
        System.out.println(path2);//A E

    }
}