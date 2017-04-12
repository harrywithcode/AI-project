import java.util.*;
public class SearchAnswerPackage {
	private ArrayList<Node> expand = new ArrayList<Node>();
	private ArrayList<Integer> path = new ArrayList<Integer>();
	private int pathLength;
	
//	public SearchAnswerPackage(ArrayList<Node> expand, ArrayList<Integer>path, int pathLength){
//		this.expand = expand;
//		this.path = path;
//		this.pathLength = pathLength;
//	}
	
	public void setExpand(ArrayList<Node> ex){
		expand = ex;
	}
	public ArrayList<Node> getExpand(){
		return expand;
	}
	public void setPath(ArrayList<Integer>pa){
		path = pa;
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
}
