package gui.home;

import app.Data;
import gui.home.runnable.Ping;
import gui.home.runnable.Shutdown;
import gui.home.runnable.WOL;

public class Action {
	private Ping ping;
	private WOL wol;
	private Shutdown shutdown;
	
	public Action(Data data, ControlElements controlElements) {	
		ping = new Ping(data, controlElements);
		new Thread(ping).start();
		
		wol = new WOL(data, controlElements);
		shutdown = new Shutdown(data, controlElements);
	}

	public void wake_on_lan() {
		new Thread(wol).start();
	}
	
	public void shutdown() {
		new Thread(shutdown).start();
	}
}
