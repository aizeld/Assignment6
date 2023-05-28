public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(false);

        graph.addEdge("A", "B", 5.3);
        graph.addEdge("B", "C", 3.2);
        graph.addEdge("A", "C",  2.3);
        graph.addEdge("B", "D", 3.0);
        graph.addEdge("D", "E", 6.0);
    }
}