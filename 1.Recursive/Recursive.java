public class Recursive {
	
	public static int Fac(int n) {
		if (n == 0) return 1;
		return n*Fac(n-1);
	}
	
	public static int Sum(int n) {
		if (n == 0) return 0;
		return n + Sum(n-1);
	}
	
	public static int Fib(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else return Fib(n-1) + Fib(n-2);		
	}
	
	//二項式係數
	public static int bin(int n, int m) {
		if (m == 0 || n == m) return 1;
		else return bin(n-1, m-1) + bin(n-1, m);
	}
	
	public static int Ackerman(int m, int n) {
		if (m == 0) return n+1;
		else if (n == 0) return Ackerman(m-1, 1);
		else return Ackerman(m-1,Ackerman(m,n-1));
	}
	
	public static int gcd(int a, int b) {
		if (a%b == 0) return b;
		else return gcd(b, a%b);
	}
	
	public static int exp(int x, int y) {
		if (y == 0) return 1;
		else return x*exp(x,y-1);
	}
	
	public static void Hanoi(int n, char a, char b, char c) {
		if (n == 1) System.out.println("move disc " + n + " from " + a + " to " + c);
		else {
			Hanoi(n-1,a,c,b);
			System.out.println("move disc " + n + " from " + a + " to " + c);
			Hanoi(n-1,b,a,c);
		}
	}
	
	public static void perm(int[] arr, int i, int n) {
		if (i == n) {
			for (int j = 0; j <= n; j++) {
				System.out.print(arr[j]);
			}
			System.out.println();
		} else {
			for (int j = i; j <= n; j++) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				perm(arr,i+1,n);
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Fac(5));
		System.out.println(Sum(5));
		System.out.println(Fib(10));
		System.out.println(bin(5,2));
		System.out.println(Ackerman(3,2));
		System.out.println(gcd(4,7));
		System.out.println(exp(2,7));
		Hanoi(3,'a','b','c');
		
		int[] arr = {1,2,3};
		perm(arr,0,2);
		
		System.out.println(Ackerman(3,2));
		System.out.println(Ackerman(2,4));
		
		System.out.println(bin(9,3));
		System.out.println(bin(9,5));
	}
}