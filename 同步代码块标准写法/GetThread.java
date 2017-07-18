package w_07;

public class GetThread extends Thread {
	private Student s;

	public GetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			
				s.get();
				
			}
		}
	}

