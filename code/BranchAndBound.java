import java.util.*;

public class BranchAndBound extends GraphSearch{
	
	public SearchAnswerPackage branchBound(Node startPoint, Node endPoint, Container c){
		
		SearchAnswerPackage result = new SearchAnswerPackage();
		ArrayList<Node> expand = new ArrayList<Node>();
		ArrayList<Node> waitList = new ArrayList<Node>();
		waitList.add(startPoint);
		//System.out.println(startPoint.getId()+"****");
		startPoint.copyPath(startPoint);
		//startPoint.addStep(startPoint);
		//for(int t = 0;t < 5; t++){
		ArrayList<Node> getEnd = new ArrayList<Node>();
		while(!waitList.isEmpty()){
			if(startPoint != null){
				//System.out.println(startPoint.getId() + " ***");
				
				for(int node = 0; node < waitList.size(); node++){
					if(waitList.get(node).equals(startPoint) && 
							waitList.get(node).getPath().equals(startPoint.getPath())){
						waitList.remove(node);
					}
				}
				
				
				expand.add(startPoint);
				startPoint.addStep(startPoint);
				startPoint.setPathLength(startPoint.getUnitDis() + startPoint.getPathLength());
				
				Node n = startPoint;
				ArrayList<Node> eachRow = this.getGraph(c).get(n.getId());
				for(Node eachNode : eachRow){
					if(!n.getPath().contains(eachNode.getId())){
						if(eachNode.getPathLength() != 0){
							Node duplicate = new Node(eachNode.getId(), eachNode.getStraight_dis()
									, eachNode.getUnitDis());//can not write duplicate = eachNode
							duplicate.setPathLength(n.getPathLength());
							duplicate.copyPath(n);
							
							waitList.add(duplicate);
						}
						else{
							eachNode.copyPath(n);
							eachNode.setPathLength(n.getPathLength());
							
							waitList.add(eachNode);
						}
					}
				}
				
//				for(Node nn : waitList){
//					System.out.print(nn.getId()+"  ");
//				}
//				System.out.println();
				int min = Integer.MAX_VALUE;
				Node minNode = eachRow.get(0);
				for(Node node : waitList){
					if(node.getPathLength() < min){
						min = node.getPathLength();
						minNode = node;
					}
				}
				startPoint = minNode;
				//========
				if(minNode.equals(endPoint)){
					getEnd.add(minNode);
				}
				//========
			}
		}
		ArrayList<Integer>minimumPath = new ArrayList<Integer>();
		int minimum = Integer.MAX_VALUE;
		for(Node n : getEnd){
			if(n.getPathLength() < minimum){
				minimum = n.getPathLength();
				minimumPath = n.getPath();
			}
		}
//		for(Node n : getEnd){
//			for(int i : n.getPath()){
//				System.out.print(i+"  ");
//			}
//			System.out.println();
//		}
		result.setExpand(expand);
		result.setPath(minimumPath);
		result.setPathLength(minimum);
		return result;
	}
}
