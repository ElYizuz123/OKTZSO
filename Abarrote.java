import java.util.Scanner;
import java.io.Serializable;
public class Abarrote implements Serializable{
	private String nombreProducto;
	private double precio;
	private int cantidad;
	private double total;

	public Abarrote (String nombreProducto, double precio, int tipoPago){
		this.nombreProducto=nombreProducto;
		this.precio=precio;
		this.cantidad=cantidad;
	}

	public Abarrote(){

	}
	public String queSoy(){
		return "Abarrote";
	}
	public void mostrar(){
		System.out.println(nombreProducto+"           "+cantidad+"      "+total);
	 }
	public void capturar(Inventario inv){
		Scanner scn = new Scanner (System.in);
		inv.restarProductos();
		precio=inv.getPrecio();
		cantidad=inv.getCantidad();
		total=precio*cantidad;
		nombreProducto=inv.getNombreProducto();
	}



	public int getCantidad(){
        return cantidad;
  }
	public void setCantidad(int cantidad){
        this.cantidad=cantidad;
  }
	public void setNombreProducto(String nombreProducto){
		this.nombreProducto=nombreProducto;
	}
	public String getIdProductoComprado(){
		return nombreProducto;
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
