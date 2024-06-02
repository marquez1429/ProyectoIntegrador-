

package Datos;
public class factura {
	
	private String id;
	private String cedulaCliente;
	private String cedulaVendedor;
	private String fecha;
	private String subtotal;
	private String iva;
	
	public factura (String id, String cedulaCliente, String cedulaVendedor, String fecha, String subtotal, String iva ) {
		
		this.id=id;
		this.cedulaCliente=cedulaCliente;
		this.cedulaVendedor=cedulaVendedor;
		this.fecha=fecha;
		this.subtotal=subtotal;
		this.iva=iva;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getCedulaVendedor() {
		return cedulaVendedor;
	}

	public void setCedulaVendedor(String cedulaVendedor) {
		this.cedulaVendedor = cedulaVendedor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public static void clear() {
		// TODO Auto-generated method stub
		
	}

	public void add(factura factura) {
		
		// TODO Auto-generated method stub
		
	}

}