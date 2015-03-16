package cn.edu.nju;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this + " creating new Thread");
		Thread thread = new Thread(r);
		System.out.println("Created " + thread);
		thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh = " + thread.getUncaughtExceptionHandler());
		return thread;
	}

}
