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
		System.out.println("RFC del trabajador que le atendio: "+rfcTrabajador);
		for(int i=0; i<cDetalles; i++){
			detalles[i].mostrar();
		}
		super.mostrar();
		switch(tipoPago){
			case 1: System.out.println("Tipo de pago: EFECTIVO");
			break;

			case 2: System.out.println("Tipo de pago: TARJETA");
			break;
		}

	}
	public void capturar(){
		Scanner ent=new Scanner(System.in);
		Detalle det=new Detalle();
		System.out.print("RFC del trabajador: ");rfcTrabajador=ent.nextLine();
		int detalle=5;
		do{
			detalles[cDetalles]=new Detalle();
			detalles[cDetalles].capturar();
			if(detalles[cDetalles].getTipoServicio2()=="Compra de producto"){
				super.setSumarIva(detalles[cDetalles].getTotal());
				super.sumarIvas();
			}
			super.setSubTotal(detalles[cDetalles].getTotal());
			super.sumarSubtotales();
			cDetalles++;
			System.out.println("1.- NUEVA VENTA      2.-SALIR");
			detalle=ent.nextInt();ent.nextLine();
		}while(detalle!=2);
		System.out.print("TIPO DE PAGO\n1.- EFECTIVO   2.- TARJETA\n");
		System.out.print("Opcion: ");
		tipoPago=ent.nextInt();ent.nextLine();
		if(tipoPago==2){
			System.out.print("Numero de tarjeta: ");
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
