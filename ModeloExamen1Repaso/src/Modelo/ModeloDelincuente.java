package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ModeloDelincuente {

	public ModeloDelincuente() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Delincuente> load(){
		MySql conexion = MySql.getInstance();
		ResultSet rs = conexion.query("SELECT * FROM delincuentes;");
		
		ArrayList<Delincuente> delincuentes = new ArrayList<Delincuente>();
		try{
			while(rs.next()){
				Delincuente delincuente = new Delincuente();
				delincuente.setId((int) rs.getObject("id"));
				delincuente.setNombre((String) rs.getObject("nombre"));
				delincuente.setEdad((int) rs.getObject("edad"));
				delincuente.setSexo((String) rs.getObject("sexo"));
				delincuente.setNacionalidad((String) rs.getObject("nacionalidad"));
				delincuente.setDireccion((String) rs.getObject("direccion"));
				delincuente.setPoblacion((String) rs.getObject("poblacion"));
				delincuente.setAntecedentes((String) rs.getObject("antecedentes"));
				delincuentes.add(delincuente);
			}
		}
		catch(SQLException errorLoadDelincuente){
			errorLoadDelincuente.printStackTrace();
			System.out.println("ERROR EN LOAD DELINCUENTE");
		}
		return delincuentes;
	} 

	public void save(Delincuente d){
		MySql conexion = MySql.getInstance();
		conexion.modifyQuery("UPDATE delincuentes SET antecedentes='"+d.getAntecedentes()+"' WHERE id="+d.getId()+";");
		JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
	}
}
