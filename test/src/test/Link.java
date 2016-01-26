package test;

public class Link {
	public int iData;
	public double dData;
	public Link next;
	
	public Link(int iData,double dData){
		this.dData = dData;
		this.iData = iData;
	}

	public void displayLink() {
		System.out.println("{ iData ="+iData+" , dData = "+dData+"}");
	}

	@Override
	public String toString() {
		return "Link [iData=" + iData + ", dData=" + dData + ", next=" + next
				+ "]";
	}
	
	
}
