package structure;


//matrice d'incidence
public class Graph {

	
	public int nbSommets;
	public int nbAretes;
	public int nbAretesMax;
	public int g[][];
	
	
	public Graph(int n,int e)
	{
		this.nbSommets = n;
		this.nbAretes = 0;
		this.nbAretesMax = e;
		this.g = new int[this.nbSommets][this.nbAretesMax];
		
		initMatZero();
	}
	
	public Graph(int n)
	{
		this(n,n*(n-1)/2);
	}
	
	
	public void initMatZero()
	{
		for(int i=0;i<nbSommets;i++)
		{
			for(int j=0;j<this.nbAretesMax;j++)
			{
				this.g[i][j] = 0;
			}
		}
	}
	
	public void addArete(int s1,int s2, int poid )
	{
		Boolean  cond =  true;
		int arete=0;
		
		
		while(cond)
		{	
			cherche_arete(s1);
		}
 	}
	
}
