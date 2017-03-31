import java.util.*;
public class BFS {
	private ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	private String[] vertices;
	private int[] straight_dis;
	private ArrayList<Integer> path = new ArrayList<Integer>();
	//private ArrayList<ArrayList<Node>> dataGraph = 
	//private Node[] nodeList;
	//Pass test
	//Read graph information. Change structure from [][] to dynamic list
	/*Example
	 * 0  140  118  75  
	 * 1  211  90  101  85  
	 * 2  120  138  146  */
	public ArrayList<ArrayList<Node>> getGraph(Container c){
		int[][] matrix = c.getMatrix();
		for(int i = 0; i < matrix.length; i++){
			ArrayList<Node> eachRow = new ArrayList<Node>();
			eachRow.add(new Node(i,0));
			for(int j = 0; j < matrix[0].length; j++){
				if(/*j >= i &&*/ matrix[i][j] != 0){
					eachRow.add(new Node(j, matrix[i][j]));//not straight distance
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
	//return path
//	public ArrayList<Integer> bfs(Node startPoint, Node endPoint){
//		System.out.println(startPoint.getId());
//		path.add(startPoint.getId());
//		System.out.println("*");
//		ArrayList<Node> eachRow = graph.get(startPoint.getId());
//
//		if(eachRow.contains(endPoint)){//problem
//			path.add(endPoint.getId());
//			return path;
//		}
//		for(int i = 0; i < eachRow.size(); i++){			
//			if(!path.contains(eachRow.get(i).getId())){
//				startPoint = eachRow.get(i);
//				//bfs(startPoint, endPoint);
//			}
//		}
//		return bfs(startPoint, endPoint);
//	}
	
	public ArrayList<Integer> bfs(Node startPoint, Node endPoint, Container c){
		System.out.println(startPoint.getId());
		path.add(startPoint.getId());
		System.out.println("*");
		ArrayList<Node> eachRow = this.getGraph(c).get(startPoint.getId());//this graph is not read by matrix

		if(eachRow.contains(endPoint)){//problem
			path.add(endPoint.getId());
			//System.out.println(endPoint.getId());
			return path;
		}
		else{
			for(int i = 0; i < eachRow.size(); i++){			
				if(!path.contains(eachRow.get(i).getId())){
					startPoint = eachRow.get(i);
					//return bfs(startPoint, endPoint, c);
				}
			}
		}
		return bfs(startPoint, endPoint, c);
	}

}
