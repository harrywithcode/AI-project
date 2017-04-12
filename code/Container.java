
public class Container {
	private int[][] matrix;
	private String[] vertices;
	private int[] straight_dis;
	
	public Container(int[][] matrix, String[] vertices, int[] straight_dis){
		this.matrix = matrix;
		this.vertices = vertices;
		this.straight_dis = straight_dis;
	}
	public int[][] getMatrix(){
		return matrix;
	}
	public String[] getVertices(){
		return vertices;
	}
	public int[] getStraight_dis(){
		return straight_dis;
	}
	
}
