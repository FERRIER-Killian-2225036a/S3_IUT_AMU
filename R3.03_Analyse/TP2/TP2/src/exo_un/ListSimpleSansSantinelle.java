package exo_un;

public class ListSimpleSansSantinelle {
	private NodeSimple head;
	private int size;

	public ListSimpleSansSantinelle() {
		head = null;
		size = 0;
	}
	
	public ListSimpleSansSantinelle(NodeSimple n) {
		head = n; 
	}
	
	public ListSimpleSansSantinelle(int elem) {
		head = new NodeSimple(elem, null); 
	}

}
