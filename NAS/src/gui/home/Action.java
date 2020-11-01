package gui.home;

import app.Data;
import gui.home.runnable.Ping;
import gui.home.runnable.Shutdown;
import gui.home.runnable.WOL;

public class Action {
	private Ping ping;
	private WOL wol;
	private Shutdown shutdown;
	
	private Data data; 
	private ControlElements controlElements;
	
	public Action(Data data, ControlElements controlElements) {	
		this.data = data;
		this.controlElements = controlElements;
		
		refresh();
	}

	public void refresh() {
		controlElements.set_status(data.get_ip_address(), controlElements.OFFLINE);
		if(ping != null) {
			ping.stop();
		}
		
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
