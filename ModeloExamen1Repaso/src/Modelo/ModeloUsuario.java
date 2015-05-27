package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario {

	public ModeloUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Usuario> load(){
		MySql conexion = MySql.getInstance();
		ResultSet rs = conexion.query("SELECT * FROM usuarios;");
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try{
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId((int) rs.getObject("id"));
				usuario.setUsuario((String) rs.getObject("usuario"));
				usuario.setPass((String) rs.getObject("pass"));
				usuarios.add(usuario);
			}
		}
		catch(SQLException errorLoadUsuario){
			errorLoadUsuario.printStackTrace();
			System.out.println("ERROR EN LOAD USUARIO");
		}
		return usuarios;
	}
	
	public void save(Usuario user){
		
	}

}
