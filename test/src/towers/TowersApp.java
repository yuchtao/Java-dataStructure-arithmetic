package towers;

public class TowersApp {
	static int Disk = 2;
	
	public static void main(String[] args) {
		DoTowers(Disk, 'A', 'B', 'C');
	}
	
	public static void DoTowers(int topN,char from,char inter,char to){
		/*System.err.println("============="+topN+","+from+","+inter+","+to);*/
		if (topN == 1) {
			System.out.println("Disk 1 from "+from+" to "+to);
		}else {
			DoTowers(topN-1, from, to, inter);
			System.out.println("Disk "+topN + "from" +from+ "to" +to);
			DoTowers(topN-1, inter, from,to);
		}
	}
}
