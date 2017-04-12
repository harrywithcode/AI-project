import java.util.*;
public class HillClimbing extends GraphSearch {
	//Only focus on straight distance
	//private ArrayList<Node> expand = new ArrayList<Node>();
	
	public SearchAnswerPackage hill(Node startPoint, Node endPoint, Container c){
		ArrayList<Node> expand = new ArrayList<Node>();
		ArrayList<Node> visited = new ArrayList<Node>();
		SearchAnswerPackage result = new SearchAnswerPackage();
		if(startPoint != null){
			Stack<Node> stack = new Stack<Node>();
			stack.push(startPoint);
			//for(int k = 0; k < 4; k++){
			while(!stack.isEmpty()){
				Node n = stack.pop();
				expand.add(n);
				n.addStep(n);
				n.setPathLength(n.getUnitDis() + n.getPathLength());
				visited.add(n);
				if(n.equals(endPoint)){
					result.setExpand(expand);
					result.setPath(n.getPath());
					result.setPathLength(n.getPathLength());
					return result;
				}
				ArrayList<Node> eachRow = this.getGraph(c).get(n.getId());
				int min = Integer.MAX_VALUE;
				int nodeId = 0;
				for(int i = 0; i < eachRow.size(); i++){
					if(!n.getPath().contains(eachRow.get(i))){
						//System.out.println("distance " + eachRow.get(i).getStraight_dis());
						if(eachRow.get(i).getStraight_dis() < min){
							min = eachRow.get(i).getStraight_dis();
							nodeId = i;
						}
					}
				}
				//System.out.println("&&&&&&");
				//System.out.println("The minimum " + eachRow.get(nodeId).getId());
				Node eachNode = eachRow.get(nodeId);
				if(eachNode.getPathLength() != 0 ||visited.contains(eachNode)){
					Node duplicate = new Node(eachNode.getId(), eachNode.getStraight_dis()
							, eachNode.getUnitDis());//can not write duplicate = eachNode
					duplicate.setPathLength(n.getPathLength());
					duplicate.copyPath(n);
					stack.push(duplicate);
				}
				else{
					eachNode.copyPath(n);
					eachNode.setPathLength(n.getPathLength());
					stack.push(eachNode);
				}
			}
		}
		return result;
	}
}
