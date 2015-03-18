package cn.edu.nju.shared;

public class Waiter implements Runnable {
	private Restaurant r;
	
	public Waiter(Restaurant r) {
		this.r = r;
	}

	@Override
	public void run() {
//		while (!Thread.interrupted()) {
//			try {
//				synchronized (this) {
//					while (r.meal == null) {
//						wait();
//					}
//				}
//				System.out.println("Waiter took " + r.meal);
//				synchronized (r.chef) {
//					r.meal = null;
//					r.chef.notifyAll();
//				}
//			} catch (InterruptedException e) {
//				System.out.println("Waiter interrupted!");
//			}
//		}
//		System.out.println("Exit waiter while");

		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (r.meal == null) {
						wait();
					}
				}
				System.out.println("Waiter took " + r.meal);
				synchronized (r.chef) {
					r.meal = null;
					r.chef.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Waiter interrupted!");
		}

		System.out.println("Exit waiter while");
	}

}
