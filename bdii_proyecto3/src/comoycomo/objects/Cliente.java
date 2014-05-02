package comoycomo.objects;

public class Cliente {
	private String nombre="";
	private String paterno="";
	private String materno="";
	private String calle="";
	private String colonia="";
	
	public Cliente(String nombre, String paterno,
					String materno, String calle,
					String colonia){
		this.nombre=nombre;
		this.paterno=paterno;
		this.materno=materno;
		this.calle=calle;
		this.colonia=colonia;
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
}
