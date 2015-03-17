package cn.edu.nju.shared;

public class PairManager2 extends PairManager {

	@Override
	public void increment() {
		// TODO Auto-generated method stub
		Pair temp;
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}

}
