package com.leo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class JustZEROInterFrm extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	private String lookAndFeel_win = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JustZEROInterFrm frame = new JustZEROInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JustZEROInterFrm() {
		getContentPane().setBackground(new Color(245, 222, 179));
		setFrameIcon(new ImageIcon(JustZEROInterFrm.class.getResource("/images/justZERO.jpg")));
		setClosable(true);
		setIconifiable(true);
		setTitle("关于justZERO");
		try {
			UIManager.setLookAndFeel(lookAndFeel_win);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBounds(100, 100, 221, 377);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(JustZEROInterFrm.class.getResource("/images/jz.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

}
