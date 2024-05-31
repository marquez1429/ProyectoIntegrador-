package Datos;

public class productoFactura {
	
	private String idProducto;
	private String idFactura;
	private String cantidadVendida;

	
	public productoFactura (String idProducto, String idFactura, String cantidadVendida) {
		
		this.idProducto=idProducto;
		this.idFactura=idFactura;
		this.cantidadVendida=cantidadVendida;
		
		
		
	}


	public String getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	public String getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}
	
	public String getCantidadVendida() {
		return cantidadVendida;
	}
	
	public void setCantidadVendida(String cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

}	
	