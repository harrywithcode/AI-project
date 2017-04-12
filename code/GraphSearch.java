import java.util.*;
public class GraphSearch {
	private ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	private String[] vertices;
	private int[] straight_dis;
	 
	//Pass test
	//Read graph information. Change structure from [][] to dynamic list
	//Node only compare ID number and straight_distance, no unit distance will be compared
	public ArrayList<ArrayList<Node>> getGraph(Container c){
		int[][] matrix = c.getMatrix();
		for(int i = 0; i < matrix.length; i++){
			ArrayList<Node> eachRow = new ArrayList<Node>();
			eachRow.add(new Node(i,c.getStraight_dis()[i],0));
			for(int j = 0; j < matrix[0].length; j++){
				if(/*j >= i &&*/ matrix[i][j] != 0){
					eachRow.add(new Node(j, c.getStraight_dis()[j], matrix[i][j]));//not straight distance
				}
			}
			graph.add(eachRow);
		}
		return graph;
	}
	//Pass test
	public String[] getVertices(Container c){
		vertices = c.getVertices();
		return vertices;
	}
	//Pass test
	public int[] getStraight_dis(Container c){
		straight_dis = c.getStraight_dis();
		return straight_dis;
	}
}
