import java.util.Scanner;
public class FacturaCompra extends DatosTicket{
	private String rfcProveedor;
	public DetalleC detallesc[]=new DetalleC[20];
	public int cDetallesc=0;

	public FacturaCompra(String rfcProveedor, String fecha, String hora, double total, double subTotal, double ivaTotal, int folio){
		super(fecha, hora, total, subTotal, ivaTotal, folio);
		this.rfcProveedor=rfcProveedor;
	}

	public FacturaCompra(){

	}
	
	public void mostrar(){
		System.out.println("\n----------------PRODUCTOS-----------------");
		for(int i=0; i<cDetallesc; i++){
				detallesc[i].mostrar();
		}
		super.mostrar();
		System.out.println("---------------------------------------");
	}
	
	public void capturar(){
		Scanner ent=new Scanner(System.in);
		System.out.print("\nRFC DEL PROVEEDOR: ");rfcProveedor=ent.nextLine();
		int op=5;
		do{
			detallesc[cDetallesc]=new DetalleC(); 
			detallesc[cDetallesc].capturar();
			super.setSubTotal(detallesc[cDetallesc].getTotal());
			super.sumarSubTotales();
			cDetalles++;
			System.out.print("Desea Realizar Otra Compra	1.- Si || 2.-No: ");
			op=ent.nextInt();
		}while(op!=2);
	}

	
	public String getRfcTrabajador(){
		return rfcTrabajador;
	}
	public void setRfcTrabajador(String rfcTrabajador){
		this.rfcTrabajador=rfcTrabajador;
	}
}