public class Stack {
	int s[];
	int top;
	int size;
	public Stack(int size) {
		s = new int[size];
		this.size = size;
		this.top = -1;
		for (int i = 0; i < s.length; i++) {
			s[i] = 0;
		}
	}
	
	public void push(int d) {
		if (top == size-1) {
			System.out.println("Stack is full");
		} else {
			s[++top] = d;
		}
	}
	
	public int pop() throws Exception {
		if (top == -1) {
			throw new Exception("Stack is empty");
		} else {
			int res = s[top];
			s[top--] = 0;
			return res;
		}
	}
	
	public void listAll() {
		for (int i = 0; i <= top; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		Stack s = new Stack(3);
		s.push(1);
		s.push(2);
		s.push(3);
		s.listAll();
		System.out.println(s.pop());
		s.listAll();
	} 
}