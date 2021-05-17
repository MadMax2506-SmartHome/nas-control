package gui.settings;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControlElements {
	
	private JTextField txtUsername;
	private JPasswordField pwdUser;
	private JTextField txtIpAddress;
	private JTextField txtMacAddress;
	
	public ControlElements(JTextField txtUsername, JPasswordField pwdUser, JTextField txtIpAddress, JTextField txtMacAddress) {
		this.txtUsername = txtUsername;
		this.pwdUser = pwdUser;
		this.txtIpAddress = txtIpAddress;
		this.txtMacAddress = txtMacAddress;
	}
	
	public void set_username(String username) {
		txtUsername.setText(username);
	}
	public void set_password(String password) {
		pwdUser.setText(password);
	}
	public void set_ip_address(String ip_address) {
		txtIpAddress.setText(ip_address);
	}
	public void set_mac_address(String mac_address) {
		txtMacAddress.setText(mac_address);
	}
	
	public String get_username() {
		return txtUsername.getText();
	}
	public String get_password() {
		return String.valueOf(pwdUser.getPassword());
	}
	public String get_ip_address() {
		return txtIpAddress.getText();
	}
	public String get_mac_address() {
		return txtMacAddress.getText();
	}
}
