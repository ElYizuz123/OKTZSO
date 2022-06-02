import java.util.Scanner;
public class Servicio extends Producto{
	private String cuentaReceptora;
	private String telefono;
	private int tipoServicio;
	private int servicioPagar;
	private double dinero;
	
	public Servicio(String cuentaReceptora, String telefono, int tipoServicio, int tipoPago, String numeroTarjeta, double dinero) {
        super(tipoPago, numeroTarjeta);
        this.cuentaReceptora=cuentaReceptora;
        this.telefono=telefono;
        this.tipoServicio=tipoServicio;
		this.dinero=dinero;
    }
	public Servicio(){
		
	}
	
	public String queSoy(){
		return "Servicio";
	}
	
	public void mostrar(){
		
	}
	@Override
	public void capturar(){
		Scanner leer=new Scanner(System.in);
		System.out.println("ELIGE EL SERVICIO  1.- RECARGA      2.- PAGO     3.-DEPOSITO");
		tipoServicio=leer.nextInt();leer.nextLine();
		
		switch(tipoServicio){
			case 1: System.out.print("\nTelefono: "); 
					telefono=leer.nextLine();
					System.out.print("\nSaldo: "); 
					dinero=leer.nextDouble();
					break;
			
			case 2: System.out.println("\nELIGE EL SERVICIO A PAGAR\n1.- MEGACABLE  2.- TOTALPLAY  3.- SKY");
					System.out.print("Opcion: "); 
					servicioPagar=leer.nextInt();
					System.out.print("\nCantidad a pagar: "); 
					dinero=leer.nextDouble();
					break;
			
			case 3:
					System.out.print("\nReferencia: ");
					cuentaReceptora=leer.nextLine();
					System.out.print("\nDeposito: "); 
					dinero=leer.nextDouble();
					break; 
		}
		super.capturar();
	}
	
	public double getDinero(){
        return dinero;
    }
    public void setDinero(double dinero){
        this.dinero=dinero;
    }
    public String getCuentaReceptora(){
        return cuentaReceptora;
    }
    public void setCuentaReceptora(String cuentaReceptora){
        this.cuentaReceptora=cuentaReceptora;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public int getTipoServicio(){
        return tipoServicio;
    }
    public void setTipoServicio(int tipoServicio){
        this.tipoServicio=tipoServicio;
    }
	public int getServicioPagar(){
        return servicioPagar;
    }
    public void setServicioPagar(int servicioPagar){
        this.servicioPagar=servicioPagar;
    }
	
}