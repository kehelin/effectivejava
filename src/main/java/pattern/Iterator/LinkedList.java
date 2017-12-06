package pattern.Iterator;

public class LinkedList implements Collection{
	Node head = null;
	Node tail = null;
	int size = 0;
	@Override
	public void add(Object o) {
		Node n = new Node(o,null);
		if(head == null) {
			head = n;
			tail = n;
		}else {
			tail.setNext(n);
			tail = n;
		}
	}
	@Override
	public int size(){
		return size;
	}
	private class LinkedListIterator implements Iterator {
		private  int currentIndex = 0;
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Object next() {
			return null;
		}
	}
}
