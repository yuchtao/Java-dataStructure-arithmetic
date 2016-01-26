package test;

public class SortLink {
	public int dData;
	public SortLink next;
	
	public SortLink(int data) {
		dData = data;
	}
	
	public void dispalyLink(){
		System.out.print(dData + " ");
	}

	@Override
	public String toString() {
		return "SortLink [dData=" + dData + ", next=" + next + "]";
	}

	
}
