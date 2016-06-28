

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LoginForm extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	public LoginForm(final TransferType transferType) {
		super("User Authentication");
		setLocationRelativeTo(null);
		setSize(400, 400);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(55, 144, 62, 16);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(55, 96, 72, 16);
		getContentPane().add(lblUsername);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(175, 87, 136, 36);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText().toString();
				String password = new String(passwordField.getPassword());
				if (LoginClass.loginUser(username, password) == true) {
					JOptionPane.showMessageDialog(null, "Login successful.");
					if (transferType == TransferType.DOWNLOAD) {
						DownloadFiles.downloadFiles();
					} else if (transferType == TransferType.UPLOAD) {
						UploadFiles.uploadFiles();
					}
					dispose();
				} else {
					JOptionPane
							.showMessageDialog(null, "Login not successful.");
				}
			}
		});
		btnLogin.setBounds(55, 207, 97, 25);
		getContentPane().add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(175, 133, 136, 36);
		getContentPane().add(passwordField);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText().toString();
				String password = new String(passwordField.getPassword());
				if (RegisterClass.registerUser(username, password) == true) {
					JOptionPane.showMessageDialog(null, "Register successful.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Register not successful.");
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setBounds(214, 208, 97, 25);
		getContentPane().add(btnRegister);
	}
}
