
public class InputGraph {
	public Container graphRomania(){
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
		straight_dis[1] = 0;//endPoint
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
		straight_dis[19] = 374;//Start point
		
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
		matrix[17][18] = 142;
		
		//Vaslui
		matrix[18][8] = 92;
		matrix[18][17] = 142;
		
		//Zerind
		matrix[19][12] = 71;
		matrix[19][0] = 75;
				
		Container container = new Container(matrix, vertices, straight_dis);		
		return container;
	}
	
	
	public Container graphAirport(){
		//name of each city
		String[] vertices = new String[8];
		vertices[0] = "HNL";
		vertices[1] = "SFO";
		vertices[2] = "LAX";
		vertices[3] = "ORD";
		vertices[4] = "DFW";
		vertices[5] = "LGA";
		vertices[6] = "PVD";
		vertices[7] = "MIA";
		
		//straight=line distance to 6 PVD
		int[] straight_dis = new int[8];
		straight_dis[0] = 7000;
		straight_dis[1] = 4800;
		straight_dis[2] = 5000;
		straight_dis[3] = 849;
		straight_dis[4] = 1800;
		straight_dis[5] = 142;
		straight_dis[6] = 0;
		straight_dis[7] = 1205;
		
		//The distance between two cities
		//The city in row is start
		//The city in column is the end
		int[][]  matrix = new int [8][8];
		//HNL
		matrix[0][2] = 2555;
		
		//SFO
		matrix[1][2] = 337;
		matrix[1][3] = 1843;
		
		//LAX
		matrix[2][0] = 2555;
		matrix[2][1] = 337;
		matrix[2][3] = 1743;
		matrix[2][4] = 1233;
		
		//ORD
		matrix[3][1] = 1843;
		matrix[3][2] = 1743;
		matrix[3][4] = 802;
		matrix[3][6] = 849;
		
		//DFW
		matrix[4][2] = 1233;
		matrix[4][3] = 802;
		matrix[4][5] = 1387;
		matrix[4][7] = 1120;
		
		//LGA
		matrix[5][4] = 1387;
		matrix[5][6] = 142;
		matrix[5][7] = 1099;
		
		//PVD
		matrix[6][3] = 849;
		matrix[6][5] = 142;
		matrix[6][7] = 1205;
		
		//MIA
		matrix[7][4] = 1120;
		matrix[7][5] = 1099;
		matrix[7][6] = 1205;
		
		Container container = new Container(matrix, vertices, straight_dis);
		return container;
	}
	
	public Container numberGraph(){
		String[] vertices = new String[8];
		vertices[0] = "0";
		vertices[1] = "1";
		vertices[2] = "2";
		vertices[3] = "3";
		vertices[4] = "4";
		vertices[5] = "5";
		vertices[6] = "6";
		vertices[7] = "7";
		
		int[] straight_dis = new int [8];
		straight_dis[0] = 50;
		straight_dis[1] = 32;//endPoint
		straight_dis[2] = 19;
		straight_dis[3] = 6;
		straight_dis[4] = 16;
		straight_dis[5] = 40;
		straight_dis[6] = 44;
		straight_dis[7] = 0;
		
		//distance between two cities
		int[][] matrix  = new int [8][8];
		matrix [0][1] = 9;
		matrix [0][5] = 14;
		matrix [0][6] = 15;
		
		matrix [1][0] = 9;
		matrix [1][2] = 24;
		
		matrix[2][1] = 24;
		matrix[2][3] = 6;
		matrix[2][4] = 2;
		matrix[2][5] = 18;
		matrix[2][7] = 19;
		
		matrix[3][2] = 6;
		matrix[3][4] = 11;
		matrix[3][7] = 6;
		
		matrix[4][2] = 2;
		matrix[4][3] = 11;
		matrix[4][5] = 30;
		matrix[4][6] = 20;
		matrix[4][7] = 16;
		
		matrix[5][0] = 14;
		matrix[5][2] = 18;
		matrix[5][4] = 30;
		matrix[5][6] = 5;
		
		matrix[6][0] = 15;
		matrix[6][4] = 20;
		matrix[6][5] = 5;
		matrix[6][7] = 44;
		
		matrix[7][2] = 19;
		matrix[7][3] = 6;
		matrix[7][4] = 16;
		matrix[7][6] = 44;
		
		Container container = new Container(matrix,vertices, straight_dis);
		return container;
	}
	
	public Container englandGraph(){
		String[] vertices = new String[11];
		vertices[0] = "Liverpool";
		vertices[1] = "Manchester";
		vertices[2] = "Sheffield";
		vertices[3] = "Sherewsbury";
		vertices[4] = "B/jam";
		vertices[5] = "Nottingham";
		vertices[6] = "Aberystwyth";
		vertices[7] = "Cardiff";
		vertices[8] = "Bristol";
		vertices[9] = "Oxford";
		vertices[10] = "Southampton";
		
		int[] straight_dis = new int [11];
		straight_dis[0] = 230;
		straight_dis[1] = 210;//endPoint
		straight_dis[2] = 180;
		straight_dis[3] = 220;
		straight_dis[4] = 100;
		straight_dis[5] = 120;
		straight_dis[6] = 210;
		straight_dis[7] = 100;
		straight_dis[8] = 80;
		straight_dis[9] = 70;
		straight_dis[10] = 0;
		
		
		//distance between two cities
		int[][] matrix  = new int [11][11];
		matrix [0][1] = 30;
		matrix [0][5] = 110;
		matrix [0][3] = 70;
		
		matrix [1][0] = 30;
		matrix [1][2] = 40;
		
		matrix[2][1] = 40;
		matrix[2][5] = 40;
		
		
		matrix[3][0] = 70;
		matrix[3][4] = 50;
		matrix[3][6] = 80;
		matrix[3][7] = 110;
		
		matrix[4][3] = 50;
		matrix[4][5] = 50;
		matrix[4][8] = 90;
		matrix[4][9] = 70;
		
		matrix[5][0] = 110;
		matrix[5][2] = 40;
		matrix[5][4] = 50;
		matrix[5][9] = 100;
		
		matrix[6][3] = 80;
		matrix[6][7] = 120;
		
		matrix[7][3] = 110;
		matrix[7][6] = 120;
		matrix[7][8] = 50;
		
		matrix[8][4] = 90;
		matrix[8][7] = 50;
		matrix[8][10] = 80;
		
		matrix[9][4] = 70;
		matrix[9][5] = 100;
		matrix[9][10] = 70;
		
		matrix[10][8] = 80;
		matrix[10][9] = 70;
		
		
		Container container = new Container(matrix,vertices, straight_dis);
		return container;
	}
}
