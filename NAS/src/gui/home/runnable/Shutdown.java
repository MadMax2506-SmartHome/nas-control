package gui.home.runnable;

import javax.swing.JOptionPane;

import app.Data;
import gui.GUI;

public class Shutdown implements Runnable {

	private Data data;
	private GUI gui;
	
	public Shutdown(Data data, GUI gui) { 
		this.data = data;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		try {
			Runtime runtime = Runtime.getRuntime();
			boolean successful_shutdown = false;
			
			if(data.is_windows()) {
				Process process_connect = runtime.exec("net use \\\\" + data.get_ip_address() + " /user:" + data.get_username() + " " + data.get_password());
				int return_val_connect = process_connect.waitFor();
							
				Process process_shutdown = runtime.exec("shutdown /s /t 0 /m " + data.get_ip_address());
				int return_val_shutdown = process_shutdown.waitFor();
	
				successful_shutdown = return_val_shutdown == 0 && return_val_connect == 0;
	
			} else {
				Process process = runtime.exec("net rpc shutdown -I " + data.get_ip_address() + " -U " + data.get_username() + "%" + data.get_password());
				int return_val = process.waitFor();
				
				successful_shutdown = return_val == 0;
			}
			
			if(successful_shutdown) {
				JOptionPane.showMessageDialog(gui, "Das NAS wurde erfolgreich heruntergefahren.", "Offline", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(gui, "Beim herunterfahren ist etwas schiefgelaufen.\nBitte stellen Sie sicher, dass Sie Administratorenrechte haben.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
