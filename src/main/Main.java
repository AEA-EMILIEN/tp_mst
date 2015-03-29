package main;

import graph.Graph;
import graph.GraphSuccessorArray;
import graph.Vertex;
import utils.Parser;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Parser p = new Parser("data/graph_demo.txt");
	
		System.out.println(p.graph.toString());
		
		p.toTextFormat("data/test.txt");
	}

}
