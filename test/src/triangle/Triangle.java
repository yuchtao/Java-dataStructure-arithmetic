package triangle;

//�ݹ��㷨
public class Triangle {
	public static int triangle(int n){
		System.out.println("Entering:n= " + n);
		if (n == 1) {
			System.out.println("Return 1");
			return 1;
		}
		//���Խ�*��Ϊ+��
		int temp = n * triangle(n-1);
		System.out.println("Return " + temp);
		return temp;
	}
	
	public static void main(String[] args) {
		System.out.println(triangle(6));
	}
}
