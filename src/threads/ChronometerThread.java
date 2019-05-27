package threads;

import model.Chronometer;

public class ChronometerThread extends Thread{
	private Chronometer c;
	public ChronometerThread(Chronometer c) {
		this.c=c;
	}
	@Override 
	public void run() {
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 60; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					if(j<10)
						c.changeTime(i+":0"+j+":"+j2);
					else
						c.changeTime(i+":"+j+":"+j2);
					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
