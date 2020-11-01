package gui.home;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Data;

public class HomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public HomePanel(Data data) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel head = new JPanel();
		add(head, BorderLayout.NORTH);
		
		JLabel lblStatus = new JLabel("----");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		head.add(lblStatus);
		
		JPanel main = new JPanel();
		GridBagLayout gbl_main = new GridBagLayout();
		gbl_main.columnWeights = new double[]{0.0, 1.0};
		main.setLayout(gbl_main);
		add(main, BorderLayout.CENTER);
		
		JButton btnWOL = new JButton(" Aufwecken");
		btnWOL.setIcon((new ImageIcon(data.get_wol_icon_file().toString())));
		GridBagConstraints gbc_btnWOL = new GridBagConstraints();
		gbc_btnWOL.insets = new Insets(30, 5, 5, 0);
		gbc_btnWOL.ipadx = 10;
		gbc_btnWOL.ipady = 10;
		gbc_btnWOL.gridx = 0;
		gbc_btnWOL.gridy = 0;
		main.add(btnWOL, gbc_btnWOL);
		
		JButton btnShutdown = new JButton(" Herunterfahren");
		btnShutdown.setIcon((new ImageIcon(data.get_shutdown_icon_file().toString())));
		GridBagConstraints gbc_btnShutdown = new GridBagConstraints();
		gbc_btnShutdown.insets = new Insets(5, 5, 0, 0);
		gbc_btnShutdown.ipadx = 10;
		gbc_btnShutdown.ipady = 10;
		gbc_btnShutdown.gridx = 0;
		gbc_btnShutdown.gridy = 1;
		main.add(btnShutdown, gbc_btnShutdown);
		
		ControlElements controlElements = new ControlElements(head, lblStatus);
		Action action = new Action(data, controlElements);
		btnWOL.addActionListener((e) -> action.wake_on_lan());
		btnShutdown.addActionListener((e) -> action.shutdown());
	}

}
