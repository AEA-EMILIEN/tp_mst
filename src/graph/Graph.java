package graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.*;

public interface Graph {
	
	 public void addVertex();
	 
     public void addVertexNumber(int i) throws VertexAlreadyExistException;
    
     public void addEdge(Vertex v1, Vertex v2) throws VertexNotFoundException ;
     
     public void addEdge(int i, int j) throws VertexNotFoundException;
     
     public void addEdge(Vertex v1, Vertex v2,int weigth) throws VertexNotFoundException ;
     
     public void addEdge(int i, int j,int weigth) throws VertexNotFoundException;
     
     public void addEdge(Edge e) throws VertexNotFoundException;
     
     public Vertex getVertex(int i) ;
     
     public Iterator<Edge> getSortedEdgeIterator() ;
     
     public List<Integer> getListVertex() ;
     
     public List<Edge> getListEdges(int n) throws VertexNotFoundException;
     
     @Override
     public String toString();
     
     public void constructGraph(ArrayList<Vertex> lv, ArrayList<Edge> le);
     
     public void constructGraph(List<Integer> li,ArrayList<Edge> le);
}
