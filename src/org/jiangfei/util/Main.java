package org.jiangfei.util;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setBounds(300, 200, 1000, 600);
	}

}
