
public class Stack {
	
	public int[] A;
	public int top = -1;
	
	public Stack(int size) {
		
		char[] A = new char[size];
		
	}
	
	public void push (int x) {
		
		top++;
		A[top] = x;
		
	}
	
	public void pop() {
		
		top--;
		
	}
	
	public int top() {
		
		return A[top];
		
	}
	
	public boolean isEmpty() {
		
		return top <= 0;
		
	}

}
