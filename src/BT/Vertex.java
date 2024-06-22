package BT;

public class Vertex {
    private State state;
    private Vertex parent;
    
    public Vertex(){
        this.state = new State();
        this.parent = null;
    }
    
    public Vertex(State state){
        this.state = state;        
        this.parent = null;
    }
    
    public static void Max_B1_B2(int maxB1, int maxB2){
        State.Max_B1_B2(maxB1, maxB2);
    }
    
    public State getState(){
        return state;
    }        
    
    public Vertex Max_B1(){
	return new Vertex(state.Max_B1());
    }
    
    public Vertex Max_B2(){
	return new Vertex (state.Max_B2());
    }
    
    public Vertex empty_B1(){
	return new Vertex(state.empty_B1());
    }
    
    public Vertex empty_B2(){
	return new Vertex(state.empty_B2());
    }
    
    public Vertex B1toB2(){
        return new Vertex(state.B1toB2());
    }
    
    public Vertex B2toB1(){
        return new Vertex(state.B2toB1());
    }        
    
    public Path<Vertex> tracePath(){
        Path<Vertex> L = new Path<Vertex>();
        Vertex v = new Vertex();
        
        v = this;
        
        while (v != null){
            L.addVertex(v);
            v = v.getParent();
        }
        
        return L;
    }
    
    public void setParent(Vertex vertex){
        this.parent = vertex;
    }    
    
    public Vertex getParent(){
        return parent;
    }
    public boolean equals(Object obj) {
        Vertex v = (Vertex) obj;        
        
	if (!(v instanceof Vertex))
            return false;	
        
        return (this.state.equals(v.getState()));
    }        
    public String toString(){
        return state.toString();
    }
}
