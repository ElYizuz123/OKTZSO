import java.util.Scanner;
public class Abarrote{
	private String idProductoComprado;
	private double precio;
	private int cantidad;
	private double total;

	public Abarrote (String idProductoComprado, double precio, int tipoPago){
		this.idProductoComprado=idProductoComprado;
		this.precio=precio;
		this.cantidad=cantidad;
	}

	public Abarrote(){

	}
	public String queSoy(){
		return "Abarrote";
	}
	public void mostrar(){
		System.out.println(idProductoComprado+"           "+cantidad+"      "+total);
	 }
	public void capturar(Inventario inv){
		Scanner scn = new Scanner (System.in);
		inv.restarProductos();
		precio=inv.getPrecio();
		System.out.print("CANTIDAD: ");cantidad=inv.getCantidad();
		total=precio*cantidad;
	}



	public int getCantidad(){
        return cantidad;
  }
	public void setCantidad(int cantidad){
        this.cantidad=cantidad;
  }
	public void setIdProductoComprado(String idProductoComprado){
		this.idProductoComprado=idProductoComprado;
	}
	public String getIdProductoComprado(){
		return idProductoComprado;
	}

	public void setPrecio(double precio){
		this.precio=precio;
	}
	public double getPrecio(){
		return precio;
	}
	public double getTotal(){
		return total;
	}
	public void setTotal(double total){
		this.total=total;
	}
}
