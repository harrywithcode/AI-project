import java.util.*;
public class IterativeDeepening extends GraphSearch {	
	//left, right, and then root
	ArrayList<Node> expand = new ArrayList<Node>();
	ArrayList<Node> visited = new ArrayList<Node>();
	SearchAnswerPackage result = new SearchAnswerPackage();
	public SearchAnswerPackage iterateDeep(Node startPoint, Node endPoint, Container c){		
		visited.add(startPoint);
		//expand.add(startPoint);
		startPoint.addStep(startPoint);
		startPoint.setPathLength(startPoint.getUnitDis() + startPoint.getPathLength());
		
		if(startPoint.equals(endPoint)){
			result.setExpand(visited);
			result.setPath(startPoint.getPath());
			result.setPathLength(startPoint.getPathLength());
			return result;
		}
		ArrayList<Node> eachRow = this.getGraph(c).get(startPoint.getId());
		for(Node eachNode : eachRow){
			if(!startPoint.getPath().contains(eachNode.getId())){
				//System.out.println(eachNode.getId()+"**");
				if(eachNode.getPathLength() != 0 ||visited.contains(eachNode)){
					Node duplicate = new Node(eachNode.getId(), eachNode.getStraight_dis()
							, eachNode.getUnitDis());//can not write duplicate = eachNode
					duplicate.setPathLength(startPoint.getPathLength());
					duplicate.copyPath(startPoint);
					iterateDeep(duplicate, endPoint, c);
				}
				else{
					eachNode.copyPath(startPoint);
					eachNode.setPathLength(startPoint.getPathLength());
					iterateDeep(eachNode, endPoint, c);
				}
			}
		}
		expand.add(startPoint);	
		return result;
	}
}
