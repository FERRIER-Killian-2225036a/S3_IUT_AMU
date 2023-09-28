package exo_un;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeSimpleTest {

	@Test
	void testConstructeur() {
		NodeSimple node = new NodeSimple(13, null);
		assertNotEquals(null, node);
	}
	
	@Test
	void testGetElement() {
		NodeSimple node = new NodeSimple(13, null);
		assertEquals(13, node.getElement());
	}
	
	@Test
	void testSetElement() {
		NodeSimple node = new NodeSimple(13, null);
		node.setElement(14);
		assertEquals(14, node.getElement());
	}
	
	@Test
	void testGetSetNext() {
		NodeSimple node = new NodeSimple(13, null), node2 = new NodeSimple(7, node);
		assertEquals(null, node.getNext());
		node.setNext(node2);
		assertEquals(node2, node.getNext());
	}

}
