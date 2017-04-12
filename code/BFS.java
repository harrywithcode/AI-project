import java.util.*;
public class BFS extends GraphSearch {
	
	public SearchAnswerPackage bfs(Node startPoint, Node endPoint, Container c){
		ArrayList<Node> expandBFS = new ArrayList<Node>();
		SearchAnswerPackage result = new SearchAnswerPackage();
		ArrayList<Node> visited = new ArrayList<Node>();
		
		if(startPoint !=null){
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(startPoint);			
			//for(int time = 0; time < 6;time++){
			while(!queue.isEmpty()){
				Node n = queue.poll();				
				//System.out.println(n.getId()+"*"/*+n.getStraight_dis()*/);
				expandBFS.add(n);
				n.addStep(n);
				n.setPathLength(n.getUnitDis() + n.getPathLength());
				visited.add(n);
				
//				System.out.println("Node n has a path as: " + n.getId()+" path length " +n.getPathLength());
//				for(int i = 0;i < n.getPath().size();i++){
//					System.out.println(n.getPath().get(i));
//				}			
				if(n.equals(endPoint)){
					result.setExpand(expandBFS);
					result.setPath(n.getPath());
					result.setPathLength(n.getPathLength());
					return result;
				}
				
				//System.out.println("%%%%")
				ArrayList<Node> eachRow = this.getGraph(c).get(n.getId());//this graph is not read by matrix
				
				for(Node eachNode : eachRow){
					if(!n.getPath().contains(eachNode.getId())/*!visited.contains(eachNode) && !queue.contains(eachNode)*/){ 	
						//you have to override contains method, or it will compare address instead of value						
						//queue.add(eachNode);
						
						//no matter what difference between two eachNode.id=5 
						//before next two line, program think this new eachNode.id = 5 
						//is the old one, and change below operation based on previous eachNode.id=5
						//System.out.println("%%%% "+ eachNode.getPathLength());
						if(eachNode.getPathLength() != 0 ||visited.contains(eachNode)){
							Node duplicate = new Node(eachNode.getId(), eachNode.getStraight_dis()
									, eachNode.getUnitDis());//can not write duplicate = eachNode
							duplicate.setPathLength(n.getPathLength());
							duplicate.copyPath(n);
							queue.add(duplicate);
						}
						else{
							eachNode.copyPath(n);
							eachNode.setPathLength(n.getPathLength());
							queue.add(eachNode);
						}
						
//						System.out.print("eachNode has path " + eachNode.getId() +" ||path length "+ eachNode.getPathLength()+ "||  ");
//						for(int k : eachNode.getPath()){
//							System.out.print(k + "  ");
//						}
						//System.out.println(eachNode.getId()+"--"+eachNode.getUnitDis());
					}
				}
			}
		}	
		return result;
	}
}
