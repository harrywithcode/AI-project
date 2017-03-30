
public class MainDriver {
	public static void main(String[] args){
		InputGraph inputGraph = new InputGraph();
		Container container = inputGraph.graph();
		
		//PrintMatrix printMatrix = new PrintMatrix();
		//printMatrix.printOut(container);
		AStar a = new AStar();
		String part1 = "1";//any number except 0.25 and 0.75
		a.astar(container, part1);
		System.out.println("=========");
		
		String b = "0.75";
		a.astar(container, b);
		System.out.println("=========");
		
		String c = "0.25";
		a.astar(container, c);
	}
}
