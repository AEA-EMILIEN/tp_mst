package main;

import graph.GraphSuccessorArray;
import utils.Parser;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		GraphSuccessorArray g = (GraphSuccessorArray) Parser.loadGraphFromFile("data/graph_demo.txt");
		System.out.println("Graphe done !");
		
		//System.out.println(g.getListVertex());

		Parser.toTextFormat(g, "data/test.txt");
	}

}
