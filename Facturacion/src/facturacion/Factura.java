package facturacion;

public class Factura {
	private int idFactura;
	private Cliente Cliente;
	public Factura(int idFactura, facturacion.Cliente cliente) {
		super();
		this.idFactura = idFactura;
		Cliente = cliente;
	}
	public Factura() {
		super();
	}
	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	public int getIdFactura() {
		return idFactura;
	}
	
	

}
