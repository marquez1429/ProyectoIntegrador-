package Datos;

public class vendedor {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private String comision;
	private String usuario;
	private String contraseña;
	private String nivelAcceso;
	
	public vendedor(String cedula, String nombre, String apellido, String email, String direccion, String comision, String usuario, String contraseña, String nivelAcceso) {

		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
		this.direccion=direccion;
		this.comision=comision;
		this.usuario=usuario;
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.nivelAcceso=nivelAcceso;
		
		
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

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNivelAcceso() {
		return nivelAcceso;
	}

	public void setNivelAcceso(String nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}
	
}