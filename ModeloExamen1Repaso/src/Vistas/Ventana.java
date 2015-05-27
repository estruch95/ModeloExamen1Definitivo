package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ventana extends JFrame {

	private Principal panelPrincipal;
	private Delincuentes panelDelincuentes;
	
	public Ventana() {
		setTitle("Consultaria Delincuentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		//DECLARACION DE PANELES 
		panelPrincipal = new Principal(this);
		panelDelincuentes = new Delincuentes(this);
		
		//AÑADIDO DE PANELES AL CARDLAYOUT
		this.getContentPane().add("Principal", panelPrincipal);
		this.getContentPane().add("Delincuentes", panelDelincuentes);
		
		
		//CONSTRUCCION DEL MENU EN LA VENTANA
		menu();
	}
	
	private void menu(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mntmPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) getContentPane().getLayout();
				layout.show(getContentPane(), "Principal");
			}
		});
		mnPrincipal.add(mntmPrincipal);
		
		JMenu mnDelincuentes = new JMenu("Delincuentes");
		menuBar.add(mnDelincuentes);
		
		JMenuItem mntmDelincuentes = new JMenuItem("Delincuentes");
		mntmDelincuentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panelPrincipal.isEsRegistrado()==true){
					CardLayout layout = (CardLayout) getContentPane().getLayout();
					layout.show(getContentPane(), "Delincuentes");
				}
				else{
					JOptionPane.showMessageDialog(null, "Debes estar registrado para visualizar los delincuentes");
				}
			}
		});
		mnDelincuentes.add(mntmDelincuentes);
	}
}
