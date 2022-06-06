
import java.util.Scanner;

public class Inventario{
	private Mercancia productos[]=new Mercancia[1000];
	private int cProductos;
	private int cantidad;
	private double precio;
	private double costo;
	public Inventario (){

	}
	public void capturarNuevoProducto(){
		productos[cProductos]=new Mercancia();
		productos[cProductos].capturar();
		costo=productos[cProductos].getCosto();
		cProductos++;
	}
	public void sumarProductos(){
		Scanner ent=new Scanner(System.in);
		String buscarId;
		boolean comprobador=false;
		System.out.print("INSERTE EL ID DEL PRODUCTO: ");buscarId=ent.nextLine();
		for(int i=0; i<cProductos; i++){
			if(productos[i].getIdProducto().contains(buscarId)){
				System.out.println("Inserte la cantidad de productos");cantidad=ent.nextInt();
				productos[i].setCantidad(productos[i].getCantidad()+cantidad);
				costo=productos[i].getCosto();
				comprobador=true;
				break;
			}
			else
				comprobador=false;
		}
		if(comprobador=false){
			int opcion;
			System.out.println("El producto capturado no existe en nuestra lista: 1.-CAPTURAR UNO NUEVO   2.-VOLVER A INTENTAR");opcion=ent.nextInt();
			if(opcion==1){
				capturarNuevoProducto();
			}
			else{
				sumarProductos();
			}
		}
	}
	public void restarProductos(){
		Scanner ent=new Scanner(System.in);
		String buscarId;
		boolean comprobador=false;
		System.out.print("INSERTE EL ID DEL PRODUCTO: ");buscarId=ent.nextLine();
		for(int i=0; i<cProductos; i++){
			if(productos[i].getIdProducto().contains(buscarId)){
				System.out.println("Inserte la cantidad de productos");cantidad=ent.nextInt();
				productos[i].setCantidad(productos[i].getCantidad()-cantidad);
				precio=productos[i].getPrecio();
				comprobador =true;
				break;
			}
			else
				comprobador=false;
		}
		if(comprobador=false){
			System.out.println("El producto capturado no existe en nuestra lista vuelva a intentar");
			restarProductos();
		}
	}
	public double getPrecio(){
		return precio;
	}
	public double getCosto(){
		return costo;
	}
}
