package app;


import java.awt.EventQueue;

import gui.GUI;

public class App {
	public static void main(String[] args) {
		new App();
	}
	
	public App() {
		Data data = new Data();
		EventQueue.invokeLater(() -> run_app(data));
	}
	
	private void run_app(Data data) {
		try {
			GUI frame = new GUI(data);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
