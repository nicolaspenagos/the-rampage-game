package threads;
import userinterface.Helicopters;
import userinterface.gameController;

public class ScenaryAnimationsThread extends Thread{
	private Helicopters helicopter1;
	private gameController gameController;
	
	public ScenaryAnimationsThread(gameController gc, Helicopters h) {
		helicopter1 = h;
		gameController = gc;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				helicopter1.move();
				sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}

}
