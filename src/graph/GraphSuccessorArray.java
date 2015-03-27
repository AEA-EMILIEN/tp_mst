package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import utils.Operations;
import exception.VertexAlreadyExistException;
import exception.VertexNotFoundException;

/**
 * This class implements a successor array graph.
 * 
 * Vertices are stored in a array of int because we are planning to use them for Erdos graph(ie: the number of vertex is know at the generation of the graph).
 * For other purpose a list would probably have been better suited.
 * 
 * 
 *
 */
public class GraphSuccessorArray implements Graph {
	
	public int indNextFree;
	public VertexAndInt[] p;
	public ArrayList<Edge> s ;
	
	
	public GraphSuccessorArray() 
	{
		this.indNextFree = 0;
		this.p = null;
		this.s = new ArrayList<Edge>();
	}
	
	public GraphSuccessorArray(int nbVertex)
	{
		this.indNextFree = 0;
		this.p = new VertexAndInt[nbVertex];
		initP();
		this.s = new ArrayList<Edge>();
	}
	
	/**
	 * set the p array to -1 for all his elements.
	 * This means none of the vertex have yet edges attached to them. 
	 */
	private void initP()
	{
		for(int i=0;i<p.length;i++)
		{	
			p[i]=null;
		}
	}
	
	
	/**
	 * Add a vertex to the graph.
	 * 
	 * note: really slow
	 */
	@Override
	public void addVertex() {
		Boolean bool = true;
		int name = this.indNextFree;
		while(bool)
		{
			try{
			addVertexNumber(name);
			}
			catch (VertexAlreadyExistException e) {
				name++;
			}
			bool = false;
		}
	}

	
	@Override
	public void addVertexNumber(int i) throws VertexAlreadyExistException {
		if (p==null)
		{   this.indNextFree=1;
			Vertex v = new Vertex(i);
			
			VertexAndInt vi = new VertexAndInt(v,-1);
			this.p = new VertexAndInt[1];
			this.p[0]=vi;
		}
		else
		{
			Vertex v = new Vertex(i);
			
			if(searchIndiceVertex(v)!=-1)
				throw new VertexAlreadyExistException();
			
			
			if(this.indNextFree==this.p.length)
			{
				VertexAndInt[] tmp = new VertexAndInt[this.p.length+1];
				System.arraycopy(this.p, 0, tmp, 0, this.p.length);
				this.p = tmp;
			}
			
			VertexAndInt vi = new VertexAndInt(v, -1);
			this.p[this.indNextFree]=vi;
			this.indNextFree++;
		}
	}

	/**
	 * search the indice of the Vertex v in p
	 * 
	 * @param v the vertex to be searched
	 * @return the indice of the Vertex v in the array p and -1 if he doesn't exist.
	 * @throws VertexNotFoundException 
	 */
	private int searchIndiceVertex(Vertex v) 
	{
		
		if (p.length<v.val && p[v.val]!=null && v.equals(p[v.val].v))
			return v.val;
		for(int i=0;i<p.length;i++)
		{
			if (p[i]!=null && v.equals(p[i].v))
				return i;
		}
		return -1;
	}
	
	

	@Override
	public void addEdge(Vertex v1, Vertex v2,int weigth) throws VertexNotFoundException 
	{
		int indiceV1 = searchIndiceVertex(v1);
		int indiceV2 = searchIndiceVertex(v2);
		
		if (indiceV1 < 0|| indiceV2 <0 )
			throw new VertexNotFoundException();
		
		int indMin = Operations.min(indiceV1,indiceV2);
		//int indMax = Operations.max(indiceV1,indiceV2);
		
		Edge e = null;
		
		if(weigth>=0)
			e = new Edge(v1,v2,weigth);
		else
			e = new Edge(v1,v2);
		//already exist
		if (s!=null && equals(e))
			return;
		
		
			
		int before = -1;
		
		if (indMin>0) //on n'est pas le premier sommet
		{	
			//on cherche l'indice qui le precede
			for(int j=indMin-1;j>=0;j--)
			{
				if (p[j].i>=0)
					before=(p[j].i);
			}
		}
		
		if(p[indMin].i<0)//premiere arete reliant ce sommet
		{
			s.add(before+1,e);
			p[indMin].i=before+1;
		}
		else
		{
			s.add(p[indMin].i+1,e);
			p[indMin].i++;
		}
	
		actualiseP(indMin);	
		
	}

	

	public void actualiseP(int n)
	{
		for(int j=n+1;j<p.length;j++)
		{
			if(p[j]!=null && p[j].i>=0)
				p[j].i++;
		}
	}

	@Override
	public void addEdge(int i, int j,int weigth) throws VertexNotFoundException {
		
		Vertex v1 = new Vertex(i);
		Vertex v2 = new Vertex(j);
		
		addEdge(v1,v2,weigth);
	}

	@Override
    public void addEdge(Vertex v1, Vertex v2) throws VertexNotFoundException
    {
		addEdge(v1,v2,-1);
    }
    
	@Override
    public void addEdge(int i, int j) throws VertexNotFoundException
	{
		addEdge(i, j,-1);
	}
	
	/**
	 * Return the vertex of value i
	 * 
	 * @param i the value of the vertex to be searched
	 * @return Return the vertex of value i, null if he is not found
	 */
	@Override
	public Vertex getVertex(int i) {
		for(int j=0;this.p!=null && j<this.p.length;j++)
		{
			if(this.p[j]!=null && this.p[j].v.val==i)
				return this.p[j].v;
		}
		return null;
	}

	@Override
	public Iterator<Edge> getSortedEdgeIterator() {
		ArrayList<Edge> tmp = new ArrayList<Edge>(s);
		Collections.sort(tmp,new EdgeComparator());
		return tmp.iterator();
	}

	/**
	 * 
	 * @param n un nom de sommet 
	 * @return la liste des aretes de n
	 * @throws VertexNotFoundException 
	 */
	public List<Edge> getListEdges(int n) throws VertexNotFoundException
	{
		int indiceN = searchIndiceVertex(new Vertex(n));
		if (indiceN==-1)
			throw new VertexNotFoundException();
		
		List<Edge> l= new ArrayList<Edge>(); 
		int depart = this.p[indiceN-1].i;
		int stop   = this.p[indiceN].i;
		
		for(int j=depart+1;j<=stop;j++)
			l.add(this.s.get(j));
		
		return l;
	}	
	
	public List<Integer> getListVertex()
	{
		if(this.p==null)
			return null;
		List<Integer> toto = new ArrayList<Integer>(this.p.length);
		for(int j=0;this.p[j]!=null && j<this.p.length;j++)
			toto.add(this.p[j].v.val);
		
		return toto;
	}
}
