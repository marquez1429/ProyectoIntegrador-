package Datos;

public class producto {
	
	private String id;
	private String nombre;
	private String descripcion;
	private String precio;
	private String cantidad;
	
	
	public producto (String id, String nombre, String descripcion, String precio, String cantidad) {
		
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precio=precio;
		this.cantidad=cantidad;
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}