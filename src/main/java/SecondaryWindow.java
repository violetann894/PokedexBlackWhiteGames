

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class SecondaryWindow {

	JFrame frame2;

	/**
	 * Create the application.
	 */
	public SecondaryWindow(String name, int id, String picture, String[] types, String species, String blackDesc, String whiteDesc) {
		initialize(name, id, picture, types, species, blackDesc, whiteDesc);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, int id, String picture, String[] types, String species, String blackDesc, String whiteDesc) {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 314, 632);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		
		
		String pokedexId = "";
		
		if(id < 10) {
			pokedexId = String.format("#00%d", id);
		}else if(id < 100) {
			pokedexId = String.format("#0%d", id);
		}else {
			pokedexId = String.format("#%d", id);
		}
		
		String type2Text = "";
		
		try {
			type2Text = types[1];
		}catch(IndexOutOfBoundsException e) {
			type2Text = "";
		}
		
		JLabel lblType2 = new JLabel(type2Text);
		lblType2.setFont(new Font("Monospaced", Font.PLAIN, 9));
		lblType2.setHorizontalAlignment(SwingConstants.CENTER);
		lblType2.setBounds(192, 257, 48, 14);
		frame2.getContentPane().add(lblType2);
		
		JLabel lblType1 = new JLabel(types[0]);
		lblType1.setFont(new Font("Monospaced", Font.PLAIN, 9));
		lblType1.setHorizontalAlignment(SwingConstants.CENTER);
		lblType1.setBounds(192, 234, 48, 14);
		frame2.getContentPane().add(lblType1);
		
		JLabel lblName = new JLabel(name);
		lblName.setFont(new Font("Monospaced", Font.PLAIN, 11));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(178, 178, 75, 14);
		frame2.getContentPane().add(lblName);
		
		JLabel lblIDNumber = new JLabel(pokedexId);
		lblIDNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDNumber.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblIDNumber.setBounds(192, 153, 48, 14);
		frame2.getContentPane().add(lblIDNumber);
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setIcon(new ImageIcon(picture));
		lblPicture.setBounds(22, 144, 115, 111);
		frame2.getContentPane().add(lblPicture);
		
		JLabel lblPokedexEntries = new JLabel("Pokedex Entries");
		lblPokedexEntries.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokedexEntries.setBounds(70, 303, 157, 14);
		frame2.getContentPane().add(lblPokedexEntries);
		
		JTextArea textAreaBlackDesc = new JTextArea();
		textAreaBlackDesc.setWrapStyleWord(true);
		textAreaBlackDesc.setLineWrap(true);
		textAreaBlackDesc.setEditable(false);
		textAreaBlackDesc.setBackground(new Color(196, 240, 248));
		textAreaBlackDesc.setText("Black Description: " + blackDesc);
		textAreaBlackDesc.setBounds(22, 328, 257, 58);
		frame2.getContentPane().add(textAreaBlackDesc);
		
		JTextArea txtrWhiteDescription = new JTextArea();
		txtrWhiteDescription.setWrapStyleWord(true);
		txtrWhiteDescription.setLineWrap(true);
		txtrWhiteDescription.setEditable(false);
		txtrWhiteDescription.setText("White Description: " + whiteDesc);
		txtrWhiteDescription.setBackground(new Color(196, 240, 248));
		txtrWhiteDescription.setBounds(22, 397, 257, 58);
		frame2.getContentPane().add(txtrWhiteDescription);
		
		JLabel lblSpecies = new JLabel(species);
		lblSpecies.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecies.setFont(new Font("Monospaced", Font.PLAIN, 10));
		lblSpecies.setBounds(154, 203, 125, 20);
		frame2.getContentPane().add(lblSpecies);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rache\\Downloads\\5818315-2919219070.png"));
		lblNewLabel.setBounds(0, 0, 302, 597);
		frame2.getContentPane().add(lblNewLabel);
	}

}
