package gui.home;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlElements {
	
	private String status;
	
	private JPanel panelStatus;
	private JLabel lblStatus;
	
	public ControlElements(JPanel panelStatus, JLabel lblStatus) {
		this.panelStatus 	= panelStatus;
		this.lblStatus		= lblStatus;
		
		set_status("offline");
	}
	
	public void set_status(String status) {
		this.status = status;
		show_status();
	}
	
	private void show_status() {
		switch (status) {
			case "wol":
				lblStatus.setText("Das NAS wird hochgefahren...");
				lblStatus.setForeground(Color.BLACK);
				panelStatus.setBackground(new Color(132, 255, 132));
				break;
				
			case "shutdown":
				lblStatus.setText("Das NAS wird heruntergefahren...");
				lblStatus.setForeground(Color.BLACK);
				panelStatus.setBackground(new Color(255, 132, 132));
				break;
			
			case "online":
				lblStatus.setText("Das NAS ist online");
				lblStatus.setForeground(Color.BLACK);
				panelStatus.setBackground(Color.GREEN);
				break;
				
			case "offline":
				lblStatus.setText("Das NAS ist offline");
				lblStatus.setForeground(Color.WHITE);
				panelStatus.setBackground(Color.RED);
				break;
		}
	}
}
