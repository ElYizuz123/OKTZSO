import java.io.Serializable;
import java.util.Scanner;
public class DetalleC implements Interface, Serializable{
	private String idProducto;
	private int cantidad;
	private double costo;
	private double total;
	private String nombreP;


	public DetalleC(String idProducto, int cantidad, double costo){
		this.idProducto=idProducto;
		this.cantidad=cantidad;
		this.costo=costo;
	}
	public DetalleC(){

	}
	public String queSoy(){
		return "DetalleC";
	}

	public void mostrar(){
		String[] arreglo = new String[36];
		String cantidadS=String.valueOf(cantidad);
		String totalS=String.valueOf(total);
		char c;
		for(int i=0; i<nombreP.length(); i++){
			arreglo[i]=" ";
			c=nombreP.charAt(i);
			arreglo[i]=String.valueOf(c);
		}
		arreglo[25]=cantidadS;
		arreglo[34]="$"+totalS;
		for(int i=0; i<36; i++){
			if(arreglo[i]==null)
				arreglo[i]=" ";

			System.out.print(arreglo[i]);
		}
		System.out.println();
	}

	public void capturar(){

	}
	public void capturar(Inventario inv){
		Scanner leer=new Scanner(System.in);
		int opcion;
		System.out.println("\n1.- AGREGAR PRODUCTO NUEVO   ||   2.- AGREGAR PRODUCTO EXISTENTE");
		System.out.print("Opcion: "); opcion=leer.nextInt();leer.nextLine();
		if(opcion==1)
			inv.capturarNuevoProducto();
		else
			inv.sumarProductos();
		costo=inv.getCosto();
		cantidad=inv.getCantidad();
		total=costo*cantidad;
		nombreP=inv.getNombreProducto();
		idProducto=inv.getIdProducto();
	}

	public String getIdProducto(){
		return idProducto;
	}
	public void setIdProducto(String idProducto){
		this.idProducto=idProducto;
	}
	public int getCantidad(){
		return cantidad;
	}
	public void setCantidad(int cantidad){
		this.cantidad=cantidad;
	}
	public double getCosto(){
		return costo;
	}
	public void setCosto(int costo){
		this.costo=costo;
	}
	public double getTotal(){
		return total;
	}
	public void setTotal(int total){
		this.total=total;
	}
	public String getNombreP(){
		return nombreP;
	}
}
