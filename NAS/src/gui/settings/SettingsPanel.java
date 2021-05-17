package gui.settings;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import app.Data;

import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class SettingsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtUsername;
	private JPasswordField pwdUser;
	private JTextField txtIpAddress;
	private JTextField txtMacAddress;
	private JTextField txtPingTimeout;

	public SettingsPanel(Data data, gui.Action main_actions) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel main = new JPanel();
		GridBagLayout gbl_main = new GridBagLayout();
		gbl_main.columnWeights = new double[]{0.0, 1.0};
		main.setLayout(gbl_main);
		
		JScrollPane main_sp = new JScrollPane(main, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(main_sp, BorderLayout.CENTER);
		
		JLabel lblUsername = new JLabel("Benutzername");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 10, 10, 5);
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		main.add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.ipady = 5;
		gbc_txtUsername.ipadx = 5;
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 5, 10, 10);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 0;
		main.add(txtUsername, gbc_txtUsername);
		
		JLabel lblPasswort = new JLabel("Passwort");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.WEST;
		gbc_lblPasswort.insets = new Insets(0, 10, 10, 5);
		gbc_lblPasswort.gridx = 0;
		gbc_lblPasswort.gridy = 1;
		main.add(lblPasswort, gbc_lblPasswort);
		
		pwdUser = new JPasswordField();
		pwdUser.setColumns(10);
		GridBagConstraints gbc_pwdUser = new GridBagConstraints();
		gbc_pwdUser.ipady = 5;
		gbc_pwdUser.ipadx = 5;
		gbc_pwdUser.insets = new Insets(0, 5, 10, 10);
		gbc_pwdUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdUser.gridx = 1;
		gbc_pwdUser.gridy = 1;
		main.add(pwdUser, gbc_pwdUser);
		
		JLabel lblIpAddress = new JLabel("IP-Adresse");
		GridBagConstraints gbc_lblIpAddress = new GridBagConstraints();
		gbc_lblIpAddress.anchor = GridBagConstraints.WEST;
		gbc_lblIpAddress.insets = new Insets(0, 10, 10, 5);
		gbc_lblIpAddress.gridx = 0;
		gbc_lblIpAddress.gridy = 2;
		main.add(lblIpAddress, gbc_lblIpAddress);
		
		txtIpAddress = new JTextField();
		txtIpAddress.setColumns(10);
		GridBagConstraints gbc_txtIpAddress = new GridBagConstraints();
		gbc_txtIpAddress.ipady = 5;
		gbc_txtIpAddress.ipadx = 5;
		gbc_txtIpAddress.insets = new Insets(0, 5, 10, 10);
		gbc_txtIpAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIpAddress.gridx = 1;
		gbc_txtIpAddress.gridy = 2;
		main.add(txtIpAddress, gbc_txtIpAddress);
		
		JLabel lblMacAddress = new JLabel("Mac-Adresse");
		GridBagConstraints gbc_lblMacAddress = new GridBagConstraints();
		gbc_lblMacAddress.anchor = GridBagConstraints.WEST;
		gbc_lblMacAddress.insets = new Insets(0, 10, 10, 5);
		gbc_lblMacAddress.gridx = 0;
		gbc_lblMacAddress.gridy = 3;
		main.add(lblMacAddress, gbc_lblMacAddress);
		
		txtMacAddress = new JTextField();
		GridBagConstraints gbc_txtMacAddress = new GridBagConstraints();
		gbc_txtMacAddress.ipadx = 5;
		gbc_txtMacAddress.ipady = 5;
		gbc_txtMacAddress.insets = new Insets(0, 5, 10, 10);
		gbc_txtMacAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMacAddress.gridx = 1;
		gbc_txtMacAddress.gridy = 3;
		main.add(txtMacAddress, gbc_txtMacAddress);
		
		JPanel foot = new JPanel();
		FlowLayout flowLayout = (FlowLayout) foot.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(foot, BorderLayout.SOUTH);
		
		JButton btnAbort = new JButton("Abbrechen");
		foot.add(btnAbort);
		
		JButton btnSave = new JButton("Speichern");
		foot.add(btnSave);
		
		ControlElements controlElements = new ControlElements(txtUsername, pwdUser, txtIpAddress, txtMacAddress);
		Action actions = new Action(data, main_actions, controlElements);
		
		btnAbort.addActionListener((e) -> actions.abort());
		btnSave.addActionListener((e) -> actions.save());
	}

}
