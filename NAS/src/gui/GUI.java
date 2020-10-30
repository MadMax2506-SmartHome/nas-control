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
	
	private final static String HOME_CARD = "Home";
	private final static String SETTINGS_CARD = "Settings";
	
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
		setBounds(100, 100, 450, 300);
		setResizable(false);
		
		set_look_and_feel();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAction = new JMenu("Aktion");
		menuBar.add(mnAction);
		
		mntmOverview = new JMenuItem("Übersicht");
		mntmOverview.addActionListener((e) -> set_card(HOME_CARD));
		mnAction.add(mntmOverview);
		mnAction.addSeparator();
		
		mntmEinstellungen = new JMenuItem("Einstellungen");
		mntmEinstellungen.addActionListener((e) -> set_card(SETTINGS_CARD));
		mnAction.add(mntmEinstellungen);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		homePanel = new HomePanel(data);
		contentPane.add(homePanel, HOME_CARD);
		
		settingsPanel = new SettingsPanel();
		contentPane.add(settingsPanel, SETTINGS_CARD);
		
		set_card(HOME_CARD);
	}

	
	private void set_card(String name) {
		CardLayout layout = (CardLayout) contentPane.getLayout();
		layout.show(contentPane, name);
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
