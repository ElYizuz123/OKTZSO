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
		System.out.println("\nID DEL PRODUCTO: " +idProductoComprado);
		System.out.println("PRECIO: $"+precio);
		System.out.println("CANTIDAD: "+cantidad);
	 }
	public void capturar(){
		Scanner scn = new Scanner (System.in);
		System.out.print("ID DEL PRODUCTO: "); idProductoComprado=scn.nextLine();
		System.out.print("CANTIDAD: ");cantidad=scn.nextInt();
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
