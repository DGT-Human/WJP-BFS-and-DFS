package BT;

import java.util.*;
        
public class BFS {
	private int MaxB1;
	private int MaxB2;
	private int goal;
	 public static Set<Vertex> visited = new HashSet<Vertex>(){
	        public boolean contains(Object obj) {
	            Vertex vertex = (Vertex) obj;
	        
	            for (Vertex v : this) {
	                if (vertex.equals(v)) {
	                    return true;
	                }
	            }
	        
	            return false;
	        }
	    };
	public BFS(int maxB1, int maxB2, int goal) {
    	this.MaxB1 = maxB1;
    	this.MaxB2 = maxB2;
    	this.goal = goal;
    }

	public int getMaxB1() {
		return MaxB1;
	}

	public void setMaxB1(int maxB1) {
		MaxB1 = maxB1;
	}

	public int getMaxB2() {
		return MaxB2;
	}

	public void setMaxB2(int maxB2) {
		MaxB2 = maxB2;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	public void BFS_WTJ() {
		//Set<Vertex> visited = new HashSet<Vertex>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		ArrayList<Vertex> closed = new ArrayList<Vertex>();
        Vertex.Max_B1_B2(getMaxB1(), getMaxB2());
        Vertex s = new Vertex(new State());
        queue.add(s);      
        visited.add(s);
        System.out.println("Open: ");
		System.out.println(queue);
		System.out.println("Closed: ");
		System.out.println(closed);
		System.out.println("=============================");
	while(!queue.isEmpty()){
            Vertex cur = queue.poll();       
            closed.add(cur);
            if(cur.getState().getB1() == getGoal() || cur.getState().getB2() == getGoal()){
				System.out.println("Result: ");
            	
              	cur.tracePath().printPath();                                                   
                 continue;
            }            
            
            ArrayList<Vertex> newVertices = new ArrayList<Vertex>();
            
            newVertices.add(cur.Max_B1());
            newVertices.add(cur.Max_B2());
            newVertices.add(cur.empty_B1()); 
            newVertices.add(cur.empty_B2());                        
            newVertices.add(cur.B1toB2());
            newVertices.add(cur.B2toB1());
            
            for (Vertex newVertex : newVertices){                                                                
                if(!cur.tracePath().getPath().contains(newVertex)){
                    newVertex.setParent(cur);
                    
                    if (!visited.contains(newVertex)){
                        queue.add(newVertex);    
                        visited.add(newVertex);                         
                    }
                }                                             
            }   
			System.out.println("Open: ");
			System.out.println(queue);
			System.out.println("Closed: ");
			System.out.println(closed);
			System.out.println("=============================");
            
	}
    }        
}
