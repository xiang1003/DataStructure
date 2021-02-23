import java.util.Arrays;

public class Sort_Search {
	
	public static int LinearSearch(int A[], int k) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == k) return i;
		}
		return -1;
	}
	
	public static int BinarySearch(int A[], int l, int r,int k) {
		int mid = (l+r)/2;
		if (l > r) 
			return -1;
		else {
			if (k == A[mid]) {
				return mid;
			} else if (A[mid] > k) {
				return BinarySearch(A,l,mid-1,k);
			} else {
				return BinarySearch(A,mid+1,r,k);
			}
		}
	}
	
	public static void InsertionSort(int A[]) {
		for (int i = 1; i < A.length; i++) {
			insert(A,i);
		}
	}
	
	public static void insert(int A[], int k) {
		for (int i = k; i >= 1; i--) {
			if (A[i] < A[i-1]) {
				int temp = A[i];
				A[i] = A[i-1];
				A[i-1] = temp;
			} else {
				break;
			}
		}
	}
	
	public static void selectionSort(int A[]) {
		for (int i = 0; i < A.length-1; i++) {
			int key = i;
			for (int j = i+1; j < A.length; j++) {
				if(A[key] > A[j]) key = j;
			}
			int temp = A[key];
			A[key] = A[i];
			A[i] = temp;
		}
	}
	
	public static void BubbleSort(int A[]) {
		for (int i = 0; i < A.length-1; i++) {
			boolean flag = true;
			for (int j = 1; j < A.length-i; j++) {
				if (A[j-1] > A[j]) {
					int temp = A[j];
					A[j] = A[j-1];
					A[j-1] = temp;
					flag = false;
				}
			}
			
			if (flag) break;
		}
	}
	
	public static void QuickSort(int A[], int l, int r) {
		if (l < r) {
			int i = l+1;
			int j = r;
			int pivot = A[l];
			while (i < j) {
				while(i < j) {
					if (A[i] < pivot) i++;
					else break;
				}
				while (j > i) {
					if (A[j] > pivot) j--;
					else break;
				}
				if (i < j) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
			if (A[i] > pivot) {
				i--;
				j--;
			}
			for (int c=0; c < A.length;c++) {
				System.out.print(A[c] + ",");
			}
			System.out.println();
			int temp = A[l];
			A[l] = A[i];
			A[i] = temp;
			QuickSort(A,l,i-1);
			QuickSort(A,i+1,r);
		}
	}
	/**
		A[] : array
		r : range(r=8, range=0~8)
	**/
	public static int[] CountingSort(int A[], int r) {
		int start[] = new int [r+1];
		int count[] = new int [r+1];
		int output[] = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			count[A[i]] = count[A[i]] + 1;
		}
		
		start[0] = 0;
		for (int i = 1; i < r+1; i++) {
			start[i] = start[i-1] + count[i-1];
		}
		
		for (int i = 0; i < A.length; i++) {
			output[start[A[i]]] = A[i];
			start[A[i]] = start[A[i]] + 1;
		}
		return output;
	}
	
	public static void main(String[] args) {
		int A[] = {5,8,9,10,12,15,75,100};
		int B[] = {5,4,3,2,1};
		int C[] = {3,1,4,2,6,1,2,2};
		//System.out.println(LinearSearch(A,78));
		//System.out.println(BinarySearch(A,0,7,101));
		//InsertionSort(B);
		//selectionSort(B);
		//BubbleSort(B);
		QuickSort(B,0,B.length-1);
		//System.out.println(Arrays.toString(CountingSort(C,7)));
	}
}