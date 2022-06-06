import java.util.Scanner;
public class DetalleC implements Interface{
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
		System.out.println(nombreP+"          "+cantidad+"       "+total);
	}

	public void capturar(){
		
	}
	public void capturar(Inventario inv){
		Scanner leer=new Scanner(System.in);
		int opcion;
		System.out.println("----------CAPTURA LA COMPRA----------");
		System.out.print("1.- AGREGAR PRODUCTO NUEVO      2.-AGREGAR PRODUCTO EXISTENTE");
		opcion=leer.nextInt();leer.nextLine();
		if(opcion==1)
			inv.capturarNuevoProducto();
		else
			inv.sumarProductos();
		costo=inv.getCosto();
		cantidad=inv.getCantidad();
		total=costo*cantidad;
		nombreP=inv.getNombreProducto();
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
}
