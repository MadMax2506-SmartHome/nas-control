package gui;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ControlElements {

	public final String HOME_CARD = "Home";
	public final String SETTINGS_CARD = "Settings";
	
	private JPanel contentPane;
	
	public ControlElements(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public void set_card(String name) {
		CardLayout layout = (CardLayout) contentPane.getLayout();
		layout.show(contentPane, name);
	}
}
