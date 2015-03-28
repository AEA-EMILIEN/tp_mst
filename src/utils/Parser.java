package utils;

import exception.VertexNotFoundException;
import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;

import graph.GraphSuccessorArray;

public class Parser {
	
	private AccessFile accessFile = new AccessFile();
	public Graph graph;
	
	public Parser(GraphSuccessorArray g) {
		this.graph = g;
	}
	
	public Parser(String file) throws Exception 
	{
		this.graph = loadGraphFromFile(file);
	}
	
	public  void toTextFormat(String file) throws Exception {
		accessFile.listVertex = this.graph.getListVertex();
		System.out.println(accessFile.listVertex);
		accessFile.writer(this.graph.toString(),file);
	}
	
	
	public  Graph loadGraphFromFile(String file) throws Exception {
		accessFile.reader(file);
		List<Integer> listVertex = accessFile.listVertex;
		List<int[]> listEdges = accessFile.listEdges;
		Graph graph = new GraphSuccessorArray(listVertex.size());
		for (int v : listVertex){
			graph.addVertexNumber(v);
		}
		for (int[] t : listEdges) {
				graph.addEdge(t[0], t[1], t[2]);
		}
		return graph;
	}


	public static  List<int[]> getEdges(Graph g,Integer vertex) throws VertexNotFoundException {
		List<Edge> edgesClass = g.getListEdges(vertex);
		List<int[]> edgesInt = new ArrayList<int[]>() ;
		for (Edge e : edgesClass) {
			int[] t = {e.getV2().val, e.getWeigth() };
			edgesInt.add(t);
		}
		
		return edgesInt;
	}

}