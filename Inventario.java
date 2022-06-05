import java.util.Scanner;
public class Inventario implements interface{
	private String idProducto;
	private int cantidad;
	
	public Inventario (String idProducto, int cantidad){
		this.idProducto=idProducto;
		this.cantidad=cantidad;
	}
	
	public Inventario{
		
	}
	
	public void mostrar(){
		System.out.println("Inventario:");
		System.out.println("ID del producto: " +idProducto);
		System.out.println("Cantidad: "+cantidad);
	}
	
	public void capturar(){
		Scanner scn = new Scanner (System.in);
		System.out.println("Capturar Inventario:");
		System.out.println("ID del producto: "); idProducto=scn.nextLine();
		System.out.println("Cantidad: "); cantidad=scn.nextInt();
	}
	
	
	
	public Void setIdProducto(String idProducto){
		this.idProducto=idProducto;
	}
	public String getIdProducto(){
		return idProducto;
	}
	
	public Void setCantidad(int cantidad){
		this.cantidad=cantidad;
	}
	public int getCantidad(){
		return cantidad;
	}	
	
}