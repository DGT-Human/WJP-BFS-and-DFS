package BT;

public class State {

    private int B1, B2;
    private static int Max_B1 = 0;
    private static int Max_B2 = 0;    
    
    public State(){
        this.B1 = 0;
        this.B2 = 0;        
    }
    
    public State(int b1, int b2){
        this.B1 = b1;
        this.B2 = b2;        
    }
    
    public static void Max_B1_B2(int maxB1, int maxB2){
        Max_B1 = maxB1;
        Max_B2 = maxB2;        
    }
    
    public int getB1(){
        return B1;
    } 
    
    public int getB2(){
        return B2;
    }
    
    public State Max_B1(){
	return new State(Max_B1, B2);
    }
    
    public State Max_B2(){
	return new State(B1, Max_B2);
    }
    
    public State empty_B1(){
	return new State(0, B2);
    }
    
    public State empty_B2(){
	return new State(B1, 0);
    }
    
    public State B1toB2(){
        if ((B1 + B2) >= Max_B2)
            return new State((B1 + B2 - Max_B2), Max_B2);
        else
            return new State(0, (B1 + B2));
    }
    
    public State B2toB1(){
        if ((B1 + B2) >= Max_B1)
            return new State(Max_B1, (B1 + B2 - Max_B1));
        else
            return new State((B1 + B2), 0);
    }
    public boolean equals(Object obj) {
        State s = (State) obj;        
        
	if (!(s instanceof State))
            return false;	

        return ((s.getB1() == this.getB1()) && (s.getB2() == this.getB2()));
    }

    public String toString(){
        return "(" + B1 + "-" + B2 + ")";
    }
}
