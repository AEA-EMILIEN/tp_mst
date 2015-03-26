package graph;

public class VertexAndInt {
	
	
	public Vertex v;
	public int i;
	
	public VertexAndInt(Vertex v,int i)
	{
		this.v=v;
		this.i=i;
	}
	
	public VertexAndInt(int i,Vertex v)
	{
		this(v,i);
	}

}
