package Controller;

import javax.swing.JOptionPane;

import Modelo.Usuario;

public class LoginController {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkLogin(Usuario user, String password){
		if(password.equals("")){
			JOptionPane.showMessageDialog(null, "El campo contraseña no puede estar vacio.");
		}
		else if(user.getPass().equals(password)){
			return true;
		}
		return false;
	}

}
