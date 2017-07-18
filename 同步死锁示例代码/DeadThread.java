package day24;

public class DeadThread extends Thread {
	
	private boolean flag;
	public DeadThread(boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		if (flag) {
			synchronized (DeadLock.objectA) {
				System.out.println("true---objectA");
				synchronized (DeadLock.objectB) {
					System.out.println("true---objectB");
					
				}
			}
		}else {
			synchronized (DeadLock.objectB) {
				System.out.println("flase---objectB");
				synchronized (DeadLock.objectA) {
					System.out.println("flase---objectA");
					
				}
			}
		}
	}

}
