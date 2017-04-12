import java.util.*;
public class AStarAlg extends GraphSearch{
	public SearchAnswerPackage astar(Node startPoint, Node endPoint, Container c){
		SearchAnswerPackage result = new SearchAnswerPackage();
		ArrayList<Node> expand = new ArrayList<Node>();
		ArrayList<Node> waitList = new ArrayList<Node>();
		waitList.add(startPoint);
		
		startPoint.copyPath(startPoint);
		startPoint.addStep(startPoint);

		//for(int t = 0;t < 5; t++){
		while(!waitList.isEmpty()){
			if(startPoint != null){
				for(int node = 0; node < waitList.size(); node++){
					if(waitList.get(node).equals(startPoint) && 
							waitList.get(node).getPath().equals(startPoint.getPath())){
						waitList.remove(node);
					}
				}
				
				expand.add(startPoint);
//				startPoint.addStep(startPoint);
//				startPoint.setPathLength(startPoint.getUnitDis() + startPoint.getPathLength());
//				
				if(startPoint.equals(endPoint)){
					result.setExpand(expand);
					result.setPath(startPoint.getPath());
					result.setPathLength(startPoint.getPathLength());
					return result;
				}
				
				
				Node n = startPoint;
				ArrayList<Node> eachRow = this.getGraph(c).get(n.getId());
				for(Node eachNode : eachRow){
					if(!n.getPath().contains(eachNode.getId())){
						if(eachNode.getPathLength() != 0){
							Node duplicate = new Node(eachNode.getId(), eachNode.getStraight_dis()
									, eachNode.getUnitDis());//can not write duplicate = eachNode
							duplicate.setPathLength(n.getPathLength());
							duplicate.copyPath(n);
							
							duplicate.addStep(duplicate);
							duplicate.setPathLength(duplicate.getUnitDis() + duplicate.getPathLength());
							
							
							waitList.add(duplicate);
						}
						else{
							eachNode.copyPath(n);
							eachNode.setPathLength(n.getPathLength());
							
							eachNode.addStep(eachNode);
							eachNode.setPathLength(eachNode.getUnitDis() + eachNode.getPathLength());
							
							
							waitList.add(eachNode);
						}
					}
				}
				
				//int min = Integer.MAX_VALUE;
				double min = Double.MAX_VALUE;
				Node minNode = eachRow.get(0);
				for(Node node : waitList){
					double fn = node.getPathLength()+node.getStraight_dis();
					if(fn < min){
						min = fn;
						minNode = node;
					}
				}
				startPoint = minNode;
				//System.out.println(minNode.getId()+"**");
			}
		}

//		for(Node n : getEnd){
//			for(int i : n.getPath()){
//				System.out.print(i+"  ");
//			}
//			System.out.println();
//		}
		return result;
	}
}
