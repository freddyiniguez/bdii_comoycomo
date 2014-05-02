package comoycomo.objects;

public class Empleado {
	private String RFC = "";
	private String nombre = "";
	private String paterno = "";
	private String materno = "";
	private String calle = "";
	private String colonia = "";
	private int telefono;
	
	public Empleado(String RFC,
					String nombre, 
					String paterno, 
					String materno, 
					String calle, 
					String colonia, 
					int telefono){
		this.RFC = RFC;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.calle = calle;
		this.colonia = colonia;
		this.telefono = telefono;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
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