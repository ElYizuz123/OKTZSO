import java.io.Serializable;
import java.util.Scanner;
public class Mercancia implements Serializable{
	private String idProducto;
	private int cantidad;
	private double costo;
	private double precio;
	private String nombreProducto;

	public Mercancia(){

	}
	public Mercancia(String idProducto, int cantidad, double costo, double precio, String nombreProducto){
		this.idProducto=idProducto;
		this.cantidad=cantidad;
		this.costo=costo;
		this.precio=precio;
		this.nombreProducto=nombreProducto;
	}

	public void mostrar(){
		System.out.println("\n---------- PRODUCTO --------------");
		System.out.println("ID      : " +idProducto);
		System.out.println("NOMBRE  : "+nombreProducto);
		System.out.println("CANTIDAD: "+cantidad);
		System.out.println("----------------------------------");
	}

	public void capturar(){
		Scanner scn = new Scanner (System.in);
		System.out.println("\n---------------CAPTURAR PRODUCTO----------------");
		System.out.print("ID              : "); idProducto=scn.nextLine();
		System.out.print("NOMBRE          : "); nombreProducto=scn.nextLine();
		System.out.print("COSTO INDIVIDUAL: $");costo=scn.nextDouble();
		System.out.print("COSTO DE VENTA  : $");precio=scn.nextDouble();
		System.out.println("-----------------------------------------------");
	}


	public String getNombreProducto(){
		return nombreProducto;
	}
	public void setNombreProducto(){
		this.nombreProducto=nombreProducto;
	}
	public double getCosto(){
		return costo;
	}
	public void setCosto(double costo){
		this.costo=costo;
	}
	public double getPrecio(){
		return precio;
	}
	public void setPrecio(double precio){
		this.precio=precio;
	}
	public void setIdProducto(String idProducto){
		this.idProducto=idProducto;
	}
	public String getIdProducto(){
		return idProducto;
	}

	public void setCantidad(int cantidad){
		this.cantidad=cantidad;
	}
	public int getCantidad(){
		return cantidad;
	}
}
