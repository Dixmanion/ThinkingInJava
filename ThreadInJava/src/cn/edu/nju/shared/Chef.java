package cn.edu.nju.shared;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
	
	private Restaurant r;
	private int count = 0;
	public Chef(Restaurant r) {
		this.r = r;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				
				synchronized (this) {
					while (r.meal != null) {
						wait();
					}
				}
				
				
				
				System.out.println("Order up!" + count);
				
				synchronized (r.waiter) {
					Meal meal = new Meal(count);
					r.meal = meal;
					r.waiter.notifyAll();
				}
				
				if (count++ == 10) {
					System.out.println("Out of food");
					r.executorService.shutdownNow();
				}
				TimeUnit.MILLISECONDS.sleep(100);
				
				
			}
			System.out.println("Exit from chef while");
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted!");
		}
	}

}
