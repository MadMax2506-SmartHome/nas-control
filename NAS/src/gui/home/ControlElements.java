package gui.home;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlElements {
	
	public final String WOL = "wol";
	public final String SHUTDOWN = "shutdown";
	public final String ONLINE = "online";
	public final String OFFLINE = "offline";
	
	private String host;
	private String status;
	
	private JPanel panelStatus;
	private JLabel lblStatus;
	
	public ControlElements(JPanel panelStatus, JLabel lblStatus) {
		this.panelStatus 	= panelStatus;
		this.lblStatus		= lblStatus;
	}
	
	public void set_status(String status) {
		this.status = status;
		show_status();
	}
	
	public void set_status(String host, String status) {
		this.status = status;
		this.host = host;
		show_status();
	}
	
	public String get_status() {
		return status;
	}
	
	private void show_status() {
		switch (status) {
			case WOL:
				lblStatus.setText("Das NAS wird geweckt...");
				lblStatus.setForeground(Color.BLACK);
				panelStatus.setBackground(new Color(132, 255, 132));
				break;
				
			case SHUTDOWN:
				lblStatus.setText("Das NAS wird heruntergefahren...");
				lblStatus.setForeground(Color.BLACK);
				panelStatus.setBackground(new Color(255, 132, 132));
				break;
			
			case ONLINE:
				lblStatus.setText(host +  " ist online");
				lblStatus.setForeground(Color.BLACK);
				panelStatus.setBackground(Color.GREEN);
				break;
				
			case OFFLINE:
				lblStatus.setText(host +  " ist offline");
				lblStatus.setForeground(Color.WHITE);
				panelStatus.setBackground(Color.RED);
				break;
		}
	}
}
