package gui.home.runnable;

import javax.swing.JOptionPane;

import app.Data;
import gui.GUI;

public class WOL implements Runnable {

	private Data data;
	private GUI gui;
	
	public WOL(Data data, GUI gui) { 
		this.data = data;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		JOptionPane.showMessageDialog(gui, "Das NAS wurde erfolgreich hochgefahren.", "Online", JOptionPane.INFORMATION_MESSAGE);
		data.get_network_device().wol();
	}
}
