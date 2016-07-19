package com.leo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.leo.dao.UserDao;
import com.leo.model.User;
import com.leo.util.DbUtil;
import com.leo.util.StringUtil;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginFrm extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private String lookAndFeel_win = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"; //观感
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrm.class.getResource("/images/leo.jpg")));
		setTitle("管理员登录");
		try {
			UIManager.setLookAndFeel(lookAndFeel_win);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 355);
		setFocusable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setFocusable(true);
		
		JLabel lblNewLabel = new JLabel("图书管理系统");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 23));
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/logo.png")));
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userName.png")));
		
		JLabel lblNewLabel_2 = new JLabel("密 码：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/password.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setToolTipText("请输入用户名");
		userNameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setToolTipText("请输入密码");
		passwordTxt.setFont(new Font("微软雅黑", Font.PLAIN, 9));
		
		JButton loginBtn = new JButton("登录");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		loginBtn.setToolTipText("登录");
		loginBtn.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/login.png")));
		
		JButton resetBtn = new JButton("重置");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		resetBtn.setToolTipText("重置");
		resetBtn.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/reset.png")));
		
		JButton registerBtn = new JButton("注册");
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toRegisterActionPerformed(e);
			}
		});
		registerBtn.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/leo.jpg")));
		registerBtn.setToolTipText("注册");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(loginBtn)
							.addGap(29)
							.addComponent(registerBtn)
							.addGap(18)
							.addComponent(resetBtn)))
					.addGap(57))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(lblNewLabel)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBtn)
						.addComponent(registerBtn)
						.addComponent(resetBtn))
					.addGap(70))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null); //设置窗体启动位置居中
	}
	
	/**
	 * 跳转注册界面事件处理
	 * @param evt
	 */
	private void toRegisterActionPerformed(ActionEvent evt) {
		this.dispose();
		new RegisterFrm().setVisible(true);
	}

	/**
	 * 登录事件处理
	 * @param evt
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String password = String.valueOf(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！","警告",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！","警告",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		User user = new User(userName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if(currentUser != null) {
//				JOptionPane.showMessageDialog(null, "登录成功");
				this.dispose(); //销毁窗体
				new MainFrm().setVisible(true); //创建主窗体并设置为可见
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！","提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "登录异常，请稍后重试！","提示",
					JOptionPane.INFORMATION_MESSAGE);
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}
	
	/**
	 * 重置表单数据
	 */
	private void resetValue() {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
