package gui;

import javax.swing.JOptionPane;

import app.Data;

public class Action {

	private Data data;
	private ControlElements controlElements;
	
	public Action(Data data, ControlElements controlElements) {
		this.data = data;
		this.controlElements = controlElements;
	}

	public void set_home_card() {
		if(data.are_settings_empty()) {
			JOptionPane.showMessageDialog(controlElements.get_gui_component(), "Sie müssen gülltige Einstellungen angeben!", "Fehlerhafte Einstellungen", JOptionPane.ERROR_MESSAGE);
		} else {
			controlElements.set_card(controlElements.HOME_CARD);
		}
	}
	
	public void set_settings_card() {
		controlElements.set_card(controlElements.SETTINGS_CARD);
	}
}
