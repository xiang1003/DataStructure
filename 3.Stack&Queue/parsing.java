public class parsing {
	/**
		判斷括號配對是否正確
	**/
	public static boolean compilerParsing(String text) throws Exception {
		Stack s = new Stack(text.length());
		
		for (char c : text.toCharArray()) {
			if (c == '(') s.push(c);
			else {
				if (s.isEmpty()) return false;
				else s.pop();
			}
		}
		
		if (s.isEmpty()) return true;
		else return false;
	}
	/**
		判斷是否迴文
	**/
	public static boolean palindrome(String text) throws Exception {
		Stack s = new Stack(text.length());
		int len = text.length();
		char c[] = text.toCharArray();
		int i = 0;
		for(;i < len/2; i++) {
			s.push(c[i]);
		}
		if (len%2 == 1) i++;
		
		for (;i <len;i++) {
			char p = (char)s.pop();
			if (c[i] != p) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(compilerParsing("((()))"));
		System.out.println(palindrome("aaaaaa"));
	}
}