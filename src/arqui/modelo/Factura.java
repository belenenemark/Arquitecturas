package arqui.modelo;

public class Factura {
	private int idFactura;
	private int idCliente;
	public Factura(int idFactura, int idCliente) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
	}
	public Factura() {
		super();
	}
	public int getCliente() {
		return this.idCliente;
	}
	
	public void setCliente(int cliente) {
		this.idCliente = cliente;
	}
	public int getIdFactura() {
		return idFactura;
	}
	
	

}
