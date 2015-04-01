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
	
		/*
		RandomGraph g = new RandomGraph();
		g.generateErdosRenyiGraph(100, (float)0.2);
		Parser p = new Parser((GraphSuccessorArray)g.g);
		p.toTextFormat("data/randomTest0");
		Algos algo = new Algos();
		System.out.println(algo.meanTimeKruskal(p.graph));
		/*
		Algos algo = new Algos();
		p.graph = algo.runKruskal(p.graph);*/
		//p.toTextFormat("data/randomTest0B");
		
		
	
		RandomGraph rg = new RandomGraph();
		System.out.println(rg.meanTimeGenerationErdos(300, 1));
		
	}

}
