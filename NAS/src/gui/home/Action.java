package gui.home;

import app.Data;
import gui.home.runnable.Ping;
import gui.home.runnable.WOL;

public class Action {
	private Ping ping;
	private WOL wol;
	
	public Action(Data data, ControlElements controlElements) {	
		ping = new Ping(data, controlElements);
		Thread thread = new Thread(ping);
		thread.start();
		
		wol = new WOL(data, controlElements);
	}

	public void wake_on_lan() {
		Thread thread = new Thread(wol);
		thread.start();
	}
	
	public void shutdown() {
		
	}
}
