package cn.edu.nju;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableDemo {

	class TaskWithResult implements Callable<String>{
		private int id;
		
		public TaskWithResult(int id) {
			this.id = id;
		}
		@Override
		public String call() throws Exception {
			return "Result of TaskWithResult " + id;
		}
		
	}
	public static void main(String[] args) {
		CallableDemo demo = new CallableDemo();
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> result = new ArrayList<Future<String>>();
		
		for (int i = 0; i < 10; i++) {
			result.add(executorService.submit(demo.new TaskWithResult(i)));
		}
		for (Future<String> fs : result) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
				return;
			}finally {
				executorService.shutdown();
			}
		}

	}

}
