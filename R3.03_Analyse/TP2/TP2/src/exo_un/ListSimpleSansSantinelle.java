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
		size++;
	}
	
	public ListSimpleSansSantinelle(int elem) {
		head = new NodeSimple(elem, null); 
	}
	
	public NodeSimple getHead() {
		return head;
	}
	
	public int getHeadElem() {
		return head.getElement();
	}
	
	public void setHeadElem(int e) {
		head.setElement(e);
	}
	
	public void insertElemEnTete(int e) {
		NodeSimple node = new NodeSimple(e, head);
		head = node;
		size++;
	}
	
	public NodeSimple getHeadNext() {
		return head.getNext();
	}
	
	public NodeSimple getAvantDernierNode() {
		if(size<2) {
			return null;
		}
		NodeSimple courant = head.getNext(), prec = head;
		while(courant.getNext()!=null) {
			courant = courant.getNext();
			prec = prec.getNext();
		}
		return prec;
	}
	
	public int getSize() {
		return size;
	}
	
	public void inverserListe() {
		NodeSimple prec = head, cour, suiv;
		if (prec==null || prec.getNext()==null) {
			return;
		}
		cour=prec.getNext();
		suiv=cour.getNext();
		prec.setNext(null);
		cour.setNext(prec);
		while(suiv!=null) {
			prec=cour;
			cour=suiv;
			suiv=suiv.getNext();
			cour.setNext(prec);
		}
	}

}
