import java.util.ArrayList;
import java.util.Scanner;


public class MainDriver {
	public static void main(String[] args){
		System.out.println("Please select the graph from 1 to 4");
		Scanner ss = new Scanner(System.in);
		String choice = ss.nextLine();
		//String choice = args[0];
		InputGraph inputGraph = new InputGraph();
		int choose = 0;
		try{
			choose = Integer.parseInt(choice);
		}
		catch (NumberFormatException nfe)
	    {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	      System.out.println("Please enter number between 1 to 4");
	    }
		int start = 0;
		int end = 0;
		Container container = null;
		
		if(choose == 1){
			container = inputGraph.graphRomania();
			start = 19;
			end = 1;
		}
		if(choose == 2){
			container = inputGraph.graphAirport();
			start = 0;
			end = 6;
		}
		if(choose == 3){
			container = inputGraph.numberGraph();
			start = 0;
			end = 7;
		}
		if(choose == 4){
			container = inputGraph.englandGraph();
			start = 0;
			end = 10;
		}
		System.out.println("========== Result ============");
		
		
		BFS bfs = new BFS();	
		int[] distanceBFS = bfs.getStraight_dis(container);
		Node startBFS = new Node(start,distanceBFS[start],0);
		Node endBFS = new Node(end,distanceBFS[end],0);
		
		SearchAnswerPackage resultBFS = new SearchAnswerPackage();
		resultBFS = bfs.bfs(startBFS,endBFS,container);
		System.out.print("BFS search expand: ");
		for(Node n : resultBFS.getExpand()){
			System.out.print(n.getId()+"  ");
		}
		System.out.println();
		System.out.print("BFS path: ");
		for(int i : resultBFS.getPath()){
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.print("BFS path length: ");
		System.out.println(resultBFS.getPathLength());
		
		
		
		System.out.println("======================");
		Beam beam = new Beam(); 
		int[] distanceBeam = beam.getStraight_dis(container);
		Node startBeam = new Node(start,distanceBeam[start],0);
		Node endBeam = new Node(end,distanceBeam[end],0);
		
		SearchAnswerPackage resultBeam = new SearchAnswerPackage();
		resultBeam = beam.beam(startBeam,endBeam,container);
		System.out.print("Beam search expand: ");
		for(Node n : resultBeam.getExpand()){
			System.out.print(n.getId()+"  ");
		}
		System.out.println();
		System.out.print("Beam search path: ");
		for(int i : resultBeam.getPath()){
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.print("Beam search path length: ");
		System.out.println(resultBeam.getPathLength());
		System.out.println("======================");
		
		
		
		System.out.println();
		DFS dfs = new DFS();
		int[] distanceDFS = dfs.getStraight_dis(container);
		Node startDFS = new Node(start,distanceDFS[start],0);
		Node endDFS = new Node(end,distanceDFS[end],0);
		
		SearchAnswerPackage resultDFS = new SearchAnswerPackage();
		resultDFS = dfs.dfs(startDFS,endDFS,container);
		System.out.print("DFS search expand: ");
		
		for(Node n : resultDFS.getExpand()){
			System.out.print(n.getId()+"  ");
		}
		
		System.out.println();
		System.out.print("DFS search path: ");
		for(int i : resultDFS.getPath()){
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.print("DFS search path length: ");
		System.out.println(resultDFS.getPathLength());
		System.out.println("======================");
		
		
		
		System.out.println();
		HillClimbing hill = new HillClimbing();
		int[] distanceHill = hill.getStraight_dis(container);
		Node startHill = new Node(start,distanceHill[start],0);
		Node endHill = new Node(end,distanceHill[end],0);
		
		SearchAnswerPackage resultHill = new SearchAnswerPackage();
		resultHill = hill.hill(startHill,endHill,container);
		System.out.print("Hill climbing search expand: ");
		
		for(Node n : resultHill.getExpand()){
			System.out.print(n.getId()+"  ");
		}
		
		System.out.println();
		System.out.print("Hill climbing search path: ");
		for(int i : resultHill.getPath()){
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.print("Hill climbing search path length: ");
		System.out.println(resultHill.getPathLength());	
		System.out.println("======================");
		
		
		
		System.out.println();
		BranchAndBound bab = new BranchAndBound();
		int[] distancebab = bab.getStraight_dis(container);
		Node startbab = new Node(start,distancebab[start],0);
		Node endbab = new Node(end,distancebab[end],0);
		
		SearchAnswerPackage resultbab = new SearchAnswerPackage();
		resultbab = bab.branchBound(startbab,endbab,container);
		System.out.print("branch and bound search expand: ");
		
		for(Node n : resultbab.getExpand()){
			System.out.print(n.getId()+"  ");
		}
		
		System.out.println();
		System.out.print("branch and bound search path: ");
		for(int i : resultbab.getPath()){
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.print("branch and bound search path length: ");
		System.out.println(resultbab.getPathLength());
		System.out.println("======================");
		
		
		
		
		System.out.println();
		RedundantPath red = new RedundantPath();
		int[] distancered = red.getStraight_dis(container);
		Node startred = new Node(start,distancered[start],0);
		Node endred = new Node(end,distancered[end],0);
		
		SearchAnswerPackage resultred = new SearchAnswerPackage();
		resultred = red.redundant(startred,endred,container);
		System.out.print("redundant path search expand: ");
		
		for(Node n : resultred.getExpand()){
			System.out.print(n.getId()+"  ");
		}
		
		System.out.println();
		System.out.print("redundant path search path: ");
		for(int i : resultred.getPath()){
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.print("redundant path search path length: ");
		System.out.println(resultred.getPathLength());
		System.out.println("======================");
		
		
		
		
		System.out.println();
		AStarAlg star = new AStarAlg();
		int[] distancestar = star.getStraight_dis(container);
		Node startstar = new Node(start,distancestar[start],0);
		Node endstar = new Node(end,distancestar[end],0);
		
		SearchAnswerPackage resultstar = new SearchAnswerPackage();
		resultstar = star.astar(startstar,endstar,container);
		System.out.print("A star search expand: ");
		
		for(Node n : resultstar.getExpand()){
			System.out.print(n.getId()+"  ");
		}
		
		System.out.println();
		System.out.print("A star search path: ");
		for(int i : resultstar.getPath()){
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.print("A star search path length: ");
		System.out.println(resultstar.getPathLength());

//		System.out.println();
//		IterativeDeepening deep = new IterativeDeepening();
//		int[] distanceDeep = deep.getStraight_dis(container);
//		Node startDeep = new Node(19,distanceDeep[19],0);
//		Node endDeep = new Node(1,distanceDeep[1],0);
//		
//		SearchAnswerPackage resultDeep = new SearchAnswerPackage();
//		resultDeep = deep.iterateDeep(startDeep,endDeep,container);
//		System.out.print("iterative deepening search expand: ");
//		
//		for(Node n : resultDeep.getExpand()){
//			System.out.print(n.getId()+"  ");
//		}
	
//		System.out.println();
//		RedundantPath red = new RedundantPath();
//		test = red.redundant(start, end, container);
//		System.out.print("Redundant Path Search: ");
//		for(Node n : test){
//			System.out.print(n.getId() + "  ");
//		}
			
	}
}
