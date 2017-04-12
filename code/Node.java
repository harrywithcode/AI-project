import java.util.*;
public class Node {
	private int straight_dis;
	private int id;
	private int unitDis;
	private int pathLength;
	private ArrayList<Integer> path = new ArrayList<Integer>();//dynamic array must initialize
	
	public Node(int id, int straight_dis, int unitDis){
		this.straight_dis = straight_dis;
		this.id = id;
		this.unitDis = unitDis;
	}
	public void resetPath(){
		path = new ArrayList<Integer>();
	}
	public void copyPath(Node n){
		//path.addAll(n.getPath());//this is not copy, this is add
		//what I want is rewrite the arraylist.
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i : n.getPath()){
			arr.add(i);
		}
		path = arr;
	}
	public void addStep(Node n){
		path.add(n.getId());
	}
	public ArrayList<Integer> getPath(){
		return path;
	}
	public void setPathLength(int a){
		pathLength = a;
	}
	public int getPathLength(){
		return pathLength;
	}
	public void setStraight_dis(int a){
		straight_dis = a;
	}
	public int getStraight_dis(){
		return straight_dis;
	}
	public void setId(int b){
		id = b;
	}
	public int getId(){
		return id;
	}
	public void setUnitDis(int c){
		unitDis = c;
	}
	public int getUnitDis(){
		return unitDis;
	}
	@Override
	public boolean equals(Object object){
		boolean result = false;
		
		if(object instanceof Node){
			Node node = (Node)object;
			result = (node.getId() == this.id && node.getStraight_dis() == this.straight_dis
					/*&& node.getPathLength() == this.getPathLength()
					/&& node.getUnitDis() == this.unitDis*/);//I want to ignore the specific position of node
		}
		return result;
	}
	
	@Override
	public int hashCode(){
		int result = 17;
		result = 31 * result + id; // Since id is int type. If variable is string type, use + [string].hashCode();
		result = 31 * result + straight_dis;
		result = 31 * result + unitDis;
		return result;
	}
}
