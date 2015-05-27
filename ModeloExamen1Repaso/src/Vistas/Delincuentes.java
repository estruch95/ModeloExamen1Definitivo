package Vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.DelincuenteController;
import Modelo.Delincuente;

public class Delincuentes extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JTextField textFieldSexo;
	private JTextField textFieldNacionalidad;
	private JTextField textFieldDireccion;
	private JTextField textFieldPoblacion;
	private Delincuente delincuenteSeleccionado;
	private Ventana ventana;
	
	private DelincuenteController dc;

	/**
	 * Create the panel.
	 */
	public Delincuentes(Ventana v) {
		this.setBounds(100, 100, 500, 450);
		setLayout(null);
		this.ventana=v;
		
		dc = new DelincuenteController();
		
		etiquetas();
		camposTexto();
		botones();
		lista();
		
	}
	
	private void etiquetas(){
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(315, 6, 61, 16);
		add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(315, 74, 61, 16);
		add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(400, 74, 61, 16);
		add(lblSexo);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(315, 142, 100, 16);
		add(lblNacionalidad);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(315, 210, 102, 16);
		add(lblDireccion);
		
		JLabel lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setBounds(315, 278, 87, 16);
		add(lblPoblacion);
	}
	
	private void camposTexto(){
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(315, 34, 166, 28);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(315, 102, 47, 28);
		add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(374, 102, 100, 28);
		add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldNacionalidad = new JTextField();
		textFieldNacionalidad.setBounds(315, 170, 166, 28);
		add(textFieldNacionalidad);
		textFieldNacionalidad.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(315, 238, 163, 28);
		add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		textFieldPoblacion = new JTextField();
		textFieldPoblacion.setBounds(315, 306, 163, 28);
		add(textFieldPoblacion);
		textFieldPoblacion.setColumns(10);
	}
	
	private void botones(){
		JButton btnAntecedentes = new JButton("Antecedentes");
		btnAntecedentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonAntecedentes();
			}
		});
		btnAntecedentes.setBounds(315, 346, 163, 29);
		add(btnAntecedentes);
	}
	
	private void accionBotonAntecedentes(){
		Antecedentes panelAntecedentes = new Antecedentes(ventana,delincuenteSeleccionado);
		ventana.getContentPane().add("Antecedentes", panelAntecedentes);
		
		CardLayout layout = (CardLayout) ventana.getContentPane().getLayout();
		layout.show(ventana.getContentPane(), "Antecedentes");
	}
	
	private void lista(){
		List listaDelincuentes = new List();
		listaDelincuentes.setBackground(Color.WHITE);
		listaDelincuentes.setBounds(54, 34, 207, 300);
		for(int a=0;a<dc.loadDelincuentes().size();a++){
			listaDelincuentes.add(dc.loadDelincuentes().get(a).getNombre());
		}
		listaDelincuentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delincuenteSeleccionado = dc.loadDelincuentes().get(listaDelincuentes.getSelectedIndex());
				volcadoDatos();
			}
		});
		add(listaDelincuentes);
	}
	
	private void volcadoDatos(){
		textFieldNombre.setText(delincuenteSeleccionado.getNombre());
		textFieldEdad.setText(String.valueOf(delincuenteSeleccionado.getEdad()));
		textFieldSexo.setText(delincuenteSeleccionado.getSexo());
		textFieldNacionalidad.setText(delincuenteSeleccionado.getNacionalidad());
		textFieldDireccion.setText(delincuenteSeleccionado.getDireccion());
		textFieldPoblacion.setText(delincuenteSeleccionado.getPoblacion());
	}
}
