package app;


import java.awt.EventQueue;

import gui.GUI;

public class Main {
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
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
