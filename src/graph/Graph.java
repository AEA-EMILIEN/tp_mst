package graph;
import java.util.Iterator;

import exception.*;

public class Graph {
	
	 public void addVertex() { }
	 
     public void addVertexNumber(int i) throws VertexAlreadyExistException {}
     
     public void addEdge(Vertex v1, Vertex v2) throws VertexNotFoundException {}
     
     public void addEdge(int i, int j) throws VertexNotFoundException {}
     
     public Vertex getVertex(int i) { return null;}
     
     public Iterator<Edge> getSortedEdgeIterator() {return null;}
}
