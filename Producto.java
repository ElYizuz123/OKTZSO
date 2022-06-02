import java.util.Scanner;
public abstract class Producto implements Interface{
	protected int tipoPago;
	protected String numeroTarjeta;
	
	public Producto(int tipoPago, String numeroTarjeta){
        this.tipoPago = tipoPago;
		this.numeroTarjeta = numeroTarjeta;
    }
	public Producto(){
		
	}
	public abstract String queSoy();
	
	
	public void capturar(){
		Scanner leer=new Scanner(System.in);
		System.out.print("ELIGE EL TIPO DE PAGO\n1.- EFECTIVO   2.- TARJETA\n");
		System.out.print("Opcion: "); 
		tipoPago=leer.nextInt();leer.nextLine();
		if(tipoPago==2){
			if(numeroTarjeta==null){
				System.out.print("Numero de tarjeta: ");
				numeroTarjeta=leer.nextLine();
			}
		}
		
		
		
	}
	public void mostrar(){
		switch(tipoPago){
			case 1: System.out.print("Tipo de pago: EFECTIVO");
			break;
			
			case 2: System.out.print("Tipo de pago: TARJETA");
			break;
		}
	}
    public int getTipoPago(){
        return tipoPago;
    }
    public void setTipoPago(int tipoPago){
        this.tipoPago=tipoPago;
    }
	
}