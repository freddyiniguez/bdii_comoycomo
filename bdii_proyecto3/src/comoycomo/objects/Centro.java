package comoycomo.objects;

public class Centro {
	private String nombre="";
	private String calle="";
	private String colonia="";
	private int telefono;
	
	public Centro(String nombre, String calle, String colonia, int telefono){
		this.nombre = nombre;
		this.calle = calle;
		this.colonia = colonia;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
