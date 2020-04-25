public class DoublyList {
	DoublyNode head;
	public DoublyList() {
		head = null;
	}
	
	public void add(int data) {
		DoublyNode ptr = new DoublyNode();
		ptr.data = data;
		if (head == null) {
			head = new DoublyNode();
			head.rlink = ptr;
			head.llink = ptr;
		} else {
			head.llink.rlink = ptr;
			ptr.llink = head.llink;
			ptr.rlink = head.rlink;
			head.rlink.llink = ptr;
			head.llink = ptr;
		}
	}
	
	public void delete(int data) {
		DoublyNode curr = head.rlink;
		boolean flag = true;
		while (curr != head.rlink || flag) {
			if (curr.data == data) {
				curr.llink.rlink = curr.rlink;
				curr.rlink.llink = curr.llink;
				if (head.rlink == curr) head.rlink = curr.rlink;
				if (head.llink == curr) head.llink = curr.llink;
				break;
			}
			curr = curr.rlink;
			flag = false;
		}
	}
	
	public void listAll() {
		DoublyNode curr = head.rlink;
		System.out.print("head->");
		while (curr.rlink != head.rlink) {
			System.out.print(curr.data + "->");
			curr = curr.rlink;
		}
		System.out.println(curr.data);
	}
	
	public static void main(String[] args) {
		DoublyList link = new DoublyList();
		link.add(2);
		link.add(3);
		link.add(4);
		link.add(5);
		link.listAll();
		link.delete(2);
		link.delete(5);
		link.delete(6);
		link.listAll();
	}
}