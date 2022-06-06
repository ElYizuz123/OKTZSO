import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;


public class Inventario{
	private Mercancia productos[]=new Mercancia[1000];
	private int cProductos=0;
	private int cantidad;
	private double precio;
	private double costo;
	private String nombreProducto;
	public Inventario (){

	}
	public void mostrar(){
		for(int i=0; i<cProductos; i++){
			productos[i].mostrar();
		}
	}
	public void guardar(){
		FileOutputStream salidaP=null;
		ObjectOutputStream oP=null;
		try{
			salidaP= new FileOutputStream("Inventario.dat");
			oP= new ObjectOutputStream(salidaP);
			for(int i=0; i<cProductos; i++)
				oP.writeObject(productos[i]);
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	public void cargar(){
		FileInputStream entradaP=null;
		ObjectInputStream oP=null;
		try{
			entradaP=new FileInputStream ("Inventario.dat");
			oP=new ObjectInputStream(entradaP);
			productos[cProductos]=(Mercancia)oP.readObject();
			while(productos[cProductos]!=null){
				cProductos++;
				productos[cProductos]=(Mercancia)oP.readObject();
			}
		}
		catch(Exception e){

		}
	}
	public void capturarNuevoProducto(){
		Scanner ent=new Scanner(System.in);
		productos[cProductos]=new Mercancia();
		productos[cProductos].capturar();
		System.out.println("Inserte la cantidad de productos: ");cantidad=ent.nextInt();
		productos[cProductos].setCantidad(cantidad);
		costo=productos[cProductos].getCosto();
		nombreProducto=productos[cProductos].getNombreProducto();
		cProductos++;
	}
	public void sumarProductos(){
		Scanner ent=new Scanner(System.in);
		String buscarId;
		boolean comprobador=false;
		System.out.print("INSERTE EL ID DEL PRODUCTO: ");buscarId=ent.nextLine();
		for(int i=0; i<cProductos; i++){
			if(productos[i].getIdProducto().equals(buscarId)){
				System.out.println("Inserte la cantidad de productos");cantidad=ent.nextInt();
				productos[i].setCantidad(productos[i].getCantidad()+cantidad);
				costo=productos[i].getCosto();
				nombreProducto=productos[i].getNombreProducto();
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
			if(productos[i].getIdProducto().equals(buscarId)){
				System.out.println("Inserte la cantidad de productos");cantidad=ent.nextInt();
				productos[i].setCantidad(productos[i].getCantidad()-cantidad);
				precio=productos[i].getPrecio();
				nombreProducto=productos[i].getNombreProducto();
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
	public int getCantidad(){
		return cantidad;
	}
	public String getNombreProducto(){
		return nombreProducto;
	}
}
