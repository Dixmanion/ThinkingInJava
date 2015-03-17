package cn.edu.nju.shared;

public class PairManipulator implements Runnable {

	private PairManager p;
	
	public PairManipulator(PairManager p) {
		this.p = p;
	}
	@Override
	public void run() {
		while (true) {
			p.increment();
		}
	}
	
	public String toString() {
		return "Pair:";
	}

}
