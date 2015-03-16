package cn.edu.nju.shared;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
	
	private IntGenerator geneator;
	private final int id;
	
	public EvenChecker(IntGenerator generator, int ident) {
		this.geneator = generator;
		this.id = ident;
	}

	@Override
	public void run() {
		while (!geneator.isCanceled()) {
			int val = geneator.next();
			if (val % 2 == 0) {
				System.out.println(val + " is not even!");
				geneator.cancel();
			}
		}

	}
	
	public static void test(IntGenerator gp, int count) {
		System.out.println("Press control-C to exit");
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			executorService.execute(new EvenChecker(gp, count));
		}
		executorService.shutdown();
	}
	
	public static void test(IntGenerator gp) {
		test(gp, 10);
	}

}
