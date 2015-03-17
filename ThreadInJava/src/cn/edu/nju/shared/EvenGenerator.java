package cn.edu.nju.shared;

public class EvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;//临界资源，对该资源的访问方法都必须同步
	@Override
	public synchronized int next() {
		// TODO Auto-generated method stub
		++ currentEvenValue;
		Thread.yield();
		++ currentEvenValue;
		return currentEvenValue;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}

}
