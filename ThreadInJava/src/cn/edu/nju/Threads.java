package cn.edu.nju;

public class Threads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			new Thread(new ListOff()).start();
		}
		System.out.println("Waiting for ift off!");
	}

}
