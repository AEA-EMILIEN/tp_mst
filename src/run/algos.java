package run;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


import set.DisjointSets;
import graph.Edge;
import graph.Graph;

public class Algos implements MSTTools {

	
	
	@Override
	public Graph runPrim(Graph g) {
		/*
		 
		
		Random rand = new Random();
		ArrayList<Integer> q = (ArrayList<Integer>) g.getListVertex();
		int[] key = new int[q.size()];
		int s = rand.nextInt(q.size()); //choix du sommet de depart aleatoirement
		
		initKey(key, s);
		
		while(!q.isEmpty())
		{
			int u = extract_min(q);
			
			int[] adj = adjacent(g,u);
			
			for(int i=0;i<adj.length;i++)
			{
				int v = adj[i];
				if(q.contains(v) && c(u,v) < key[v])
				{
					key[v] = c(u,v);
					pere(v) = u;
				}
			}
			
			
		}
		
		*/
		return null;
	}

	private void initKey(int[] key, int s) {
		for(int i=0;i<key.length;i++)
			key[i]=-1;
		key[s]=0;
		
	}

	
	public Graph runKruskal(Graph g) {
		/*KRUSKAL(G):
			1 A = ∅
			2 foreach v ∈ G.V:
			3   MAKE-SET(v)
			4 foreach (u, v) ordered by weight(u, v), increasing:
			5    if FIND-SET(u) ≠ FIND-SET(v):
			6       A = A ∪ {(u, v)}
			7       UNION(u, v)
			8 return A
			*/
		ArrayList<Edge> a = new ArrayList<Edge>();
		List<Integer> l = g.getListVertex();
		Collections.sort(l);
		DisjointSets ds = new DisjointSets(l.size());
		Iterator<Edge> iterator = g.getSortedEdgeIterator();
		Edge e = null;
		
		while(iterator.hasNext())
		{
			e = iterator.next();
			if (ds.find(e.v1.val) != ds.find(e.v2.val))
			{
				
				a.add(e);
				ds.union(ds.find(e.v1.val), ds.find(e.v2.val));
			}
			
		}
		
		g.constructGraph(l, a);
		return g;
	}

}
