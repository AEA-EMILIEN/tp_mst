package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
	
	public VertexAndInt [] p;
	public ArrayList<Edge> s ;
	
	
	public GraphSuccessorArray() {
		this.p = null;
		this.s = new ArrayList<Edge>();
	}
	
	public GraphSuccessorArray(int nbVertex)
	{
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
			Vertex v = new Vertex(i);
			VertexAndInt vi = new VertexAndInt(v, -1);
			p[i]=vi;
		}
	}
	
	
	/**
	 * Add a vertex to the graph.
	 * 
	 * note: really slow
	 */
	@Override
	public void addVertex() {
		if (p==null)
		{
			this.p = new VertexAndInt[1];
			initP();
		}
		else
		{
			VertexAndInt[] tmp = new VertexAndInt[this.p.length+1];
			System.arraycopy(this.p, 0, tmp, 0, this.p.length);
			
			Vertex v = new Vertex(tmp.length-1);
			VertexAndInt vi = new VertexAndInt(v, -1);
			
			tmp[tmp.length-1]=vi;
			
			this.p = tmp;
		}
	}

	/**
	 * Not implemented
	 */
	@Override
	public void addVertexNumber(int i) throws VertexAlreadyExistException {
		throw new UnsupportedOperationException("not implemented yet");
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
		if (v.equals(p[v.val].v))
			return v.val;
		for(int i=0;i<p.length;i++)
		{
			if (v.equals(p[i].v))
				return i;
		}
		return -1;
	}
	
	

	@Override
	public void addEdge(Vertex v1, Vertex v2) throws VertexNotFoundException 
	{
		int indiceV1 = searchIndiceVertex(v1);
		int indiceV2 = searchIndiceVertex(v2);
		
		if (indiceV1 < 0|| indiceV2 <0 )
			throw new VertexNotFoundException();
		
		int indMin = Operations.min(indiceV1,indiceV2);
		//int indMax = Operations.max(indiceV1,indiceV2);
		
		Edge e = new Edge(v1,v2);
		
		//already exist
		if (s!=null && s.contains( e))
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
		for(int j=n;j<p.length;j++)
		{
			if(p[j].i>=0)
				p[j].i++;
		}
	}

	@Override
	public void addEdge(int i, int j) throws VertexNotFoundException {
		
		Vertex v1 = new Vertex(i);
		Vertex v2 = new Vertex(j);
		
		addEdge(v1,v2);
	}

	/**
	 * Return the vertex of value i
	 * 
	 * @param i the value of the vertex to be searched
	 * @return Return the vertex of value i, null if he is not found
	 */
	@Override
	public Vertex getVertex(int i) {
		for(int j=0;j<p.length;j++)
		{
			if(p[j].v.val==i)
				return p[j].v;
		}
		return null;
	}

	@Override
	public Iterator<Edge> getSortedEdgeIterator() {
		ArrayList<Edge> tmp = new ArrayList<Edge>(s);
		Collections.sort(tmp,new EdgeComparator());
		return tmp.iterator();
	}

}
