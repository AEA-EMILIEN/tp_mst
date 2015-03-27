package graph.test;

import static org.junit.Assert.*;
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
		GraphSuccessorArray gsa = new GraphS
	}

	@Test
	public void testAddVertex() {
		fail("Not yet implemented"); // TODO
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
