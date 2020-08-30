package facturacion;

public class FacturaProducto {
	private Factura factura;
	private Producto producto;
	private int cantidad;
	public FacturaProducto(Factura factura, Producto producto, int cantidad) {
		super();
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public FacturaProducto() {
		super();
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Factura getFactura() {
		return factura;
	}
	public Producto getProducto() {
		return producto;
	}
	
}
