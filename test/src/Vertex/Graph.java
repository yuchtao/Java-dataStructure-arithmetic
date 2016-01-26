package Vertex;

/**
 * 图 深度优先搜索
 * @author chenj
 *
 */
public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private StackX theStack;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j]=0;
			}
		}
		theStack = new StackX();
	}
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start,int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v){
		System.out.println(vertexList[v].label);
	}
	
	public int getAdjUnvisitedVertex(int v){
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
	public void dfs(){ //depth-first search
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theStack.push(0);
		
		while( !theStack.isEmpty()){
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) {
				theStack.pop();
			}else{
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		
		theGraph.addEdge(0,1);
		theGraph.addEdge(1,2);
		theGraph.addEdge(0,3);
		theGraph.addEdge(3,4);
		
		System.out.println("Visits:");
		theGraph.dfs();
		System.out.println();
	}
	
}

