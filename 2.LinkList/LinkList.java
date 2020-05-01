public class LinkList {
	Node head;
	public LinkList() {
		head = new Node();
		head.next = null;
	}
	
	public void add(int data) {
		Node ptr = new Node();
		ptr.data = data;
		ptr.next = null;
		
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = ptr;
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
	
	public void invert() {
		Node pre = null;
		Node curr = null;
		Node forward = head.next;
		while (forward != null) {
			pre = curr;
			curr = forward;
			forward = forward.next;
			curr.next = pre;
		}
		head.next = curr;
	}
	
	public void listAll() {
		Node curr = head.next;
		System.out.print("head->");
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LinkList link = new LinkList();
		link.add(2);
		link.add(3);
		link.add(4);
		link.add(5);
		link.listAll();
		link.delete(3);
		link.listAll();
		link.invert();
		link.listAll();
	}
}