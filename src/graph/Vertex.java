package graph;

public class Vertex {

	public int val;
	
	public Vertex()
	{
		this.val = -9999;
	}
	
	public Vertex(int n)
	{
		this.val = n;
	}
	
	public boolean equals(Object object2) {
	    return object2 instanceof Vertex && this.val == ((Vertex)object2).val;
	}
}
