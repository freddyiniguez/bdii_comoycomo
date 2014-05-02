package comoycomo.objects;

public class Poblacion {
	private String nombre="";
	private int habitantes;
	
	public Poblacion(String nombre, int habitantes){
		this.nombre = nombre;
		this.habitantes = habitantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	
}
