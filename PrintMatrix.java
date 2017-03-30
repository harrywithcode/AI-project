
public class PrintMatrix {
	public void printOut(Container container){
		int[][] matrix = container.getMatrix();
		String[] vertices = container.getVertices();
		System.out.println("----    0   -  1          -  2        -"
				+ "  3        -  4       -  5        -  6        -  7        "
				+ "-  8     -  9      -  10       -  11      -  12      "
				+ "-  13        -  14                -  15      -  16        -  17        "
				+ "-  18      -   19");
		System.out.println("----  Arad  -  Bucharest  -  Craiova  -"
				+ "  Dobreta  -  Eforie  -  Fagaras  -  Giurgiu  -  Hirsova  "
				+ "-  Iasi  -  Lugoj  -  Mehadia  -  Neamt   -  Oradea  "
				+ "-  Pitesti   -  Rimnicu Vilcea    -  Sibiu   -  Timisoara -  Urziceni  "
				+ "-  Vaslui  -   Zerind");
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print( i +" " + vertices[i] + "|");
			for (int j = 0; j < 20; j++) {
//				if(matrix[i][j] <19){
					System.out.print("   " + matrix[i][j] + "   " + " - ");
//				}
//				else{
//					System.out.print(" " + matrix[i][j] + "  " );
//				}
			}
			System.out.println("\n");
		}
	}
}
