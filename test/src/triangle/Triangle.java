package triangle;

//递归算法
public class Triangle {
	public static int triangle(int n){
		System.out.println("Entering:n= " + n);
		if (n == 1) {
			System.out.println("Return 1");
			return 1;
		}
		//可以将*变为+号
		int temp = n * triangle(n-1);
		System.out.println("Return " + temp);
		return temp;
	}
	
	public static void main(String[] args) {
		System.out.println(triangle(6));
	}
}
