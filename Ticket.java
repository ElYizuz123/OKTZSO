import java.util.Scanner;
public class Ticket extends DatosTicket{
	private String rfcTrabajador;
	public Detalle detalles[]=new Detalle[20];
	public int cDetalles=0;
	public double ventaProductos;
	private int tipoPago;
	private String numeroTarjeta;
	private boolean buscador=false;
	private double cambio;
	private double pago;


	public Ticket(String rfcTrabajador, String fecha, String hora, double total, double subTotal, double ivaTotal, int folio){
		super(fecha, hora, total, subTotal, ivaTotal, folio);
		this.rfcTrabajador=rfcTrabajador;
	}

	public Ticket(){

	}
	public void buscarDetalles(String cadena){
		String megaCadena="";
		Detalle p=new Detalle();
		for(int i=0; i<cDetalles; i++){
			p=detalles[i];
			megaCadena=p.getTipoServicio()+p.getIdProducto()+p.getPrecio()+p.getCantidadP()+p.getCuentaReceptora()+p.getTelefono()+p.getTipoServicio2()+p.getServicioPagar()+p.getDinero()+p.getTotal()+p.getNombreProducto();
			if(megaCadena.contains(cadena)){
				buscador=true;
				break;
			}
			megaCadena="";
			buscador=false;
		}

	}
	public void mostrar(){
		boolean led=false;
		System.out.println("\n------------------TICKET-------------------");
		super.mostrarFecha();
		System.out.println("RFC TRABAJADOR: "+rfcTrabajador+"\n");
		for(int i=0; i<cDetalles; i++){
			if(detalles[i].getTipoServicio2().equals("Compra de producto")){
				detalles[i].mostrar(true);
			}
			else{
				detalles[i].mostrar(false);
				led=true;
			}
		}
		super.mostrar();
		switch(tipoPago){
			case 1: System.out.println("\nEFECTIVO M.N               PAGO:   $"+pago);
							System.out.println("                           CAMBIO: $"+String.format("%.2f", cambio));
			break;

			case 2: System.out.println("\nPAGO ELECTRONICO: $"+String.format("%.2f", super.getTotal()));
							System.out.println("REF: "+numeroTarjeta);
			break;
		}
		System.out.println("\nMUCHAS GRACIAS POR SU COMPRA");
		System.out.println("https://www.oxxo.com");
		System.out.println("4433252790");
		System.out.println("-------------------------------------------\n");
		if(led==true){
			for(int i=0; i<cDetalles; i++){
				detalles[i].mostrarServ();
			}
		}
	}
	public void capturar(Inventario inv, int cCompras){
		Scanner ent=new Scanner(System.in);
		Detalle det=new Detalle();
		System.out.println("\n----------CAPTURA LA VENTA-----------");
		System.out.print("RFC DEL TRABAJADOR: ");rfcTrabajador=ent.nextLine();
		int detalle=0;
		do{
			detalles[cDetalles]=new Detalle();
			detalles[cDetalles].capturar(inv);
			if(detalles[cDetalles].getTipoServicio2()=="Compra de producto"){
				super.setSumarIva(detalles[cDetalles].getTotal());
				super.sumarIvas();
			}
			super.setSubTotal(detalles[cDetalles].getTotal());
			super.sumarSubTotales();
			cDetalles++;
			System.out.println("\n1.- NUEVA VENTA   ||   2.-SALIR");
			System.out.print("Opcion: ");
			detalle=ent.nextInt();ent.nextLine();
		} while(detalle!=2);
		super.capturar(cCompras);
		System.out.println("\n---------------------------------");
		System.out.println("TOTAL: $"+super.getTotal());
		System.out.print("\n1.- EFECTIVO  ||  2.- TARJETA\n");
		System.out.print("Opcion: ");
		tipoPago=ent.nextInt();ent.nextLine();

		if(tipoPago==2){
			System.out.print("\nNUMERO DE TARJETA: ");
			numeroTarjeta=ent.nextLine();
		}
		else{
			System.out.print("\nPAGO: $"); pago=ent.nextDouble();
			while(pago<super.getTotal()){
				System.out.print("INGRESA NUEVAMENTE EL PAGO: $"); pago=ent.nextDouble();
			}
			cambio=pago-super.getTotal();
			System.out.println("CAMBIO: $"+String.format("%.2f", cambio));
		}
		System.out.println("---------------------------------");
	}
	public String getNumeroTarjeta(){
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta){
		this.numeroTarjeta=numeroTarjeta;
	}
	public int getTipoPago(){
		return tipoPago;
	}
	public void setTipoPago(int tipoPago){
		this.tipoPago=tipoPago;
	}
	public double getVentaProductos(){
		return ventaProductos;
	}
	public String getRfcTrabajador(){
		return rfcTrabajador;
	}
	public void setRfcTrabajador(String rfcTrabajador){
		this.rfcTrabajador=rfcTrabajador;
	}
	public Boolean getBuscador(){
		return buscador;
	}
}
