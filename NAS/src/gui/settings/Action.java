package gui.settings;

import app.Data;

public class Action {
	
	private Data data;
	private gui.ControlElements main_controlElements;
	private ControlElements controlElements;
	
	public Action(Data data, gui.ControlElements main_controlElements, ControlElements controlElements) {
		this.data = data;
		this.main_controlElements = main_controlElements;
		this.controlElements = controlElements;
		
		set_values();
	}
	
	public void save() {
		
	}
	
	public void abort() {
		main_controlElements.set_card(main_controlElements.HOME_CARD);
		set_values();
	}
	
	private void set_values() {
		controlElements.set_username(data.get_username());
		controlElements.set_password(data.get_password());
		controlElements.set_ip_address(data.get_ip_address());
		controlElements.set_mac_address(data.get_mac_address());
		controlElements.set_ping_timeout(data.get_ping_timeout());
	}
}
