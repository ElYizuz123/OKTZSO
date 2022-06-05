import java.util.Scanner;
public class Mercancia{
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
		System.out.println("Productos:");
		System.out.println("ID del producto: " +idProducto);
		System.out.println("Nombre del producto: "+nombreProducto);
		System.out.println("Cantidad: "+cantidad);

	}

	public void capturar(){
		Scanner scn = new Scanner (System.in);
		System.out.println("---------------CAPTURAR PRODUCTO----------------");
		System.out.println("ID del producto: "); idProducto=scn.nextLine();
		System.out.println("Inserte el nombre del producto: "); nombreProducto=scn.nextLine();
		System.out.println("Inserte el costo individual del producto: ");costo=scn.nextDouble();
		System.out.println("Inserte el precio al publico: ");precio=scn.nextDouble();
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
