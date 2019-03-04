import java.util.StringTokenizer;

public class InfixToPostfix {
	
	public static void main(String[] args) {
		
		StringTokenizer st;
		String infix = "2+3*4";
		String postfix = infixToPostfix(infix);
		int result = evalPostfix(postfix);
		System.out.println(postfix + " = " + result);
		
	}
	
	public static int evalInfix(String infix) {
		
		String postfix = infixToPostfix(infix);
		int result = evalPostfix(postfix);
		return result;
		
	}
	
	public static String infixToPostfix(String infix) {
		
		Stack stack = new Stack(infix.length()/2);
		String postfix = "";
		
		for(int i = 0; i < infix.length(); i++) {
			
			char c = infix.charAt(i);
			
			if(isAnOperator(c)) {
				while((!stack.isEmpty()) && (prec(c) < prec(stack.top()))) {
					postfix += stack.top();    stack.pop();	
				}
				stack.push(c);
			}else {
				postfix += c;
			}
			
		} while(!stack.isEmpty()) {
			
			postfix += stack.top();
			
		}
		return postfix;
		
	}
	
	public static int evalPostfix(String postfix) {
		
		Stack stack = new Stack(postfix.length()/2+1);
		
		for(int i = 0; i < postfix.length(); i++) {
			
			char c = postfix.charAt(i);
			
			if(isAnOperator(c)) {
				
				int b = stack.top(); stack.pop();
				int a = stack.top(); stack.pop();
				
				if(c == '*')    stack.push(a * b);
				if(c == '/')    stack.push(a / b);
				if(c == '+')    stack.push(a + b);
				if(c == '-')    stack.push(a - b);
				
			}else {
				
				stack.push(c-'0');
				
			}
			
		}
		
		return stack.top();
		
	}
	
	public static boolean isAnOperator(char c) {
		
		return (c == '*') || (c == '/') || (c == '+') || (c == '-');
		
	}
	
	public static int prec(char op) {
		
		if(op == '^')    
			return 30;
		if((op == '*') || (op == '/'))
			return 29;
		if((op == '+') || (op == '-'))
			return 4;
		return 0;
		
	}

}
