package implementation;

import implementation.Timer.TimerSingle;
import interfaces.DynamicConnect;

public class QuickUnion implements DynamicConnect {
	private static Timer timer = TimerSingle.getInstance();
	private int id[];
	
	public QuickUnion(int N){
		id = new int[N];
		for(int i = 0; i < N;i++) id[i] = i;
	}
	
	private int root(int p){
		if (id[p] == p)
			return p;
		return root(id[p]);
	}
	
	@Override
	public boolean connected(int p, int q) {
		timer.init();
		boolean temp = (root(p) == root(q));
		timer.elapsedTime();
		return temp;
	}

	@Override
	public void union(int p, int q) {
		timer.init();
		int i = root(p);
		int j = root(q);
		id[i] = j;
		timer.elapsedTime();
	}

}
