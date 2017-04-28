package aed.multisets;

import aed.positionlist.*;

public class MultiSetList<Element> implements MultiSet<Element>{
	
	private PositionList<Pair<Element,Integer>> elements;
	private int size;

	public MultiSetList() {
		this.elements = new NodePositionList<Pair<Element,Integer>>();
		this.size = 0;
	}

	private static <Element> boolean equalElements(Element elem1, Element elem2) {
		return (elem1 == null) ? elem2 == null : elem1.equals(elem2);
	}

	public void add(Element[] elements) {
		for (Element elem : elements) {
			add(elem);
		}
	}

	public void add(Element elem) {
		Position<Pair<Element,Integer>> cursor = elements.first();
		boolean found = false;

		while (cursor != null && !found) {
			Pair<Element,Integer> pair = cursor.element();
			if (equalElements(pair.getLeft(),elem)) {
				pair.setRight(pair.getRight() + 1);
				found = true;
			}
			if (!found) cursor = elements.next(cursor);
		}

		if (!found) {
			Pair<Element,Integer> newPair = new Pair<Element,Integer>(elem,1);
			elements.addLast(newPair);
		}
		++size;
	}

	public boolean remove(Element elem) {
		Position<Pair<Element,Integer>> cursor = elements.first();
		boolean removed = false;

		while (cursor != null && !removed) {
			Pair<Element,Integer> pair = cursor.element();
			if (equalElements(pair.getLeft(),elem)) {
				if (pair.getRight() == 1)
					elements.remove(cursor);
				else {
					pair.setRight(pair.getRight() - 1);
				}
				size--;
				removed = true;
			} 
			else {
				cursor = elements.next(cursor);
			}
		}
		return removed;
	}

	public int count(Element elem) {
		Position<Pair<Element,Integer>> cursor = elements.first();
		int count = 0;

		while (cursor != null && count == 0) {
			Pair<Element,Integer> pair = cursor.element();
			if (equalElements(pair.getLeft(),elem)) {
				count = pair.getRight();
			}
			cursor = elements.next(cursor);
		}
		return count;
	}

	public int size() {
		return size;
	}

	public PositionList<Element> toPositionList() { 
		PositionList<Element> result = new NodePositionList<Element>();
		Position<Pair<Element,Integer>> cursor = elements.first();

		while (cursor != null) {
			Pair<Element,Integer> pair = cursor.element();
			for (int i = 0; i < pair.getRight(); i++)
				result.addLast(pair.getLeft());
			cursor = elements.next(cursor);
		}
		return result;
	}
}
