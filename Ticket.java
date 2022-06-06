import java.util.Scanner;
public class Ticket extends DatosTicket{
	private String rfcTrabajador;
	public Detalle detalles[]=new Detalle[20];
	public int cDetalles=0;
	public double ventaProductos;
	private int tipoPago;
	private String numeroTarjeta;

	public Ticket(String rfcTrabajador, String fecha, String hora, double total, double subTotal, double ivaTotal, int folio){
		super(fecha, hora, total, subTotal, ivaTotal, folio);
		this.rfcTrabajador=rfcTrabajador;
	}

	public Ticket(){

	}
	public void mostrar(){
		System.out.println("\n----------------TICKET-----------------");
		super.mostrarFecha();
		System.out.println("RFC TRABAJADOR: "+rfcTrabajador+"\n");
		for(int i=0; i<cDetalles; i++){
			if(detalles[i].getTipoServicio2().equals("Compra de producto")){
				detalles[i].mostrar(true);
			}
			else{
				detalles[i].mostrar(false);
			}
		}
		super.mostrar();
		switch(tipoPago){
			case 1: System.out.println("\nEFECTIVO M.N");
			break;

			case 2: System.out.println("\nPAGO ELECTRONICO");
			break;
		}
		System.out.println("---------------------------------------");
	}
	public void capturar(Inventario inv){
		Scanner ent=new Scanner(System.in);
		Detalle det=new Detalle();
		System.out.print("\nRFC DEL TRABAJADOR: ");rfcTrabajador=ent.nextLine();
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
			System.out.println("\n1.- NUEVA VENTA      2.-SALIR");
			System.out.print("Opcion: ");
			detalle=ent.nextInt();ent.nextLine();
		} while(detalle!=2);
		System.out.print("\nTIPO DE PAGO\n1.- EFECTIVO   2.- TARJETA\n");
		System.out.print("Opcion: ");
		tipoPago=ent.nextInt();ent.nextLine();
		if(tipoPago==2){
			System.out.print("\nNUMERO DE TARJETA: ");
			numeroTarjeta=ent.nextLine();
		}
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
}
