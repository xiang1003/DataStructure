public class CircularLinkList {
	Node head;
	public CircularLinkList() {
		head = new Node();
		head.next = null;
	}
	
	public void add(int data) {
		Node ptr = new Node();
		ptr.data = data;
		ptr.next = head.next;
		
		Node curr = head.next;
		if (curr == null) {
			head.next = ptr;
			ptr.next = ptr;
		} else {
			while (curr.next != head.next) {
				curr = curr.next;
			}
			curr.next = ptr;
		}
	}
	
	public void delete(int data) {
		Node pre = head;
		Node curr = head.next;
		while (curr != null) {
			if (curr.data == data) {
				pre.next = curr.next;
				break;
			}
			pre = curr;
			curr = curr.next;
		}
	}
	
	public void listAll() {
		Node curr = head.next;
		boolean flag = true;
		System.out.print("head->");
		while ((curr != null && curr != head.next) || flag) {
			System.out.print(curr.data + "->");
			curr = curr.next;
			flag = false;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularLinkList link = new CircularLinkList();
		link.add(2);
		link.add(3);
		link.add(4);
		link.add(5);
		link.listAll();
		link.delete(3);
		link.delete(5);
		link.listAll();
	}
}