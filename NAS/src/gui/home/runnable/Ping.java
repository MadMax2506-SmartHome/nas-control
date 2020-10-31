package gui.home.runnable;

import app.Data;
import gui.home.ControlElements;

public class Ping implements Runnable {
	private boolean run_while;
	
	private Data data;
	private ControlElements controlElements;
	
	public Ping(Data data, ControlElements controlElements) { 
		this.data = data;
		this.controlElements = controlElements;
		
		run_while = true;
	}

	public void stop() {
		run_while = false;
	}
	
	private void choose_status(boolean result) {
		if(result) {
			controlElements.set_status(controlElements.ONLINE);
		} else {
			controlElements.set_status(controlElements.OFFLINE);
		}
	}
	
	@Override
	public void run() {
		boolean result_new = false;
		boolean result_old = false;
		
		// Endlosschleife
		while(run_while) {
			if(data.are_settings_empty()) {
				continue;
			}
			
			result_old = result_new;
			result_new = data.get_network_device().ping();
			
			// Prüfen, ob neuer Status gleich dem alten Status ist
			if(result_new != result_old) {
				// neuer Status ist ungleich dem alten Status
				
				choose_status(result_new);
			}
			
			try {
				Thread.sleep(data.get_ping_timeout());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
