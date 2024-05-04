package Datos;

public class productoFactura {
	
	private String idProducto;
	private String idFactura;

	
	public productoFactura (String idProducto, String idFactura) {
		
		this.idProducto=idProducto;
		this.idFactura=idFactura;
		
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

}	
	