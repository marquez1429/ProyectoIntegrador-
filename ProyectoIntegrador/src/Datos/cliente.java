package Datos;

public class cliente {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	
	
	public cliente (String cedula, String nombre, String apellido, String email, String direccion ) {
		
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
		this.direccion=direccion;
		;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}