import java.util.Scanner;
import java.io.Serializable;
public class Servicio implements Serializable{
	private String cuentaReceptora;
	private String telefono;
	private int tipoServicio;
	private int servicioPagar;
	private String nombreServicio;
	private double total;

	public Servicio(String cuentaReceptora, String telefono, int tipoServicio, int tipoPago) {
        this.total=total;
        this.cuentaReceptora=cuentaReceptora;
        this.telefono=telefono;
        this.tipoServicio=tipoServicio;
    }
	public Servicio(){

	}

	public String queSoy(){
		return "Servicio";
	}

	public void mostrar(){
		switch(tipoServicio){
			
		}
		System.out.println(nombreServicio+"              "+total);
	}
	public void capturar(){
		Scanner leer=new Scanner(System.in);
		System.out.println("\n1.- RECARGA      2.- PAGO     3.-DEPOSITO");
		System.out.print("Opcion: ");
		tipoServicio=leer.nextInt();leer.nextLine();

		switch(tipoServicio){
			case 1: System.out.print("\nTELEFONO: ");
							telefono=leer.nextLine();
							System.out.print("SALDO: $");
							total=leer.nextDouble();
							nombreServicio="RECARGA TELEFONICA";
							break;

			case 2: System.out.println("\n1.- MEGACABLE  2.- TOTALPLAY  3.- SKY");
							System.out.print("Opcion: ");
							servicioPagar=leer.nextInt();
							switch(servicioPagar){
								case 1: nombreServicio="SERVICIO MEGACABLE"; break;
								case 2: nombreServicio="SERVICIO TOTALPLAY"; break;
								case 3: nombreServicio="SERVICIO SKY"; break;
							}
							System.out.print("\nCANTIDAD A PAGAR: $");
							total=leer.nextDouble();
							break;

			case 3: System.out.print("\nREFERENCIA: ");
							cuentaReceptora=leer.nextLine();
							System.out.print("MONTO: $");
							total=leer.nextDouble();
							nombreServicio="DEPOSITO BANCARIO";
							break;
		}
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
		public double getTotal(){
			return total;
		}
		public void setTotal(double total){
			this.total=total;
		}

}
