package test;

public class FirstLastLink {
	public int dData;
	public FirstLastLink next;
	
	public FirstLastLink(int a){
		dData = a;
	}
	
	public void displayLink(){
		System.out.println(dData + " ");
	}

	@Override
	public String toString() {
		return "FirstLastLink [dData=" + dData + ", next=" + next + "]";
	}
}
