package graph.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import exception.VertexAlreadyExistException;
import exception.VertexNotFoundException;
import graph.Edge;
import graph.GraphSuccessorArray;
import graph.Vertex;

import org.junit.Test;

public class GraphSuccessorArrayTest {

	@Test
	public void testGraphSuccessorArray() {
		GraphSuccessorArray gsa = new GraphSuccessorArray();
		
		assertEquals(0,gsa.indNextFree);
		assertNull(gsa.p);
		assertEquals(0,gsa.s.size());
		
	}

	@Test
	public void testGraphSuccessorArrayInt() {
		GraphSuccessorArray gsa = new GraphSuccessorArray(5);
		
		assertEquals(0,gsa.indNextFree);
		assertEquals(5,gsa.p.length);
		assertNull(gsa.p[2]); //on regarde arbitrairement une case du tableau. Elle doit etre null apres le constructeur
		assertEquals(0,gsa.s.size());
	}

	@Test 
	public void testAddVertexNumberAfterEmptyConstructor() throws VertexAlreadyExistException {
		GraphSuccessorArray gsa = new GraphSuccessorArray();
		gsa.addVertexNumber(0);
		
		assertEquals(1,gsa.indNextFree);
		assertEquals(1,gsa.p.length);
		assertEquals(0,gsa.s.size());
		assertEquals(-1,gsa.p[0].i);
		assertEquals(0,gsa.p[0].v.val);
		
		gsa.addVertexNumber(1);
		
		assertEquals(2,gsa.indNextFree);
		assertEquals(2,gsa.p.length);
		assertEquals(0,gsa.s.size());
		assertEquals(-1,gsa.p[1].i);
		assertEquals(1,gsa.p[1].v.val);
		
		gsa.addVertexNumber(2);
		
		assertEquals(3,gsa.indNextFree);
		assertEquals(3,gsa.p.length);
		assertEquals(0,gsa.s.size());
		assertEquals(-1,gsa.p[0].i);
		assertEquals(2,gsa.p[2].v.val);
		
		gsa.addVertexNumber(3);
		
		assertEquals(4,gsa.indNextFree);
		assertEquals(4,gsa.p.length);
		assertEquals(0,gsa.s.size());
		assertEquals(-1,gsa.p[0].i);
		assertEquals(3,gsa.p[3].v.val);
		
	}

	@Test 
	public void testAddVertexNumberAfterNonEmptyConstructor() throws VertexAlreadyExistException {
		
		GraphSuccessorArray gsa = new GraphSuccessorArray(3);
		gsa.addVertexNumber(0);
		
		assertEquals(1,gsa.indNextFree);
		assertEquals(3,gsa.p.length);
		assertEquals(0,gsa.s.size());
		assertEquals(-1,gsa.p[0].i);
		assertEquals(0,gsa.p[0].v.val);
		
		gsa.addVertexNumber(1);
		
		assertEquals(2,gsa.indNextFree);
		assertEquals(3,gsa.p.length);
		assertEquals(0,gsa.s.size());
		assertEquals(-1,gsa.p[0].i);
		assertEquals(1,gsa.p[1].v.val);
		
		gsa.addVertexNumber(2);
		
		assertEquals(3,gsa.indNextFree);
		assertEquals(3,gsa.p.length);
		assertEquals(0,gsa.s.size());
		assertEquals(-1,gsa.p[0].i);
		assertEquals(2,gsa.p[2].v.val);
		
		gsa.addVertexNumber(3);
		
		assertEquals(4,gsa.indNextFree);
		assertEquals(4,gsa.p.length);
		assertEquals(0,gsa.s.size());
		assertEquals(-1,gsa.p[0].i);
		assertEquals(3,gsa.p[3].v.val);
	}

	@Test 
	public void testAddEdgeVertexVertexWeight() throws VertexAlreadyExistException, VertexNotFoundException {
		GraphSuccessorArray gsa = new GraphSuccessorArray(4);
		gsa.addVertexNumber(0);
		gsa.addVertexNumber(1);
		gsa.addVertexNumber(2);
		gsa.addVertexNumber(3);
		
		gsa.addEdge(new Vertex(0), new Vertex(1), 5);
		
		assertEquals(4,gsa.indNextFree);
		assertEquals(4,gsa.p.length);
		assertEquals(1,gsa.s.size());
		assertEquals(0,gsa.p[0].i);
		assertEquals(0,gsa.p[0].v.val);
		assertEquals(5,gsa.s.get(0).weigth);
		
		
		gsa.addEdge(new Vertex(0), new Vertex(2), 10);
		
		assertEquals(4,gsa.indNextFree);
		assertEquals(4,gsa.p.length);
		assertEquals(2,gsa.s.size());
		assertEquals(1,gsa.p[0].i);
		assertEquals(0,gsa.p[0].v.val);
		assertEquals(10,gsa.s.get(1).weigth);
		
		gsa.addEdge(new Vertex(1), new Vertex(2), 15);
		
		assertEquals(4,gsa.indNextFree);
		assertEquals(4,gsa.p.length);
		assertEquals(3,gsa.s.size());
		assertEquals(1,gsa.p[0].i);
		assertEquals(2,gsa.p[1].i);
		assertEquals(1,gsa.p[1].v.val);
	}
	
	@Test
	public void testGetVertexNotPresent() throws VertexAlreadyExistException {
		GraphSuccessorArray gsa = new GraphSuccessorArray(4);
		gsa.addVertexNumber(0);
		gsa.addVertexNumber(1);
		
		Vertex v = gsa.getVertex(2);
		assertEquals(null,v);
	}

	@Test
	public void testGetVertexPresent() throws VertexAlreadyExistException {
		GraphSuccessorArray gsa = new GraphSuccessorArray(4);
		gsa.addVertexNumber(0);
		gsa.addVertexNumber(1);
		
		Vertex v = gsa.getVertex(1);
		assertEquals(1,v.val);
	}
	
	@Test
	public void testGetSortedEdgeIterator() throws VertexAlreadyExistException, VertexNotFoundException {
		GraphSuccessorArray gsa = new GraphSuccessorArray(4);
		gsa.addVertexNumber(0);
		gsa.addVertexNumber(1);
		gsa.addVertexNumber(2);
		gsa.addEdge(0, 1,9);
		gsa.addEdge(0,2,5);
		gsa.addEdge(1,2,7);
		
		Iterator<Edge> i = gsa.getSortedEdgeIterator();
		assertEquals(5,i.next().weigth);
		assertEquals(7,i.next().weigth);
		assertEquals(9,i.next().weigth);
	}

}
