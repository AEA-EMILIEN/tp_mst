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
		Graph graph = new GraphSuccessorArray();
		List<String> list = accessFile.reader(file);
		int cpt = -1;
		List<Integer> vertex = new ArrayList<Integer>() ;
		for (String s : list) {
			cpt++;
			String[] tab = s.split(" ");
			if (tab.length%2 == 0)
				System.out.println("Edge missing to create a vertex : line " + cpt);
				// Exception ?
			// ajout au graph
			graph.addVertexNumber(Integer.parseInt(tab[0]));
			for (int i = 0; i < tab.length-2; i++) {
				int vertex1 = Integer.parseInt(tab[i]);
				int vertex2 = Integer.parseInt(tab[i+1]);
				if (!vertex.contains(vertex1)) { 
					vertex.add(vertex1);
					graph.addVertexNumber(vertex1);
				}
				if (!vertex.contains(vertex2)) { 
					vertex.add(vertex2);
					graph.addVertexNumber(vertex2);
				}
				graph.addEdge(vertex1, vertex2);
			}	
		}
		return graph;
	}
}
