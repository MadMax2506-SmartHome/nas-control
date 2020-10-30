package gui.home.runnable;

import app.Data;
import gui.home.ControlElements;

public class WOL implements Runnable {

	private Data data;
	private ControlElements controlElements;
	
	public WOL(Data data, ControlElements controlElements) { 
		this.data = data;
		this.controlElements = controlElements;
	}
	
	@Override
	public void run() {
		if(controlElements.get_status() == controlElements.OFFLINE) {
			controlElements.set_status(controlElements.WOL);
			data.get_network_device().wol();
		}
	}
}
