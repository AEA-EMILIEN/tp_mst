package utils;

import exception.VertexNotFoundException;
import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;
import graph.GraphSuccessorArray;

public class Parser {
	
	private static AccessFile accessFile = new AccessFile();
	private static GraphSuccessorArray graph;
	
	public Parser(GraphSuccessorArray g) {
		Parser.graph = g;
	}
	
	
	public static void toTextFormat(Graph g, String file) throws Exception {
		accessFile.listVertex = g.getListVertex();
		accessFile.writer(file);
	}
	
	
	public static Graph loadGraphFromFile(String file) throws Exception {
		accessFile.reader(file);
		List<Integer> listVertex = accessFile.listVertex;
		List<int[]> listEdges = accessFile.listEdges;
		Graph graph = new GraphSuccessorArray(listVertex.size());
		for (int v : listVertex){
			System.out.println(v);
			graph.addVertexNumber(v);
		}
		//System.out.println(listVertex);
		for (int[] t : listEdges) {
				//System.out.println(t[0] + " " + t[1] + " "+ t[2]);
				graph.addEdge(t[0], t[1], t[2]);
		}
		return graph;
	}


	public static List<int[]> getEdges(Integer vertex) throws VertexNotFoundException {
		List<Edge> edgesClass = graph.getListEdges(vertex);
		List<int[]> edgesInt = new ArrayList<int[]>() ;
		for (Edge e : edgesClass) {
			int[] t = {e.getV2().val, e.getWeigth() };
			edgesInt.add(t);
		}
		
		return edgesInt;
	}

}