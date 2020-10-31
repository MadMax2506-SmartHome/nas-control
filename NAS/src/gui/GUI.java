package gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import app.Data;
import gui.home.HomePanel;
import gui.settings.SettingsPanel;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel homePanel;
	private JPanel settingsPanel;
	
	private JMenuBar menuBar;
	private JMenu mnAction;
	private JMenuItem mntmOverview;
	private JMenuItem mntmEinstellungen;
	
	public GUI(Data data) {
		setTitle("NAS - Steuerung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 400);
		setResizable(false);
		
		set_look_and_feel();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAction = new JMenu("Aktion");
		menuBar.add(mnAction);
		
		mntmOverview = new JMenuItem("Übersicht");
		mnAction.add(mntmOverview);
		mnAction.addSeparator();
		
		mntmEinstellungen = new JMenuItem("Einstellungen");
		mnAction.add(mntmEinstellungen);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		ControlElements controlElements = new ControlElements(this, contentPane);
		Action actions = new Action(data, controlElements);
		
		homePanel = new HomePanel(data);
		contentPane.add(homePanel, controlElements.HOME_CARD);
		
		settingsPanel = new SettingsPanel(data, actions);
		contentPane.add(settingsPanel, controlElements.SETTINGS_CARD);
		
		mntmOverview.addActionListener((e) -> actions.set_home_card());
		mntmEinstellungen.addActionListener((e) -> actions.set_settings_card());
		
		if(data.are_settings_empty()) {
			actions.set_settings_card();
		} else {
			actions.set_home_card();
		}
	}
	
	private void set_look_and_feel() {
		String os = System.getProperty("os.name");
		
		try {
			switch (os) {
				case "Linux": UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); break;
				case "Windows": UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); break;
				default: UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
