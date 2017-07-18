package day24;

public class DeadThreadDemo {
	public static void main(String[] args) {
		DeadThread t1=new DeadThread(true);
		DeadThread t2=new DeadThread(false);
		
		t1.start();
		t2.start();
	}
}
