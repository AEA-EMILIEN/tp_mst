package main;

import graph.RandomGraph;
import utils.Parser;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//Parser p = new Parser("data/graph_demo.txt");
	
		
		RandomGraph g = new RandomGraph();
		System.out.println(g.meanTimeGenerationErdos(350, (float)0.5));
		//p.toTextFormat("data/test.txt");
	}

}
