package gui.home;

import javax.swing.JOptionPane;

import app.Data;
import gui.GUI;
import gui.home.runnable.Shutdown;
import gui.home.runnable.WOL;

public class Action {
	private WOL wol;
	private Shutdown shutdown;
	
	private Data data;
	private GUI gui;
	
	public Action(Data data, GUI gui) {	
		this.data = data;
		this.gui = gui;
		
		refresh();
	}

	public void refresh() {
		wol = new WOL(data, gui);
		shutdown = new Shutdown(data, gui);
	}
	
	public void wake_on_lan() {
		if(data.get_network_device().ping()) {
			JOptionPane.showMessageDialog(gui, "Das NAS wurde bereits hochgefahren.", "Online", JOptionPane.INFORMATION_MESSAGE);
		} else {
			new Thread(wol).start();
		}
	}
	
	public void shutdown() {
		if(!data.get_network_device().ping()) {
			JOptionPane.showMessageDialog(gui, "Das NAS ist bereits heruntergefahren.", "Offline", JOptionPane.INFORMATION_MESSAGE);
		} else {
			new Thread(shutdown).start();
		}
	}
}
