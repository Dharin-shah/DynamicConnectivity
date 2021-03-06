package implementation;

import implementation.Timer.TimerSingle;
import interfaces.DynamicConnect;

public class WeightedQuickUnion implements DynamicConnect {
	private static Timer timer = TimerSingle.getInstance();
	private int id[];
	private int sz[];
	public WeightedQuickUnion(int N){
		id = new int[N];
		for(int i = 0; i < N; i++){ 
			id[i] = i;
			sz[i] = 1;
			}
	}
	
	private int root(int p){
		timer.init();
		while(p != id[p]){
			id[p] = id[id[p]]; //path compression - add to its tree's root
			p = id[p];
		}
		timer.elapsedTime();
		return p;
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
		if(sz[i] < sz[j]) {id[i] = j; sz[j] += sz[i];}
		else {id[j] = i; sz[i] += sz[j];}
		timer.elapsedTime();
	}

}
