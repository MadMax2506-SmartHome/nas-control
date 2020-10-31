package gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.App;

public class ControlElements {

	public final String HOME_CARD = "Home";
	public final String SETTINGS_CARD = "Settings";
	
	private JFrame gui;
	private JPanel contentPane;
	
	public ControlElements(JFrame gui, JPanel contentPane) {
		this.gui = gui;
		this.contentPane = contentPane;
	}
	
	public JFrame get_gui_component() {
		return gui;
	}
	
	public int get_x() {
		return gui.getX();
	}
	
	public int get_y() {
		return gui.getY();
	}
	
	public void set_card(String name) {
		CardLayout layout = (CardLayout) contentPane.getLayout();
		layout.show(contentPane, name);
	}

	public void restart() {
		gui.setVisible(false);
		gui.dispose();
		
		new App();
	}
}
