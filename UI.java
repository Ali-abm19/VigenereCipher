import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class UI {

	private JFrame frame;
	private JTextField txtPath;
	private JTextField decPath;
	private JTextField decKey;
	private JLabel lblNewLabel_2;
	private JLabel lblPathToOutput;
	private JTextField outputDecPath;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextArea textAreaForSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 695, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Path to txt file");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtPath = new JTextField();
		GridBagConstraints gbc_txtPath = new GridBagConstraints();
		gbc_txtPath.insets = new Insets(0, 0, 5, 0);
		gbc_txtPath.anchor = GridBagConstraints.WEST;
		gbc_txtPath.gridx = 3;
		gbc_txtPath.gridy = 1;
		frame.getContentPane().add(txtPath, gbc_txtPath);
		txtPath.setColumns(40);
		
		lblPathToOutput = new JLabel("Path to output .dec");
		lblPathToOutput.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblPathToOutput = new GridBagConstraints();
		gbc_lblPathToOutput.anchor = GridBagConstraints.EAST;
		gbc_lblPathToOutput.insets = new Insets(0, 0, 5, 5);
		gbc_lblPathToOutput.gridx = 2;
		gbc_lblPathToOutput.gridy = 2;
		frame.getContentPane().add(lblPathToOutput, gbc_lblPathToOutput);
		
		outputDecPath = new JTextField();
		GridBagConstraints gbc_outputDecPath = new GridBagConstraints();
		gbc_outputDecPath.anchor = GridBagConstraints.WEST;
		gbc_outputDecPath.insets = new Insets(0, 0, 5, 0);
		gbc_outputDecPath.gridx = 3;
		gbc_outputDecPath.gridy = 2;
		frame.getContentPane().add(outputDecPath, gbc_outputDecPath);
		outputDecPath.setColumns(40);
		
		btnNewButton = new JButton("Encrypt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String pathToTxt=txtPath.getText();
					File fileToEnc = new File(pathToTxt);
					String messageToEnc = "";
						try {
							messageToEnc = vigenerecCipher.readFromFileToEncrypt(fileToEnc);
						} catch (FileNotFoundException er) {
							er.printStackTrace();
						}
						String desiredPathForDecFile = outputDecPath.getText();
						// this method is to encrypt
						vigenerecCipher.encryptMessage(messageToEnc, desiredPathForDecFile);
						textAreaForSystem.setText(("Done! check: " + desiredPathForDecFile+".dec"));
						messageToEnc = "";
						
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 3;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Path to .dec file");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 4;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		decPath = new JTextField();
		GridBagConstraints gbc_decPath = new GridBagConstraints();
		gbc_decPath.insets = new Insets(0, 0, 5, 0);
		gbc_decPath.anchor = GridBagConstraints.WEST;
		gbc_decPath.gridx = 3;
		gbc_decPath.gridy = 4;
		frame.getContentPane().add(decPath, gbc_decPath);
		decPath.setColumns(40);
		
		lblNewLabel_2 = new JLabel("Key");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		decKey = new JTextField();
		GridBagConstraints gbc_decKey = new GridBagConstraints();
		gbc_decKey.insets = new Insets(0, 0, 5, 0);
		gbc_decKey.anchor = GridBagConstraints.WEST;
		gbc_decKey.gridx = 3;
		gbc_decKey.gridy = 5;
		frame.getContentPane().add(decKey, gbc_decKey);
		decKey.setColumns(12);
		
		btnNewButton_1 = new JButton("Dycrept");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pathToDec =decPath.getText() ;
				File dec = new File(pathToDec);
				String encKey = decKey.getText();
				// this method is to decrypt:
				vigenerecCipher.decryptFile(dec, encKey);
				textAreaForSystem.setText(("Done! " + "this file was saved with the program files"));
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 6;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		textAreaForSystem = new JTextArea();
		textAreaForSystem.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 28));
		GridBagConstraints gbc_textAreaForSystem = new GridBagConstraints();
		gbc_textAreaForSystem.gridwidth = 4;
		gbc_textAreaForSystem.fill = GridBagConstraints.BOTH;
		gbc_textAreaForSystem.gridx = 0;
		gbc_textAreaForSystem.gridy = 9;
		frame.getContentPane().add(textAreaForSystem, gbc_textAreaForSystem);
	}

}
