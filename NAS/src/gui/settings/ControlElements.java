package gui.settings;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControlElements {
	
	private JTextField txtUsername;
	private JPasswordField pwdUser;
	private JTextField txtIpAddress;
	private JTextField txtMacAddress;
	private JTextField txtPingTimeout;
	
	public ControlElements(JTextField txtUsername, JPasswordField pwdUser, JTextField txtIpAddress, JTextField txtMacAddress, JTextField txtPingTimeout) {
		this.txtUsername = txtUsername;
		this.pwdUser = pwdUser;
		this.txtIpAddress = txtIpAddress;
		this.txtMacAddress = txtMacAddress;
		this.txtPingTimeout = txtPingTimeout;
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
	public void set_ping_timeout(int ping_timeout) {
		txtPingTimeout.setText(String.valueOf(ping_timeout));
	}
	
	public String get_username() {
		return txtUsername.getText();
	}
	public String get_password() {
		return pwdUser.getPassword().toString();
	}
	public String get_ip_address() {
		return txtIpAddress.getText();
	}
	public String get_mac_address() {
		return txtMacAddress.getText();
	}
	public int get_ping_timeout() {
		return Integer.parseInt(txtPingTimeout.getText());
	}
}
