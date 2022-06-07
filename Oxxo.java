import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	private FacturaCompra compras[]=new FacturaCompra[10000];
	private int cCompras=0;
	private Inventario inv = new Inventario();
	public String fecha;
	public String hora;
	public Oxxo(){
	}

	public Oxxo(String rfc, String telefono, String paginaWeb){
		this.rfc=rfc;
		this.telefono=telefono;
		this.paginaWeb=paginaWeb;
		cargarProveedores();
		cargarClientes();
		cargarTrabajadores();
		cargarInventario();
		cargarCompras();
		cargarVentas();
	}
	public void guardarVentas(){
		FileOutputStream salidaP=null;
		ObjectOutputStream oP=null;
		try{
			salidaP= new FileOutputStream("Ventas.dat");
			oP= new ObjectOutputStream(salidaP);
			for(int i=0; i<cVentas; i++)
				oP.writeObject(ventas[i]);
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	private void cargarVentas(){
		FileInputStream entradaP=null;
		ObjectInputStream oP=null;
		try{
			entradaP=new FileInputStream ("Ventas.dat");
			oP=new ObjectInputStream(entradaP);
			ventas[cVentas]=(Ticket)oP.readObject();
			while(ventas[cVentas]!=null){
				cVentas++;
				ventas[cVentas]=(Ticket)oP.readObject();
			}
		}
		catch(Exception e){

		}
	}
	public void guardarCompras(){
		FileOutputStream salidaP=null;
		ObjectOutputStream oP=null;
		try{
			salidaP= new FileOutputStream("Compras.dat");
			oP= new ObjectOutputStream(salidaP);
			for(int i=0; i<cCompras; i++)
				oP.writeObject(compras[i]);
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	private void cargarCompras(){
		FileInputStream entradaP=null;
		ObjectInputStream oP=null;
		try{
			entradaP=new FileInputStream ("Compras.dat");
			oP=new ObjectInputStream(entradaP);
			compras[cCompras]=(FacturaCompra)oP.readObject();
			while(compras[cCompras]!=null){
				cCompras++;
				compras[cCompras]=(FacturaCompra)oP.readObject();
			}
		}
		catch(Exception e){

		}
	}
	public void generadorHora(){
		DateTimeFormatter forFecha = DateTimeFormatter.ofPattern("dd/MM/yyy");
		DateTimeFormatter forHora = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime tiempo = LocalDateTime.now();
		fecha = tiempo.format(forFecha);
		hora = tiempo.format(forHora);
	}
	public void mostrarInventario(){
		inv.mostrar();
	}
	public void guardarInventario(){
		inv.guardar();
	}
	public void cargarInventario(){
		inv.cargar();
	}
	public void capturarCompra(){
		compras[cCompras]=new FacturaCompra();
		compras[cCompras].capturar(inv, cCompras);
		compras[cCompras].mostrar();
		cCompras++;
	}
	public void mostrarCompras(){
		for(int i=0; i<cCompras; i++){
			compras[i].mostrar();
		}
	}
	public void capturarVenta(){
		Scanner leer=new Scanner(System.in);
		String espacio;
		ventas[cVentas]=new Ticket();
		ventas[cVentas].capturar(inv, cVentas);
		System.out.print("\nPRESIONE ENTER PARA IMPRIMIR EL TICKET");
		espacio=leer.nextLine();
		ventas[cVentas].mostrar();
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
		int eliminador, cont=0;
		System.out.println("\n-------SELECCIONA EL PROVEEDOR A EDITAR-------");
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Proveedor")){
				cont++;
				System.out.println(cont+".- "+personas[i].getNombre().toUpperCase());
			}
		}
		System.out.println("----------------------------------------------");
		cont=0;
		System.out.print("Opcion: ");
		eliminador=ent.nextInt();
		for(int j=0; j<cPersonas; j++){
			if(personas[j].queSoy().equals("Proveedor")){
				cont++;
				if(eliminador==cont){
					System.out.println("\n-------PROVEEDOR "+cont+"-------");
					personas[j].capturar();
					System.out.println("-----------------------------");
				}
			}
		}
	}
	public void editarTrabajador(){
		Scanner ent=new Scanner(System.in);
		int eliminador, cont=0;
		System.out.println("\n-------SELECCIONA EL TRABAJADOR A EDITAR-------");
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Trabajador")){
				cont++;
				System.out.println(cont+".- "+personas[i].getNombre().toUpperCase());
			}
		}
		System.out.println("-----------------------------------------------");
		cont=0;
		System.out.print("Opcion: ");
		eliminador=ent.nextInt();
		for(int j=0; j<cPersonas; j++){
			if(personas[j].queSoy().equals("Trabajador")){
				cont++;
				if(eliminador==cont){
					System.out.println("\n-------TRABAJADOR "+cont+"-------");
					personas[j].capturar();
					System.out.println("-----------------------------");
				}
			}
		}

	}
	public void editarCliente(){
		Scanner ent=new Scanner(System.in);
		int eliminador, cont=0;
		System.out.println("\n-------SELECCIONA EL CLIENTE A EDITAR-------");
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Cliente")){
				cont++;
				System.out.println(cont+".- "+personas[i].getNombre().toUpperCase());
			}
		}
		System.out.println("--------------------------------------------");
		cont=0;
		System.out.print("Opcion: ");
		eliminador=ent.nextInt();
		for(int j=0; j<cPersonas; j++){
			if(personas[j].queSoy().equals("Cliente")){
				cont++;
				if(eliminador==cont){
					System.out.println("\n-------CLIENTE "+cont+"-------");
					personas[j].capturar();
					System.out.println("-----------------------------");
				}
			}
		}
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
		int cont=0;
		String megaCadena="";
		Proveedor p=new Proveedor();
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Proveedor")){
				cont++;
				p=(Proveedor)personas[i];
				megaCadena=p.getDistribuidora()+p.getNombre()+p.getDireccion()+p.getCorreo()+p.getTelefono()+p.getRfc();
			}
			if(megaCadena.contains(cadena)){
				System.out.println("\n-------PROVEEDOR "+cont+"-------");
				p.mostrar();
				System.out.println("---------------------------------");
			}
			megaCadena="";
		}

	}
	public void mostrarTrabajadores(String cadena){
		int cont=0;
		String megaCadena="";
		Trabajador p=new Trabajador();
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Trabajador")){
				cont++;
				p=(Trabajador)personas[i];
				megaCadena=p.getSexo()+p.getNombre()+p.getDireccion()+p.getCorreo()+p.getTelefono()+p.getRfc()+p.getHorario()+p.getCuenta();
			}
			if(megaCadena.contains(cadena)){
				System.out.println("\n-------TRABAJADOR "+cont+"-------");
				p.mostrar();
				System.out.println("---------------------------------");

			}
			megaCadena="";
		}

	}
	public void mostrarVentas(String cadena){
		int cont=0;
		String megaCadena="";
		Ticket p=new Ticket();
		for(int i=0; i<cVentas; i++){
			cont++;
			p=ventas[i];
			megaCadena=p.getRfcTrabajador()+p.getFecha()+p.getHora()+p.getTotal()+p.getSubTotal()+p.getIvaTotal()+p.getFolio();
			p.buscarDetalles(cadena);
			if(megaCadena.contains(cadena)||p.getBuscador()==true){
				System.out.println("\n-------VENTA "+cont+"-------");
				p.mostrar();
				System.out.println("---------------------------------");
			}
			megaCadena="";
		}


	}
	public void mostrarCompras(String cadena){
		int cont=0;
		String megaCadena;
		FacturaCompra p=new FacturaCompra();
		for(int i=0; i<cCompras; i++){
			cont++;
			p=compras[i];
			megaCadena=p.getRfcProveedor()+p.getFecha()+p.getHora()+p.getTotal()+p.getSubTotal()+p.getIvaTotal()+p.getFolio();
			p.buscarDetalles(cadena);
			if(megaCadena.contains(cadena)||p.getBuscador()==true){
				System.out.println("\n-------VENTA "+cont+"-------");
				compras[i].mostrar();
				System.out.println("---------------------------------");
			}
			megaCadena="";
		}


	}

	public void capturarTrabajador(){
		System.out.println("\n--------CAPTURA EL TRABAJADOR-------");
		personas[cPersonas]=new Trabajador();
		personas[cPersonas].capturar();
		System.out.println("--------------------------------------");
		cPersonas++;
	}
	public void mostrarTrabajadores(){
		int cont=0;
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Trabajador")){
				cont++;
				System.out.println("\n-------TRABAJADOR "+cont+"-------");
				personas[i].mostrar();
				System.out.println("-----------------------------");
			}
		}
	}
	public void capturarProveedor(){
		personas[cPersonas]=new Proveedor();
		System.out.println("\n--------CAPTURA EL PROVEEDOR-------");
		personas[cPersonas].capturar();
		System.out.println("-----------------------------------");
		cPersonas++;
	}
	public void mostrarProveedores(){
		int cont=0;
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Proveedor")){
				cont++;
				System.out.println("\n-------PROVEEDOR "+cont+"-------");
				personas[i].mostrar();
				System.out.println("--------------------------------");
			}
		}
	}
	public void mostrarClientes(){
		int cont=0;
		for(int i=0; i<cPersonas; i++){
			if(personas[i].queSoy().equals("Cliente")){
				cont++;
				System.out.println("\n-------CLIENTE "+cont+"-------");
				personas[i].mostrar();
				System.out.println("--------------------------------");
			}
		}
	}
	public void capturarCliente(){
		System.out.println("\n--------CAPTURA EL CLIENTE-------");
		personas[cPersonas]=new Cliente();
		personas[cPersonas].capturar();
		System.out.println("---------------------------------");
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
