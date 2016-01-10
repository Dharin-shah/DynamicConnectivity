package implementation;

import implementation.Timer.TimerSingle;
import interfaces.DynamicConnect;
public class QuickFind implements DynamicConnect{
	private static Timer timer = TimerSingle.getInstance();
	private int[] id;
//	private int size;
	public QuickFind(int N){
		//size = N;
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
	}

	@Override
	public boolean connected(int p, int q) {
		timer.init();
		boolean result = id[p] == id[q];
		timer.elapsedTime();
		return result;
	}

	@Override
	public void union(int p, int q) {
		timer.init();
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid) id[i] = qid;
		timer.elapsedTime();
	}
}
