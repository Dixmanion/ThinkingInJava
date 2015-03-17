package cn.edu.nju.shared;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MuteEvenGenerator extends IntGenerator {
	
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();

	ArrayList<String> list;
	@Override
	public int next() {
		lock.lock();
		try {
			++ currentEvenValue;
			Thread.yield();
			++ currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenChecker.test(new MuteEvenGenerator());
	}
}
