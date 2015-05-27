package Vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.LoginController;
import Controller.UsuarioController;
import Modelo.Usuario;

public class Principal extends JPanel {
	
	private JButton btnLogin;
	private JButton btnLogout;
	private JComboBox comboBoxUsuarios;
	private JPasswordField password;
	private Usuario usuarioSeleccionado;
	private boolean esRegistrado=false;
	
	private UsuarioController uc;
	private LoginController lc;
	private JTextField txtMensajeDeControl;
	private Ventana ventana;

	/**
	 * Create the panel.
	 */
	public Principal(Ventana v) {
		this.setBounds(100, 100, 500, 450);
		setLayout(null);
		this.ventana=v;
		
		uc = new UsuarioController();
		lc = new LoginController();
		
		comboBox();
		camposTexto();
		botones();	
	}
	
	private void comboBox(){
		comboBoxUsuarios = new JComboBox();
		reloadComboBox();
		comboBoxUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioSeleccionado = (Usuario) comboBoxUsuarios.getSelectedItem();
			}
		});
		comboBoxUsuarios.setBounds(54, 74, 174, 27);
		comboBoxUsuarios.setSelectedIndex(0);
		add(comboBoxUsuarios);
	}
	
	private void reloadComboBox(){
		DefaultComboBoxModel modelo = new DefaultComboBoxModel(uc.loadUsuarios().toArray());
		comboBoxUsuarios.setModel(modelo);
		comboBoxUsuarios.repaint();
	}
	
	private void camposTexto(){
		password = new JPasswordField();
		password.setBounds(54, 113, 174, 28);
		add(password);
		
		
	}
	
	private void botones(){
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonLogin();
			}
		});
		btnLogin.setBounds(54, 251, 174, 29);
		add(btnLogin);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonLogout();
			}
		});
		btnLogout.setBounds(54, 282, 174, 29);
		btnLogout.setEnabled(false);
		add(btnLogout);
		
		txtMensajeDeControl = new JTextField();
		txtMensajeDeControl.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtMensajeDeControl.setHorizontalAlignment(SwingConstants.CENTER);
		txtMensajeDeControl.setText("MENSAJE DE CONTROL");
		txtMensajeDeControl.setEditable(false);
		txtMensajeDeControl.setBounds(54, 346, 381, 29);
		add(txtMensajeDeControl);
		txtMensajeDeControl.setColumns(10);
	}
	
	private void modLogin(){
		
		btnLogin.setEnabled(false);
		comboBoxUsuarios.setEnabled(false);
		password.setEnabled(false);
		btnLogout.setEnabled(true);
		
		txtMensajeDeControl.setForeground(Color.GREEN);
		txtMensajeDeControl.setText("LOGIN CORRECTO");
	}
	
	private void modLogout(){
		btnLogout.setEnabled(false);
		btnLogin.setEnabled(true);
		comboBoxUsuarios.setEnabled(true);
		password.setEnabled(true);
		password.setText("");
		txtMensajeDeControl.setForeground(Color.BLACK);
		txtMensajeDeControl.setText("MENSAJE DE CONTROL");
	}
	
	private void accionBotonLogin(){
		if(lc.checkLogin(usuarioSeleccionado, password.getText())==true){
			modLogin();
			CardLayout layout = (CardLayout) ventana.getContentPane().getLayout();
			layout.show(ventana.getContentPane(), "Delincuentes");
			esRegistrado=true;
		}
		else{
			txtMensajeDeControl.setForeground(Color.RED);
			txtMensajeDeControl.setText("LOGIN INCORRECTO");
			password.setText("");
			esRegistrado=false;
		}
	}
	
	private void accionBotonLogout(){
		modLogout();
		uc.eliminarUsuario(usuarioSeleccionado);
		reloadComboBox();
		txtMensajeDeControl.setForeground(Color.GREEN);
		txtMensajeDeControl.setText("USUARIO ELIMINADO OK");
		esRegistrado=false;
	}

	public boolean isEsRegistrado() {
		return esRegistrado;
	}
}
