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
		String[] arreglo = new String[36];
		String totalS=String.valueOf(total);
		char c;
		for(int i=0; i<nombreServicio.length(); i++){
			c=nombreServicio.charAt(i);
			arreglo[i]=String.valueOf(c);
		}
		arreglo[35]="$"+totalS;
		for(int i=0; i<36; i++){
			if(arreglo[i]==null)
				arreglo[i]=" ";
			System.out.print(arreglo[i]);
		}
		System.out.println();
	}
	public void mostrarServicio(){
		switch(tipoServicio){
			case 1:
				System.out.println("------------RECARGA TELEFONICA-------------");
				System.out.println("ABONO DE $"+total+" MX");
				System.out.println("AUTORIZACION EN LINEA");
				System.out.println("TELEFONO ABONADO: "+telefono);
				System.out.println("-------------------------------------------");
				break;
			case 3:
				System.out.println("------------DEPOSITO BANCARIO--------------");
				System.out.println("REFERENCIA        : "+cuentaReceptora);
				System.out.println("MONTO             : $"+total);
				System.out.println("COMISION DEL BANCO: $8.62");
				System.out.println("IVA DE COMISION   : $1.38");
				System.out.println("PAGO TOTAL        : $"+(total+10));
				System.out.println("-------------------------------------------");
		}
	}
	public void capturar(){
		Scanner leer=new Scanner(System.in);
		System.out.println("\n1.- RECARGA   ||   2.- PAGO   ||   3.-DEPOSITO");
		System.out.print("Opcion: ");
		tipoServicio=leer.nextInt();leer.nextLine();

		switch(tipoServicio){
			case 1: System.out.print("\nTELEFONO: ");
							telefono=leer.nextLine();
							System.out.print("SALDO: $");
							total=leer.nextDouble();
							nombreServicio="RECARGA TELEFONICA";
							break;

			case 2: System.out.println("\n1.- MEGACABLE   ||   2.- TOTALPLAY   ||   3.- SKY");
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

			case 3: System.out.print("\nCUENTA RECEPTORA: ");
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
