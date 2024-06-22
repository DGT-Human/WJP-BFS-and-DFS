package BT;

import java.util.List;
import java.util.ArrayList;

public class Path<T> {
    private List<T> L;
    
    public Path(){
        L = new ArrayList<>();
    }
    
    public void addVertex(T vertex) {
        L.add(vertex);
    }
    
    public List<T> getPath(){
        return L;
    }
    
    public void setPath(List<T> path){
        this.L.addAll(path);
    }

    public void printPath(){
        for (int i = L.size()-1; i >= 0; i--){
            System.out.print(L.get(i).toString() + " ");
        }
        
        System.out.println();
    }    
}
