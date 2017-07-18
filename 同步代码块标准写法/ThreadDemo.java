package w_07;

public class ThreadDemo {
	public static void main(String[] args) {
		Student s=new Student();
		
		SetThread t1=new SetThread(s);
		GetThread t2=new GetThread(s);
//		Thread th1=new Thread(t1);
//		Thread th2=new Thread(t2);
//		th1.start();
//		th2.start();
		t1.start();
		t2.start();
	}
}
