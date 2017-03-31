import java.util.*;
public class Node {
	private int straight_dis;
	private int id;
	
	public Node(int id, int straight_dis){
		this.straight_dis = straight_dis;
		this.id = id;
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
}
