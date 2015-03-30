package main;

import graph.GraphSuccessorArray;
import graph.RandomGraph;
import run.Algos;
import set.DisjointSets;
import utils.Parser;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//Parser p = new Parser("data/graph_demo.txt");
	
		
		RandomGraph g = new RandomGraph();
		g.generateErdosRenyiGraph(10000, (float)0.8);
		
		
		
		Parser p = new Parser((GraphSuccessorArray)g.g);
		p.toTextFormat("data/randomTest0");
		Algos algo = new Algos();
		System.out.println(algo.meanTimeKruskal(p.graph));
		//p.graph = algo.runKruskal(p.graph);
		//p.toTextFormat("data/randomTest0B");
		
	
	}

}
