package graph;

import java.util.Random;

import utils.Operations;

public class Edge {
	
	public Vertex v1;
	public Vertex v2;
	public int weigth;
	public int N; //max weight, n^4
	public final int n = 100; //an int used to calculate N
	
	public Edge()
	{
		this.v1 = null;
		this.v2 = null;
		this.N = (int) (Math.pow(n,4));
	}

	public Edge(Vertex v1, Vertex v2,int weigth)
	{
		this.v1 = v1;
		this.v1 = v2;
		this.weigth = weigth;
	}
	
	public Edge(Vertex v1,Vertex v2)
	{
		this.v1 = v1;
		this.v1 = v2;
		this.N = (int) (Math.pow(n,4));
		this.weigth= randInt(1,N);
	}
	
	
	
	
	 
	@Override
	public boolean equals(Object object2)
	{
		return object2 instanceof Edge && this.equals((Edge) object2);
	}
	
	
	public boolean equals(Edge e2) {
		int minE = Operations.min(this.v1.val, this.v2.val);
		int maxE = Operations.max(this.v1.val, this.v2.val);
		
		int minE2 = Operations.min(e2.v1.val, e2.v2.val);
		int maxE2 = Operations.max(e2.v1.val, e2.v2.val);
		
		
	    return (minE==minE2 && maxE == maxE2);
	}
	
	/**
	 * found here : http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
	 * 
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	public Vertex getV1() {
		return v1;
	}

	public void setV1(Vertex v1) {
		this.v1 = v1;
	}

	public Vertex getV2() {
		return v2;
	}

	public void setV2(Vertex v2) {
		this.v2 = v2;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public boolean equal(Edge e) {
		
		return false;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		s+="v1:"+this.v1.val;
		s+=" v2:"+this.v2.val;
		s+=" weigth:"+this.weigth;
		return s;
	}
	
}
