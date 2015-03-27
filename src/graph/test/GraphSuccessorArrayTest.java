package graph.test;

import static org.junit.Assert.*;
import exception.VertexAlreadyExistException;
import graph.GraphSuccessorArray;

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
		
		gsa.addVertexNumber(0);
		
	}

	@Test
	public void testAddVertexNumber() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddEdgeVertexVertex() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testActualiseP() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddEdgeIntInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetVertex() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetSortedEdgeIterator() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetListEdges() {
		fail("Not yet implemented"); // TODO
	}

}
