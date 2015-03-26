package graph;

public interface RandomGraphGenerator {
    Graph generateErdosRenyiGraph(int n, float p)
                      throws IllegalArgumentException;
}