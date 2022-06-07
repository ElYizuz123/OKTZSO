import java.util.Scanner;
import java.io.Serializable;
public class Abarrote implements Serializable{
	private String nombreProducto;
	private double precio;
	private int cantidad;
	private double total;
	private String idProductoComprado;

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
		int cont=35;
		String[] arreglo = new String[36];
		String cantidadS=String.valueOf(cantidad);
		String totalS=String.valueOf(total);
		char c;
		for(int i=0; i<nombreProducto.length(); i++){
			c=nombreProducto.charAt(i);
			arreglo[i]=String.valueOf(c);
		}
		for(int i=0; i<cantidadS.length(); i++){
			c=cantidadS.charAt(i);
			arreglo[cont]=String.valueOf(c);
			cont++;
		}
		arreglo[35]="$"+totalS;
		for(int i=0; i<36; i++){
			if(arreglo[i]==null)
				arreglo[i]=" ";

			System.out.print(arreglo[i]);
		}
		System.out.println();
	 }
	public void capturar(Inventario inv){
		Scanner scn = new Scanner (System.in);
		inv.restarProductos();
		precio=inv.getPrecio();
		cantidad=inv.getCantidad();
		total=precio*cantidad;
		nombreProducto=inv.getNombreProducto();
		idProductoComprado=inv.getIdProducto();
	}


	public String getNombreProducto(){
		return nombreProducto;
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
