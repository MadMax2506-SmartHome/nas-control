package gui;

import java.awt.CardLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
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
		setBounds(data.get_x(), data.get_y(), 350, 300);
		setResizable(false);
		setIconImage(new ImageIcon(data.get_icon_file().toString()).getImage());
		
		set_look_and_feel();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAction = new JMenu("Menü");
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
		
		addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {
				actions.exit();
			}
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	}
	
	private void set_look_and_feel() {		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e2) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e3) {
					try {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					} catch (Exception e4) {}
				}
			}
		}
	}
}
