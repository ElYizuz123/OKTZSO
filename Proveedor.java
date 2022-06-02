import java.util.Scanner;
public class Proveedor extends Persona{
	public String distribuidora;
	private String rfc;
	public Proveedor(){	
	}
	public Proveedor(String distribuidora, String nombre, String direccion, String correo, String telefono, String rfc){
		super( nombre,  direccion, correo, telefono);
		this.distribuidora=distribuidora;
		this.rfc=rfc;
	}
	@Override
	public String queSoy(){
		return "Proveedor";
	}
	@Override
	public void capturar(){
		Scanner leer=new Scanner(System.in);
		super.capturar();
		System.out.print("Distribuidora: ");distribuidora=leer.nextLine();
	}
	@Override
	public void mostrar(){
		super.mostrar();
		System.out.println("Distribuidoras: "+distribuidora);
	}
	
	
	
	public String distribuidora(){
		return distribuidora;
	}
	public void distribuidora(String distribuidora){
		this.distribuidora=distribuidora;
	}
	public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}