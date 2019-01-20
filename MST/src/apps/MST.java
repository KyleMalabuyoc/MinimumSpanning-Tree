package apps;

import structures.*;
import java.util.ArrayList;

public class MST {
	
	/**
	 * Initializes the algorithm by building single-vertex partial trees
	 * 
	 * @param graph Graph for which the MST is to be found
	 * @return The initial partial tree list
	 */
	
	public static PartialTreeList initialize(Graph graph) {
		
		PartialTreeList PartTreeL = new PartialTreeList();
		
		PTLTraverse(graph,PartTreeL);
		
		return PartTreeL;
	}
	
	private static void PTLTraverse(Graph graph, PartialTreeList PartTreeL){
		
		PartialTree PartTree;
		PartialTree.Arc e = null;
		
		for(Vertex v: graph.vertices){
			
			PartTree = new PartialTree(v);

			for(Vertex.Neighbor neigh = v.neighbors; neigh != null; neigh = neigh.next){
				
				e = new PartialTree.Arc(v, neigh.vertex, neigh.weight);
				
				PartTree.getArcs().insert(e);
			}
			
			PartTreeL.append(PartTree);
		}
		
	}

	/**
	 * Executes the algorithm on a graph, starting with the initial partial tree list
	 * 
	 * @param ptlist Initial partial tree list
	 * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
	 */

	public static ArrayList<PartialTree.Arc> execute(PartialTreeList ptlist) {
		
		ArrayList<PartialTree.Arc> ans = new ArrayList<PartialTree.Arc>();
		
		ans = executeCall(ans,ptlist);

		return ans;

	}
	
	private static ArrayList<PartialTree.Arc> executeCall(ArrayList<PartialTree.Arc> ans, PartialTreeList ptlist){
		
		PartialTree pt = null, PartTreey = null;
		PartialTree.Arc arcs = null;
		
		while(ptlist.size() > 1){
			
			pt = ptlist.remove();
			arcs = pt.getArcs().getMin();
			
			while(arcs == null || arcs.v2.getRoot() == pt.getRoot()){
				
				pt.getArcs().deleteMin();
				
				arcs = pt.getArcs().getMin();
			}
		
			ans.add(arcs);
			PartTreey = ptlist.removeTreeContaining(arcs.v2);
			
			pt.merge(PartTreey);
			ptlist.append(pt);
		}
		
		return ans;
	}
}
