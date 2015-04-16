package org.jiangfei.util;

import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainFrame extends JFrame {

	private JTextArea ta1 = new JTextArea();
	private JTextArea ta2 = new JTextArea();
	private MainFrame _mainFrame;
	public MainFrame(){
		_mainFrame = this;
		setLayout(null);
		add(ta1);
		add(ta2);
		
		Font f = ta1.getFont().deriveFont(16f);
		ta1.setFont(f);
		ta2.setFont(f);
		
		addComponentListener(new ComponentListener() {
			
			public void componentShown(ComponentEvent arg0) {
			}
			
			public void componentResized(ComponentEvent arg0) {
				ta1.setBounds(5, 5, _mainFrame.getWidth()/2-10, _mainFrame.getHeight()-60);
				ta2.setBounds(_mainFrame.getWidth()/2+10, 5, _mainFrame.getWidth()/2-40, _mainFrame.getHeight()-60);
			}
			
			public void componentMoved(ComponentEvent arg0) {
				
			}
			
			public void componentHidden(ComponentEvent arg0) {
				StringBuffer sb = new StringBuffer();
				sb.append("abcdef \n");

			}
		});
		
		ta1.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent arg0) {
				changedUpdate(null);
			}
			
			public void insertUpdate(DocumentEvent arg0) {
				changedUpdate(null);
			}
			
			public void changedUpdate(DocumentEvent arg0) {
				String text1 = ta1.getText();
				String[] arr = text1.split("\n");
				StringBuffer sb = new StringBuffer();
				sb.append("StringBuffer sb = new StringBuffer();\n");
				for(int i=0;i<arr.length;i++){
					String line = arr[i];
					line = line.replace("\"", "\\\"");
					line = line.replace("\\", "\\\\");
					line = line.replace("\t", "    ");
					String new_line = "sb.append(\"" + line + " \\n\");\n";
					sb.append(new_line);
				}
				String text2 = sb.toString();
				ta2.setText(text2);
			}
		});
	}

}
