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
		System.out.println("ID del producto comprado: " +idProductoComprado);
		System.out.println("Precio: $"+precio);
		System.out.println("Cantidad: "+cantidad);
	 }
	public void capturar(){
		Scanner scn = new Scanner (System.in);
		System.out.print("ID del producto comprado: "); idProductoComprado=scn.nextLine();
		System.out.print("Cantidad: ");cantidad=scn.nextInt();
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
