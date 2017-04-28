package aed.positiveiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import aed.positionlist.Position;
import aed.positionlist.PositionList;

/**
 * Clase que implementa un iterador de numeros positivos sobre una PositionList
 * @author groman
 *
 */
public class PositivePositionListIterator<E extends Integer> implements Iterator<Integer> {

	private PositionList<Integer> list;
	private Position<Integer> cursor;

	public PositivePositionListIterator(PositionList<Integer> list) {
		if (list == null) {
			throw new IllegalArgumentException ("La lista de entrada no puede ser null"); 
		}
		this.list   = list;
		this.cursor = list.first();
		moveCursor(); 
	}

	public boolean hasNext() { 
		return cursor != null; 
	}

	public Integer next() throws NoSuchElementException {
		if (cursor == null) {
			throw new NoSuchElementException(); 
		}
		
		Integer e = cursor.element();
		cursor = list.next(cursor);
		moveCursor(); 
		return e;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	private void moveCursor () {
		while (cursor != null && 
			  (cursor.element()== null || cursor.element() <= 0)) {
			cursor = list.next(cursor); 
		}
	}

}

