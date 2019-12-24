package sorting;

public class QuickSort {
	
	public int a;
	
	public QuickSort() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void setA(int a) {
		this.a =a;
	}
	public int getA() {
		return this.a;
	}
	
	
	public static void main(String[] args) {

		
		QuickSort q = new QuickSort();
		int a = 5;
		q.setA(a);
		
		q.setA(3);
		a = q.getA();
		
		
		System.out.println(a);
		
	}
}
