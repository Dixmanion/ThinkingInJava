package cn.edu.nju.shared;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
	
	public Meal meal;//厨师和服务员公用
	public Waiter waiter;
	public Chef chef;
	ExecutorService executorService = Executors.newCachedThreadPool();
	
	public Restaurant(){
		waiter = new Waiter(this);
		chef = new Chef(this);
		
		executorService.execute(chef);
		executorService.execute(waiter);
		
	}
	
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
	}

}
