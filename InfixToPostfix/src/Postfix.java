
public class Postfix {
	
	public static int evalPostfix(String postfix) {
		
		Stack stack = new Stack(postfix.length()/2+1);
		
		for(int i = 0; i < postfix.length(); i++) {
			
			char c = postfix.charAt(i);
			
			if(isAnOperator(c)) {
				
				int b = stack.top(); stack.pop();
				int a = stack.top(); stack.pop();
				
				if(c == '*') {
					stack.push(a * b);
				}
				if(c == '/') {
					stack.push(a / b);
				}
				if(c == '+') {
					stack.push(a + b);
				}
				if(c == '-') {
					stack.push(a - b);
				}
				
			}
			
			else {
				
				stack.push(c);
				
			}
			
		}
		
		return stack.top();
		
	}
	
	public static boolean isAnOperator(char c) {
		
		return (c == '*') || (c == '/') || (c == '+') || (c == '-');
		
	}

}
