import java.util.*;
public class DFS extends GraphSearch{
	//private ArrayList<Node> expand = new ArrayList<Node>();
	
	public SearchAnswerPackage dfs(Node startPoint, Node endPoint, Container c){
		ArrayList<Node> expandDFS = new ArrayList<Node>();
		SearchAnswerPackage result = new SearchAnswerPackage();
		ArrayList<Node> visited = new ArrayList<Node>();
		if(startPoint != null){
			Stack<Node> stack = new Stack<Node>();
			stack.push(startPoint);
			//for(int i = 0; i < 7; i++){
			while(!stack.isEmpty()){
				Node n = stack.pop();
				visited.add(n);
				expandDFS.add(n);
				n.addStep(n);
				n.setPathLength(n.getUnitDis() + n.getPathLength());
				//System.out.println(n.getId()+"*");
				
				if(n.equals(endPoint)){
					result.setExpand(expandDFS);
					result.setPath(n.getPath());
					result.setPathLength(n.getPathLength());
					return result;
				}
				ArrayList<Node> eachRow = this.getGraph(c).get(n.getId());//traverse from large to small
				for(Node eachNode : eachRow){
					//System.out.println(eachNode.getPathLength()+"--");
					if(!n.getPath().contains(eachNode.getId())){
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
//					if(!visited.contains(eachNode)){
//						stack.push(eachNode);					
//					}
				}
			}
		}
		return result;
	}
}
