import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class DatosTicket{
	protected String fecha;
	protected String hora;
	protected double total;
	protected double ivaTotal;
	protected double subTotal;
	protected int folio;
	protected double sumarIva;
	
	DateTimeFormatter forFecha = DateTimeFormatter.ofPattern("dd-MM-yyy");
	DateTimeFormatter forHora = DateTimeFormatter.ofPattern("HH:mm");
	
	public DatosTicket(String fecha, String hora, double total, double subTotal, double ivaTotal, int folio){
	this.fecha=fecha;
	this.hora=hora;
	this.total=total;
	this.subTotal=subTotal;
	this.ivaTotal=ivaTotal;
	this.folio=folio;

	}

	public DatosTicket(){

	}

	protected void mostrar(){
		LocalDateTime tiempo = LocalDateTime.now();
		String fecha = tiempo.format(forFecha);
		String hora = tiempo.format(forHora);
		
		System.out.print("\nFOLIO DE VENTA: "+folio);
		System.out.println("      TOTAL: $"+total);
		System.out.print("IVA INCLUIDO: $"+ivaTotal);
		System.out.println("\nFecha      : "+fecha);
		System.out.println("Hora       : "+hora);
	}
	protected void capturar(){
		ivaTotal=sumarIva*0.16;
		total=subTotal+ivaTotal;
	}
	protected void sumarIvas(){
		ivaTotal+=sumarIva;
	}
	protected void sumarSubtotales(){
		total+=subTotal;
	}
	protected String getFecha(){
		return fecha;
	}
	protected double getSubTotal(){
		return subTotal;
	}
	protected void setSubTotal(double subTotal){
		this.subTotal=subTotal;
	}
	protected void setFecha(String fecha){
		this.fecha=fecha;
	}
	protected String getHora(){
		return hora;
	}
	protected void setHora(String hora){
		this.hora=hora;
	}
	protected double getTotal(){
		return total;
	}
	protected void setTotal(double total){
		this.total=total;
	}
	protected double getIvaTotal(){
		return ivaTotal;
	}
	protected void setIvaTotal(double ivaTotal){
		this.ivaTotal=ivaTotal;
	}
	protected int getFolio(){
		return folio;
	}
	protected void setFolio(int folio){
		this.folio=folio;
	}
	protected double getSumarIva(){
		return sumarIva;
	}
	protected void setSumarIva(double sumarIva){
		this.sumarIva=sumarIva;
	}
}
