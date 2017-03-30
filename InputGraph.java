
public class InputGraph {
	public Container graph(){
		//name of each city
		String[] vertices = new String[20];
		vertices[0] = "Arad";
		vertices[1] = "Bucharest";
		vertices[2] = "Craiova";
		vertices[3] = "Dobreta";
		vertices[4] = "Eforie";
		vertices[5] = "Fagaras";
		vertices[6] = "Giurgiu";
		vertices[7] = "Hirsova";
		vertices[8] = "Iasi";
		vertices[9] = "Lugoj";
		vertices[10] = "Mehadia";
		vertices[11] = "Neamt";
		vertices[12] = "Oradea";
		vertices[13] = "Pitesti";
		vertices[14] = "Rimnicu Vilcea";
		vertices[15] = "Sibiu";
		vertices[16] = "Timisoara";
		vertices[17] = "Urziceni";
		vertices[18] = "Vaslui";
		vertices[19] = "Zerind";
		
		//Straight-line distance to Bucharest
		int[] straight_dis = new int[20];
		straight_dis[0] = 366;
		straight_dis[1] = 0;
		straight_dis[2] = 160;
		straight_dis[3] = 242;
		straight_dis[4] = 161;
		straight_dis[5] = 178;
		straight_dis[6] = 77;
		straight_dis[7] = 151;
		straight_dis[8] = 226;
		straight_dis[9] = 244;
		straight_dis[10] = 241;
		straight_dis[11] = 234;
		straight_dis[12] = 380;
		straight_dis[13] = 98;
		straight_dis[14] = 193;
		straight_dis[15] = 253;
		straight_dis[16] = 329;
		straight_dis[17] = 80;
		straight_dis[18] = 199;
		straight_dis[19] = 374;
		
		//The distance between two city
		//The city in the row is the start
		//The city in the column is the end
		int[][] matrix =  new int [20][20];
		//Arad
		matrix[0][19] = 75;
		matrix[0][15] = 140;
		matrix[0][16] = 118;
		
		//Bucharest
		matrix[1][5] = 211;
		matrix[1][13] = 101;
		matrix[1][6] = 90;
		matrix[1][17] = 85;
		
		//Craiova
		matrix[2][3] = 120;
		matrix[2][14] = 146;
		matrix[2][13] = 138;
		
		//Dobreta
		matrix[3][2] = 120;
		matrix[3][10] = 75;
		
		//Eforie
		matrix[4][7] = 86;
		
		//Fagaras
		matrix[5][15] = 99;
		matrix[5][1] = 211;
		
		//Giurgiu
		matrix[6][1] = 90;
		
		//Hirsova
		matrix[7][17] = 98;
		matrix[7][4] = 86;
		
		//Iasi
		matrix[8][11] = 87;
		matrix[8][18] = 92;
		
		//Lugoj
		matrix[9][16] = 111;
		matrix[9][10] = 75;
		
		//Mehadia
		matrix[10][9] = 70;
		matrix[10][3] = 75;
		
		//Neamt
		matrix[11][8] = 87;
		
		//Oradea
		matrix[12][19] = 71;
		matrix[12][15] = 151;
		
		//Pitesti
		matrix[13][14] = 97;
		matrix[13][2] = 138;
		matrix[13][1] = 101;
		
		//Rimnicu Vilcea
		matrix[14][15] = 80;
		matrix[14][2] = 146;
		matrix[14][13] = 97;
		
		//Sibiu
		matrix[15][12] = 151;
		matrix[15][0] = 140;
		matrix[15][14] = 80;
		matrix[15][5] = 99;
		
		//Timisoara
		matrix[16][0] = 118;
		matrix[16][9] = 111;
		
		//Urziceni
		matrix[17][1] = 85;
		matrix[17][7] = 98;
		
		//Vaslui
		matrix[18][8] = 92;
		matrix[18][17] = 142;
		
		//Zerind
		matrix[19][12] = 71;
		matrix[19][0] = 75;
				
		Container container = new Container(matrix, vertices, straight_dis);		
		return container;
	}
}
