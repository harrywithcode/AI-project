import java.util.*;
public class Beam extends GraphSearch{
	//private ArrayList<Node> expandBeam = new ArrayList<Node>();
	
		
	public SearchAnswerPackage beam(Node startPoint, Node endPoint, Container c){
		ArrayList<Node> expandBeam = new ArrayList<Node>();
		SearchAnswerPackage result = new SearchAnswerPackage();
		ArrayList<Node> visited = new ArrayList<Node>();
		if(startPoint !=null){
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(startPoint);
			
			//for(int time = 0; time < 5;time++){
			while(!queue.isEmpty()){
				Node n = queue.poll();
				
				//System.out.println(n.getId()+"*"/*+n.getStraight_dis()*/);
				expandBeam.add(n);
				n.addStep(n);//====================don't add step here, or you will add root twice
				n.setPathLength(n.getUnitDis() + n.getPathLength());
				visited.add(n);
				if(n.equals(endPoint)){
				//if(n.getId() == (endPoint.getId())){
//					for(int k = 0; k < n.getPath().size(); k++){
//						System.out.println(n.getPath().get(k)+"^^^^");
//					}
					result.setExpand(expandBeam);
					result.setPath(n.getPath());
					result.setPathLength(n.getPathLength());
					return result;
				}
				
				ArrayList<Node> eachRow = this.getGraph(c).get(n.getId());//this graph is not read by matrix
				/* test part
				Node test = new Node(0,366,75);
				queue.add(test);
				System.out.println(startPoint.toString().equals( eachRow.get(0).toString()));
				System.out.println(startPoint.toString()+" && "+ eachRow.get(0).toString());
				System.out.println("start point = "+startPoint.getId()+" "+startPoint.getStraight_dis()+" "+startPoint.getUnitDis());
				System.out.println("eachRow.get(0) = "+eachRow.get(0).getId()+" "+eachRow.get(0).getStraight_dis()+" "+eachRow.get(0).getUnitDis());
				*/
				//System.out.println("n = "+n.getId()+" "+n.getStraight_dis()+" "+n.getUnitDis());
				//System.out.println("eachRow.get(0) = "+eachRow.get(0).getId()+" "+eachRow.get(0).getStraight_dis()+" "+eachRow.get(0).getUnitDis());
				for(Node eachNode : eachRow){
					if(!visited.contains(eachNode) && !queue.contains(eachNode)){ 	//you have to override contains method, or it will compare address instead of value
						queue.add(eachNode);
						eachNode.copyPath(n);
						//eachNode.addStep(eachNode);//add step after find children
						eachNode.setPathLength(n.getPathLength());
						//System.out.println(eachNode.getId()+"--"/*+eachNode.getStraight_dis()*/);
					}
				}
			}//
		}
		
		return result;
//		if(eachRow.contains(endPoint)){//problem
//			path.add(endPoint.getId());
//			//System.out.println(endPoint.getId());
//			return path;
//		}
//		else{
//			for(int i = 0; i < eachRow.size(); i++){		
//				
//				if(!path.contains(eachRow.get(i).getId())){
//					startPoint = eachRow.get(i);
//					//return bfs(startPoint, endPoint, c);
//				}
//			}
//		}
//		return bfs(startPoint, endPoint, c);
	}

}
