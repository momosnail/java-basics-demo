package w_07;

public class SetThread extends Thread {
	private Student s;
	private int x = 0;

	public SetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
		
				// 有数据就等待

				if (x % 2 == 0) {
					s.set("唐僧", 500);
				} else {
					s.set("女儿", 28);
				}
				x++;

			
		}
	}
}
