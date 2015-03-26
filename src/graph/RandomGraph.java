package graph;

import java.util.Random;

import exception.VertexNotFoundException;

public class RandomGraph implements RandomGraphGenerator {

	
	@Override
	public Graph generateErdosRenyiGraph(int n, float p)
			throws IllegalArgumentException{
		
		Graph g = new GraphSuccessorArray(n);
		Random rand = new Random();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n-1;j++)
			{
				if(rand.nextDouble()<=p)
				{
					try {
						g.addEdge(i,j);
					} catch (VertexNotFoundException e) {
						System.out.println("vertex "+i+" or "+j+" not found");
					}
				}
			}
		}
		return g;
	}

}
