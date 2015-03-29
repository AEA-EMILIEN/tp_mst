package graph;

import java.util.Random;

import exception.VertexAlreadyExistException;
import exception.VertexNotFoundException;

public class RandomGraph implements RandomGraphGenerator {

	
	public Graph g ;
	
	public RandomGraph()
	{
		this.g = null;
	}
	
	
	@Override
	public Graph generateErdosRenyiGraph(int n, float p)
			throws IllegalArgumentException{
		
		if(p<0.000 || p>1.000 || n<0)
			throw new IllegalArgumentException();
		
		this.g = new GraphSuccessorArray(n);
		
		Random rand = new Random();
		
		addAllVertex(n);
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
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
	
	public void addAllVertex(int n) 
	{
		for(int i=0;i<n;i++)
		{
			try {
				g.addVertexNumber(i);
			} catch (VertexAlreadyExistException e) {
				;
			}
		}
	}
	
	public long timeGenerationErdos(int n,float p)
	{
		long startTime = System.nanoTime();
		generateErdosRenyiGraph(n, p);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		return duration; 
	}
	
	public String meanTimeGenerationErdos(int n,float p)
	{
		int t=5;
		long mean=0;
		for(int j=0;j<t;j++)
			mean+=timeGenerationErdos(n, p);
		mean/=t;
		
		return "Erdos generation for n="+n+" and p="+p+" Time:"+(mean/1000000)+"ms or "+mean/1000000000+"s"; 
	}

}
