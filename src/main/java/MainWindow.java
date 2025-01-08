import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.util.ArrayList;

import com.google.gson.Gson;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;

public class MainWindow {

	public JFrame frame;
	
	public PokedexManager pm = new PokedexManager();
	
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 314, 631);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final DefaultListModel dList = new DefaultListModel();
		
		
		//Original statement used to populate the database
		/*
		Reader r;
		try {
			r = Files.newBufferedReader(Paths.get("C:\\Users\\Rache\\eclipse-workspace\\PokedexBlackWhite\\pokemon_data.json"));
			Pokemon[] p = new Gson().fromJson(r, Pokemon[].class);
			
			for(Pokemon a : p) {
				dList.addElement(a);
				pm.addItem(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		for(int i = 0; i < 157; i++) {
			dList.addElement(pm.getItem(i));
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 282, 287);
		frame.getContentPane().add(scrollPane);
		
		final JList list = new JList(dList);
		scrollPane.setViewportView(list);
		
		JButton btnOpenPokemon = new JButton("Open Pokemon Entry");
		btnOpenPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Pokemon p = pm.getItem(((Pokemon) list.getSelectedValue()).getPokedexId());
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SecondaryWindow window = new SecondaryWindow(p.getName(), p.getPokedexId(), p.getImageSource(), p.getTypes(), p.getSpecies(), p.getBlackDescription(), p.getWhiteDescription());
							window.frame2.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnOpenPokemon.setBounds(72, 442, 159, 23);
		frame.getContentPane().add(btnOpenPokemon);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rache\\Downloads\\5818315-2919219070.png"));
		lblNewLabel.setBounds(0, 23, 300, 572);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnDatabaseActions = new JMenu("Database Actions");
		mnDatabaseActions.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		menuBar.add(mnDatabaseActions);
		
		JMenuItem mntmAdd = new JMenuItem("Add Pokemon");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pokemonName = JOptionPane.showInputDialog("What is the name of the pokemon?");
				String pokemonSpecies = JOptionPane.showInputDialog("What is the species?");
				int id = Integer.parseInt(JOptionPane.showInputDialog("What is Pokemon's ID?"));
				String blackDescript = JOptionPane.showInputDialog("What is the pokemon's description from Pokemon Black?");
				String whiteDescript = JOptionPane.showInputDialog("What is the pokemon's description from Pokemon White?");
				String type = JOptionPane.showInputDialog("Type 1?");
				String type2 = JOptionPane.showInputDialog("Type 2?");
				
				String[] types = new String[2];
				types[0] = type;
				types[1] = type2;
				
				Pokemon n = new Pokemon(pokemonName, id, pokemonSpecies, types, "", blackDescript, whiteDescript);
				
				dList.addElement(n);
				pm.addItem(n);
			}
		});
		mnDatabaseActions.add(mntmAdd);
		
		JMenuItem mntmDelete = new JMenuItem("Delete Pokemon");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon m = (Pokemon) list.getSelectedValue();
				dList.removeElement(m);
				pm.deleteItem(m.getPokedexId());
			}
		});
		mnDatabaseActions.add(mntmDelete);
		
		JMenuItem mntmUpdate = new JMenuItem("Update Pokemon");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon m = (Pokemon) list.getSelectedValue();
				String pokemonName = JOptionPane.showInputDialog("What is the name of the pokemon?");
				String pokemonSpecies = JOptionPane.showInputDialog("What is the species?");
				String blackDescript = JOptionPane.showInputDialog("What is the pokemon's description from Pokemon Black?");
				String whiteDescript = JOptionPane.showInputDialog("What is the pokemon's description from Pokemon White?");
				String type = JOptionPane.showInputDialog("Type 1?");
				String type2 = JOptionPane.showInputDialog("Type 2?");
				if(!pokemonName.equals("")) {
					m.setName(pokemonName);
				}
				if(!pokemonSpecies.equals("")) {
					m.setSpecies(pokemonSpecies);
				}
				if(!blackDescript.equals("")) {
					m.setBlackDescription(blackDescript);
				}
				if(!whiteDescript.equals("")) {
					m.setWhiteDescription(whiteDescript);
				}
				if(!type.equals("")) {
					m.getTypes()[0] = type;
				}
				if(!type2.equals("")) {
					m.getTypes()[1] = type2;
				}
				pm.updateItem(m);
			}
		});
		mnDatabaseActions.add(mntmUpdate);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
