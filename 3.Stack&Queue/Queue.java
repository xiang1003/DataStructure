public class Queue {
	int s[];
	int front;
	int rear;
	boolean flag;
	public Queue(int size) {
		this.s = new int[size];
		this.front = 0;
		this.rear = 0;	
		flag = false;
	}
	
	public void enqueue(int d) {
		if (isFull()) {
			System.out.println("Queue is full");
		} else {
			s[rear] = d;
			rear = (rear+1) % s.length;
			if (rear == front) flag = true;
		}
	}
	
	public int dequeue() throws Exception {
		if (isEmpty()) throw new Exception("Queue is empty");
		else {			
			int res = s[front];
			s[front] = 0;
			front = (front+1) % s.length;
			if (front == rear) flag = false;
			return res;
		}
	}
	
	public boolean isEmpty() {
        return (front == rear && !flag);
    }
    
    public boolean isFull() {
        return (front == rear && flag);
    }

	public void listAll() {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.dequeue());
		q.listAll();
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.listAll();
	}
}