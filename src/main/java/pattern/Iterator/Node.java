package pattern.Iterator;

public class Node {
	private Object data;
	private Object next;
	public Node (Object data,Object next) {
		this.data = data;
		this.next = next;
	}
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getNext() {
		return next;
	}

	public void setNext(Object next) {
		this.next = next;
	}
}
