package BT;

public class test {
	public static void main(String[] args) {
		BFS B = new BFS(4,3,2);
		System.out.println("============================#BFS#=============================");
		B.BFS_WTJ();;
		System.out.println("==============================================================");
		DFS D = new DFS(4,3,2);
		System.out.println("============================#DFS#=============================");
		D.DFS_WTJ();
	}
}
