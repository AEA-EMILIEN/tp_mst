package utils;

import exception.VertexNotFoundException;
import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;
import graph.GraphSuccessorArray;

public class Parser {
	
	private static AccessFile accessFile = new AccessFile();
	
	public static void toTextFormat(Graph g, String file) throws Exception {
		//TODO
	}
	
	
	public static Graph loadGraphFromFile(String file) throws Exception {
		accessFile.reader(file);
		List<Integer> listVertex = accessFile.listVertex;
		List<int[]> listEdges = accessFile.listEdges;
		Graph graph = new GraphSuccessorArray(listVertex.size());
		// Recommencer
		for (int v : listVertex)
			graph.addVertexNumber(v);
		for (int i = 0; i<listVertex.size(); i++) {
			int[] edge = listEdges.get(i);
			for (int j=0; j < edge.length; j++ )
				graph.addEdge(listVertex.get(i), edge[j++], edge[j]);
		}	
		return graph;
	}


	public static List<int[]> getEdges(Integer vertex, GraphSuccessorArray graph) throws VertexNotFoundException {
		List<Edge> edgesClass = graph.getListEdges(vertex);
		List<int[]> edgesInt = null ;
		for (Edge e : edgesClass) {
			int[] t = {e.getV2().val, e.getWeigth() };
			edgesInt.add(t);
		}
		
		return edgesInt;
	}

