package Vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import Controller.DelincuenteController;
import Modelo.Delincuente;

public class Antecedentes extends JPanel {
	
	private Ventana ventana;
	private Delincuente delincuente;
	private JTextPane textPane;
	private DelincuenteController dc;

	/**
	 * Create the panel.
	 */
	public Antecedentes(Ventana v, Delincuente d) {
		setLayout(null);
		this.ventana=v;
		this.delincuente=d;
		
		dc = new DelincuenteController();
		
		etiquetas();
		areaTexto();
		botones();
	}
	
	private void etiquetas(){
		JLabel lblAntecedentes = new JLabel("ANTECEDENTES");
		lblAntecedentes.setBounds(43, 28, 175, 16);
		add(lblAntecedentes);
	}
	
	private void areaTexto(){
		textPane = new JTextPane();
		textPane.setBounds(43, 62, 351, 172);
		textPane.setText(this.delincuente.getAntecedentes());
		add(textPane);
	}
	
	private void botones(){
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonGuardarCambios();
			}
		});
		btnGuardarCambios.setBounds(43, 246, 150, 29);
		add(btnGuardarCambios);
		
		JButton button = new JButton("< Atras");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonVolverAtras();
			}
		});
		button.setBounds(231, 246, 117, 29);
		add(button);
	}
	
	private void accionBotonVolverAtras(){
		CardLayout layout = (CardLayout) ventana.getContentPane().getLayout();
		layout.show(ventana.getContentPane(), "Delincuentes");
	}
	
	private void accionBotonGuardarCambios(){
		delincuente.setAntecedentes(textPane.getText());
		dc.guardarDelincuente(delincuente);
	}
}
