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
	private String idProducto;
	public Inventario(){

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
		System.out.print("CANTIDAD: ");cantidad=ent.nextInt();
		productos[cProductos].setCantidad(cantidad);
		costo=productos[cProductos].getCosto();
		nombreProducto=productos[cProductos].getNombreProducto();
		idProducto=productos[cProductos].getIdProducto();
		cProductos++;
	}
	public void sumarProductos(){
		Scanner ent=new Scanner(System.in);
		String buscarId;
		boolean comprobador=false;
		System.out.print("\nID DEL PRODUCTO: ");buscarId=ent.nextLine();
		for(int i=0; i<cProductos; i++){
			if(productos[i].getIdProducto().equals(buscarId)){
				System.out.print("CANTIDAD: ");cantidad=ent.nextInt();
				productos[i].setCantidad(productos[i].getCantidad()+cantidad);
				costo=productos[i].getCosto();
				nombreProducto=productos[i].getNombreProducto();
				idProducto=productos[i].getIdProducto();
				comprobador=true;
				break;
			}
			else
				comprobador=false;
		}
		if(comprobador==false){
			int opcion;
			System.out.println("\nEL PRODUCTO NO EXISTE EN NUESTRA LINEA");
			System.out.println("1.- INTENTAR DE NUEVO || 2.- CAPTURAR NUEVO PRODUCTO");
			System.out.print("Opcion: "); opcion=ent.nextInt();
			if(opcion==2){
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
		int dato=0;
		boolean comprobador=false, comprobador2=false;
		System.out.print("\nID DEL PRODUCTO: ");buscarId=ent.nextLine();
		for(int i=0; i<cProductos; i++){
			if(productos[i].getIdProducto().equals(buscarId)){
				do{
					System.out.print("CANTIDAD: ");cantidad=ent.nextInt();
					productos[i].setCantidad(productos[i].getCantidad()-cantidad);
					if(productos[i].getCantidad()<0){
						System.out.println("LA CANTIDAD DE PRODUCTOS EXCEDE NUESTRO INVENTARIO");
						productos[i].setCantidad(productos[i].getCantidad()+cantidad);
						System.out.println("CANTIDAD DISPONIBLE: "+productos[i].getCantidad());
						System.out.println("1.-INTENTE DE NUEVO      2.-CANCELAR");
						dato=ent.nextInt();
						if(dato==1)
							comprobador2=false;
						else{
							comprobador2=true;
							break;
						}
					}
					else
						comprobador2=true;
				}while(comprobador2==false);
				precio=productos[i].getPrecio();
				nombreProducto=productos[i].getNombreProducto();
				idProducto=productos[i].getIdProducto();
				comprobador =true;
				break;
			}
			else
				comprobador=false;
		}
		if(comprobador==false){
			System.out.println("\nEL PRODUCTO NO EXISTE EN NUESTRA LINEA, INTENTE DE NUEVO");
			restarProductos();
		}
	}
	public String getIdProducto(){
		return idProducto;
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
