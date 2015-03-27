package utils;

import graph.Graph;
import graph.GraphSuccessorArray;

import java.util.ArrayList;
import java.util.List;

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
		int cpt = -1;
		// Recommencer
		for (int v : listVertex)
			graph.addVertexNumber(v);
		for (int i = 0; i<listVertex.size(); i++) {
			int[] edge = listEdges.get(i);
			for (int j; j < edge.length; j++ )
				graph.addEdge(listVertex.get(i), edge[j++], edge[j]);
		}	
		return graph;
	}


	public static List<int[]> listEdges(Integer vertex) {
		// TODO Auto-generated method stub
		return null;
	}
}
