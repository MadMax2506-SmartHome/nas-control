package gui.home.runnable;

import app.Data;
import gui.home.ControlElements;

public class Shutdown implements Runnable {

	private Data data;
	private ControlElements controlElements;
	
	public Shutdown(Data data, ControlElements controlElements) { 
		this.data = data;
		this.controlElements = controlElements;
	}
	
	@Override
	public void run() {
		if(controlElements.get_status() == controlElements.ONLINE) {
			//controlElements.set_status(controlElements.SHUTDOWN);
			//data.get_network_device().shutdown();
		}
	}
}
