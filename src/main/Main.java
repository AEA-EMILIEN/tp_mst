package main;

import graph.Graph;
import graph.GraphSuccessorArray;
import utils.Parser;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Graph g =  Parser.loadGraphFromFile("data/graph_demo.txt");
		System.out.println("Graphe done !");
		
		//System.out.println(g.getListVertex());

		GraphSuccessorArray gsa = new GraphSuccessorArray(4);
		gsa.addVertexNumber(0);
		gsa.addVertexNumber(1);
		gsa.addVertexNumber(2);
		gsa.addVertexNumber(3);
		gsa.addEdge(0, 1,5);
		gsa.addEdge(0, 2,5);
	
		
		Parser.toTextFormat(g, "data/test.txt");
	}

}
