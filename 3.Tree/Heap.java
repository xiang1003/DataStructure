public class Heap {
	int tree[];
	int size;
	public Heap() {
		//第一個空出來
		this.tree = new int[1000];
		this.size = 0;
	}
	
	public Heap(int[] tree) {
		this();
		for (int i = 0; i < tree.length; i++) {
			this.tree[++size] = tree[i];
		}
		build(this.tree,this.size);
	}
	
	public void build(int[] tree, int n) {
		for(int i = n/2; i >= 1; i--) {
			adjust(tree,i,n);
		}
	}
	
	public void adjust(int[] tree, int i, int n) {
		int x = tree[i];
		int j = i*2;
		while(j<=n) {
			if (tree[j] < tree[j+1]) j = j+1;
			if (x>=tree[j]) break;
			else {
				tree[j/2] = tree[j];
				j=j*2;
			}
		}
		tree[j/2] = x;
	}
	
	public void add(int d) {
		this.tree[++size] = d;
		int n = size;
		while(n > 1) {
			if (tree[n] > tree[n/2]) {
				int temp = tree[n];
				tree[n] = tree[n/2];
				tree[n/2] = temp;
			} else {
				break;
			}
			n = n/2;
		}
	}
	
	public void deleteMax() {
		tree[1] = tree[size];
		tree[size--] = 0;
		adjust(tree,1,size);
	}
	
	public void listAll() {
		for (int i = 1;i <= size;i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(new int[]{1,2,5});
		heap.listAll();
		heap.add(7);
		heap.add(4);
		heap.add(8);
		heap.add(6);
		heap.add(9);
		heap.listAll();
		heap.deleteMax();
		heap.listAll();
	}
}