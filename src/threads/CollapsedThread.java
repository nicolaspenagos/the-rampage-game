package threads;

import model.Stage;
import customsExceptions.GameEndedException;
import userinterface.GameController;

public class CollapsedThread extends Thread{
	private GameController gc;
	private Stage st;
	
	public CollapsedThread(GameController g, Stage s) {
		gc=g;
		st=s;
	}
	
	@Override 
	public void run() {
		try {
		while(true) {
			int id=st.collapsing();
			if(id==1||id==2||id==3||id==4) {
				int cc=1;
				while(cc<=5) {
					gc.collapsing(id, cc);
					sleep(80);
					cc++;
				}
				
			}
			sleep(50);
		}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(GameEndedException e) {
			e.printStackTrace();
		}
	}
	

}
