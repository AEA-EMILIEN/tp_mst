package run;

import java.util.ArrayList;
import java.util.Random;

import graph.Graph;

public class algos implements MSTTools {

	@Override
	public Graph runPrim(Graph g) {
		
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
					key[v] = c(u,v)
					pere(v) = u;
				}
			}
			
			
		}
		
		
		return null;
	}

	private void initKey(int[] key, int s) {
		for(int i=0;i<key.length;i++)
			key[i]=-1;
		key[s]=0;
		
	}

	@Override
	public Graph runKruskal(Graph g) {
		// TODO Auto-generated method stub
		return null;
	}

}
