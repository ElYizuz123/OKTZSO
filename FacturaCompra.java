
import java.util.Scanner;
public class FacturaCompra extends DatosTicket{
	private String rfcProveedor;
	public DetalleC detallesc[]=new DetalleC[20];
	public int cDetallesc=0;
	private boolean buscador=false;

	public FacturaCompra(String rfcProveedor, String fecha, String hora, double total, double subTotal, double ivaTotal, int folio){
		super(fecha, hora, total, subTotal, ivaTotal, folio);
		this.rfcProveedor=rfcProveedor;
	}
	public void buscarDetalles(String cadena){
		String megaCadena="";
		DetalleC p=new DetalleC();
		for(int i=0; i<cDetallesc; i++){
			p=detallesc[i];
			megaCadena=p.getIdProducto()+p.getCosto()+p.getCantidad()+p.getTotal()+p.getNombreP();
			if(megaCadena.contains(cadena)){
				buscador=true;
				break;
			}
			megaCadena="";
			buscador=false;
		}
	}
	public FacturaCompra(){

	}
	@Override
	public void mostrar(){
		System.out.println("\n------------------COMPRA-------------------");
		super.mostrarFecha();
		System.out.println("RFC PROVEEDOR: "+rfcProveedor+"\n");
		for(int i=0; i<cDetallesc; i++){
				detallesc[i].mostrar();
		}
		super.mostrar();
		System.out.println("-------------------------------------------");
	}
	
	public void capturar(Inventario inv, int cVentas){
		Scanner ent=new Scanner(System.in);
		System.out.println("\n-----------CAPTURA LA COMPRA-----------");
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
			System.out.println("\n1.- NUEVA COMPRA || 2.- SALIR ");
			System.out.print("Opcion: ");
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
	public boolean getBuscador(){
		return buscador;
	}
}
