package exo_un;

public class NodeSimple {
	
	private int element;
	private NodeSimple next;
	
	public NodeSimple(int s, NodeSimple n) {
		element=s;
		next=n;
	}
	
	public int getElement() {
		return element;
	}
	public void setElement(int e) {
		element = e;
	}
	public NodeSimple getNext() {
		return next;
	}
	public void setNext(NodeSimple n) {
		next = n;
	}

	@Override
	public String toString() {
		return "NodeSimple [element=" + element + "]";
	}
	
	

}
