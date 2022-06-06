
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
	@Override
	public void mostrar(){
		System.out.println("\n----------------COMPRA-----------------");
		super.mostrarFecha();
		System.out.println("RFC del proveedor: "+rfcProveedor);
		for(int i=0; i<cDetallesc; i++){
				detallesc[i].mostrar();
		}
		super.mostrar();
		System.out.println("---------------------------------------");
	}
	
	public void capturar(Inventario inv, int cVentas){
		Scanner ent=new Scanner(System.in);
		System.out.print("\nRFC DEL PROVEEDOR: ");rfcProveedor=ent.nextLine();
		int op=5;
		do{
			detallesc[cDetallesc]=new DetalleC(); 
			detallesc[cDetallesc].capturar(inv);
			super.setSubTotal(detallesc[cDetallesc].getTotal());
			super.sumarSubTotales();
			super.setSumarIva(detallesc[cDetallesc].getTotal());
			super.sumarIvas();
			cDetallesc++;
			System.out.print("Desea Realizar Otra Compra	1.- Si || 2.-No: ");
			op=ent.nextInt();
		}while(op!=2);
		super.capturar(cVentas);
	}

	
	public String getRfcProveedor(){
		return rfcProveedor;
	}
	public void setRfcProveedor(String rfcProveedor){
		this.rfcProveedor=rfcProveedor;
	}
}