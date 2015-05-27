package Controller;

import java.util.ArrayList;

import Modelo.ModeloUsuario;
import Modelo.MySql;
import Modelo.Usuario;

public class UsuarioController {

	private ModeloUsuario mu;
	
	public UsuarioController() {
		// TODO Auto-generated constructor stub
		mu = new ModeloUsuario();
	}
	
	public ArrayList<Usuario> loadUsuarios(){
		return mu.load();
	}
	
	public void eliminarUsuario(Usuario usuario){
		MySql conexion = MySql.getInstance();
		conexion.modifyQuery("DELETE FROM usuarios WHERE id="+usuario.getId()+";");
	}

}
