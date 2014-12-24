package views;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Controller;
import models.Model;
import models.Observer;

public class View extends JFrame implements Observer {

	Model m;
	Controller c;
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton up = new JButton(" up ");
	JButton down = new JButton("down");
	JTextField textfield = new JTextField("set temperature here", 14);
	JLabel label = new JLabel("Temperature set appears here");
	
	public View(Model m, Controller c) {
		this.m = m;
		this.c = c;
		
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildGUI();
		m.registerObserver(this);
		
		this.setContentPane(panel);
		this.setVisible(true);
		
	}

	private void buildGUI() {
		
		panel.setLayout(new FlowLayout());
		panel.add(up);
		panel.add(down);
		panel.add(textfield);
		panel.add(label);
		
		registerListener();
		
	}

	private void registerListener() {
		textfield.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				c.setInput();
			}});
		up.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				c.upValue();
			}});
		down.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				c.downValue();
			}});
	}

	@Override
	public void update() {
		label.setText(String.valueOf(m.getTemperature()));
	}

	public String getEntry() {
		return textfield.getText();
	}

	public void showError(String str) {
		label.setText(str);
	}
}
