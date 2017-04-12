import java.util.*;
public class RedundantPath extends GraphSearch{
	
	public SearchAnswerPackage redundant(Node startPoint, Node endPoint, Container c){
		ArrayList<Node> expand = new ArrayList<Node>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Node> waitList = new ArrayList<Node>();
		ArrayList<Integer> waitListId = new ArrayList<Integer>();
		SearchAnswerPackage result = new SearchAnswerPackage();
		ArrayList<Node> getEnd = new ArrayList<Node>();
		
		waitList.add(startPoint);
		waitListId.add(startPoint.getId());		
		startPoint.copyPath(startPoint);
		//visited.add(startPoint.getId());
		
		//for(int t = 0;t < 1; t++){
			
		while(!waitList.isEmpty()){
			if(startPoint != null){
				
				for(int node = 0; node < waitList.size(); node++){
					if(waitList.get(node).equals(startPoint)){
						waitList.remove(node);
					}
				}
				
				for(int id = 0; id < waitListId.size(); id++){
					if(waitListId.get(id).equals(startPoint.getId())){
						waitListId.remove(id);
					}
				}
				//waitListId.remove(startPoint.getId());
				
				expand.add(startPoint);
				startPoint.addStep(startPoint);
				startPoint.setPathLength(startPoint.getUnitDis() + startPoint.getPathLength());
				
				//System.out.println(startPoint.getId() + " ***");
				
				Node n = startPoint;
				ArrayList<Node> eachRow = this.getGraph(c).get(n.getId());
				for(Node eachNode : eachRow){
					if(eachNode.equals(endPoint)){
						Node duplicate = new Node(eachNode.getId(), eachNode.getStraight_dis()
								, eachNode.getUnitDis());//can not write duplicate = eachNode
						duplicate.setPathLength(n.getPathLength()+ duplicate.getUnitDis());
						duplicate.copyPath(n);
						duplicate.addStep(duplicate);
						getEnd.add(duplicate);
						continue;
					}
					if(!n.getPath().contains(eachNode.getId()) && !visited.contains(eachNode.getId())
							/*&& !waitListId.contains(eachNode.getId())*/){
						//System.out.println(eachNode.getId()+"&&&");
						if(eachNode.getPathLength() != 0){
							Node duplicate = new Node(eachNode.getId(), eachNode.getStraight_dis()
									, eachNode.getUnitDis());//can not write duplicate = eachNode
							duplicate.setPathLength(n.getPathLength());
							duplicate.copyPath(n);
							
							waitList.add(duplicate);
							waitListId.add(duplicate.getId());
							visited.add(duplicate.getId());
						}
						else{
							eachNode.copyPath(n);
							eachNode.setPathLength(n.getPathLength());
							
							waitList.add(eachNode);
							waitListId.add(eachNode.getId());
							visited.add(eachNode.getId());
						}					
					}
				}
				
//				for(Node nn : waitList){
//					System.out.print(nn.getId()+"  ");
//				}
//				System.out.println("");
				
				int min = Integer.MAX_VALUE;
				Node minNode = eachRow.get(0);
				for(Node node : waitList){
					if(node.getPathLength() < min){
						min = node.getPathLength();
						minNode = node;
					}
				}
				startPoint = minNode;
				
				if(minNode.equals(endPoint)){
					getEnd.add(minNode);
				}
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
