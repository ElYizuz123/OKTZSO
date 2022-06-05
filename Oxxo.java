import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
public class Oxxo{
	private String rfc;
	private String telefono;
	private String paginaWeb;
	private Persona personas[]=new Persona[10000];
	private int cPersonas=0;
	private Ticket ventas[]=new Ticket[10000];
	private int cVentas=0;
	public Oxxo(){
	}
	public Oxxo(String rfc, String telefono, String paginaWeb){
		this.rfc=rfc;
		this.telefono=telefono;
		this.paginaWeb=paginaWeb;
		cargarProveedores();
		cargarClientes();
		cargarTrabajadores();
	}
	public void capturarVenta(){
		ventas[cVentas]=new Ticket();
		ventas[cVentas].capturar();
		cVentas++;
	}
	public void mostrarVentas(){
		for(int i=0; i<cVentas; i++){
			ventas[i].mostrar();
		}
	}
	public void guardarProveedor(){
		FileOutputStream salidaP=null;
		ObjectOutputStream oP=null;
		try{
			salidaP= new FileOutputStream("Proveedores.dat");
			oP= new ObjectOutputStream(salidaP);
			for(int i=0; i<cPersonas; i++){
				if(personas[i].queSoy().equals("Proveedor"))
					oP.writeObject(personas[i]);
			}
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	private void cargarProveedores(){
		FileInputStream entradaP=null;
		ObjectInputStream oP=null;
		try{
			entradaP=new FileInputStream ("Proveedores.dat");
			oP=new ObjectInputStream(entradaP);
			personas[cPersonas]=(Proveedor)oP.readObject();
			while(personas[cPersonas]!=null){
				cPersonas++;
				personas[cPersonas]=(Proveedor)oP.readObject();
			}
		}
		catch(Exception e){

		}
	}

	public void editarProveedor(){
		Scanner ent=new Scanner(System.in);
		int eliminador;
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Proveedor")){
				System.out.println(personas[i].getNombre()+" Numero "+i);
			}
		}
		System.out.println("Inserte el numero de dato a eliminar ");
		eliminador=ent.nextInt();
		personas[eliminador].capturar();

	}
	public void editarTrabajador(){
		Scanner ent=new Scanner(System.in);
		int eliminador;
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Trabajador")){
				System.out.println(personas[i].getNombre()+" Numero "+i);
			}
		}
		System.out.println("Inserte el numero de dato a eliminar ");
		eliminador=ent.nextInt();
		personas[eliminador].capturar();

	}
	public void editarCliente(){
		Scanner ent=new Scanner(System.in);
		int eliminador;
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Cliente")){
				System.out.println(personas[i].getNombre()+" Numero "+i);
			}
		}
		System.out.println("Inserte el numero de dato a eliminar ");
		eliminador=ent.nextInt();
		personas[eliminador].capturar();

	}

	public void guardarTrabajador(){
		FileOutputStream salidaP=null;
		ObjectOutputStream oP=null;
		try{
			salidaP= new FileOutputStream("Trabajadores.dat");
			oP= new ObjectOutputStream(salidaP);
			for(int i=0; i<cPersonas; i++){
				if(personas[i].queSoy().equals("Trabajador"))
					oP.writeObject(personas[i]);
			}
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	private void cargarTrabajadores(){
		FileInputStream entradaP=null;
		ObjectInputStream oP=null;
		try{
			entradaP=new FileInputStream ("Trabajadores.dat");
			oP=new ObjectInputStream(entradaP);
			personas[cPersonas]=(Trabajador)oP.readObject();
			while(personas[cPersonas]!=null){
				cPersonas++;
				personas[cPersonas]=(Trabajador)oP.readObject();
			}
		}
		catch(Exception e){

		}
	}
	public void guardarCliente(){
		FileOutputStream salidaP=null;
		ObjectOutputStream oP=null;
		try{
			salidaP= new FileOutputStream("Clientes.dat");
			oP= new ObjectOutputStream(salidaP);
			for(int i=0; i<cPersonas; i++){
				if(personas[i].queSoy().equals("Cliente"))
					oP.writeObject(personas[i]);
			}
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	private void cargarClientes(){
		FileInputStream entradaP=null;
		ObjectInputStream oP=null;
		try{
			entradaP=new FileInputStream ("Clientes.dat");
			oP=new ObjectInputStream(entradaP);
			personas[cPersonas]=(Cliente)oP.readObject();
			while(personas[cPersonas]!=null){
				cPersonas++;
				personas[cPersonas]=(Cliente)oP.readObject();
			}
		}
		catch(Exception e){

		}
	}
	public void mostrarProveedores(String cadena){
		String megaCadena="";
		Proveedor p=new Proveedor();
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Proveedor")){
				p=(Proveedor)personas[i];
				megaCadena=p.getDistribuidora()+p.getNombre()+p.getDireccion()+p.getCorreo()+p.getTelefono()+p.getRfc();
			}
			if(megaCadena.contains(cadena)){
				p.mostrar();
				megaCadena="";
			}
		}

	}

	public void capturarTrabajador(){
		personas[cPersonas]=new Trabajador();
		personas[cPersonas].capturar();
		cPersonas++;
	}
	public void mostrarTrabajadores(){
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Trabajador")){
				personas[i].mostrar();
			}
		}
	}
	public void capturarProveedor(){
		personas[cPersonas]=new Proveedor();
		System.out.println("--------CAPTURA EL PROVEEDOR-------");
		personas[cPersonas].capturar();
		System.out.println("-----------------------------------");
		cPersonas++;
	}
	public void mostrarProveedores(){
		int cont=0;
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Proveedor")){
				cont++;
				System.out.println("-------PROVEEDOR "+cont+"-------");
				personas[i].mostrar();
				System.out.println("--------------------------------");
			}
		}
	}
	public void mostrarClientes(){
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Cliente")){
				personas[i].mostrar();
			}
		}
	}
	public void capturarCliente(){
		personas[cPersonas]=new Cliente();
		personas[cPersonas].capturar();
		cPersonas++;
	}
	public String getRfc(){
		return rfc;
	}
	public void setRfc(String rfc){
		this.rfc=rfc;
	}
	public String getTelefono(){
		return telefono;
	}
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	public String getPaginaWeb(){
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb){
		this.paginaWeb=paginaWeb;
	}
}
