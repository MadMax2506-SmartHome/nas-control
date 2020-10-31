package gui.settings;

import app.Data;

public class Action {
	
	private Data data;
	private gui.Action main_actions;
	private ControlElements controlElements;
	
	public Action(Data data, gui.Action main_actions, ControlElements controlElements) {
		this.data = data;
		this.main_actions = main_actions;
		this.controlElements = controlElements;
		
		set_values();
	}
	
	public void save() {
		data.write_settings( controlElements.get_username(),
							controlElements.get_password(),
							controlElements.get_ip_address(),
							controlElements.get_mac_address(),
							controlElements.get_ping_timeout());
		main_actions.set_home_card();
	}
	
	public void abort() {
		main_actions.set_home_card();
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
