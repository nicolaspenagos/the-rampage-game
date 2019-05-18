package threads;
import userinterface.Helicopters;
import userinterface.GameController;

public class ScenaryAnimationsThread extends Thread{
	private Helicopters helicopter1;
	private GameController GameController;
	
	public ScenaryAnimationsThread(GameController gc, Helicopters h) {
		helicopter1 = h;
		GameController = gc;
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
