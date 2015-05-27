package Controller;

import java.util.ArrayList;

import Modelo.Delincuente;
import Modelo.ModeloDelincuente;

public class DelincuenteController {
	
	private ModeloDelincuente md;

	public DelincuenteController() {
		// TODO Auto-generated constructor stub
		md = new ModeloDelincuente();
	}
	
	public ArrayList<Delincuente> loadDelincuentes(){
		return md.load();
	}
	
	public void guardarDelincuente(Delincuente d){
		md.save(d);
	}

}
