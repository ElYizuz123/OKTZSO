import java.util.Scanner;
public class Trabajador extends Persona{
	private String sexo;
	private String horario;
	private String cuenta;
	private String rfc;
	
	public Trabajador(){	
	}
	public Trabajador(String sexo, String horario, String cuenta, String nombre, String direccion, String correo, String telefono){
		super( nombre,direccion, correo,telefono);
		this.sexo=sexo;
		this.horario=horario;
		this.cuenta=cuenta;
		this.rfc=rfc;
	}
	@Override
	public String queSoy(){
		return "Trabajador";
	}
	@Override
	public void capturar(){
		Scanner leer=new Scanner(System.in);
		super.capturar();
		System.out.print("Sexo: ");sexo=leer.nextLine();
		System.out.print("Horario: ");horario=leer.nextLine();
		System.out.print("Cuenta: ");cuenta=leer.nextLine();
	}
	@Override
	public void mostrar(){
		super.mostrar();
		System.out.println("Sexo: "+sexo);
		System.out.println("Horario: "+horario);
		System.out.println("Cuenta: "+cuenta);
	}
	
	
	public String getSexo(){
		return sexo;
	}
	public void setSexo(String sexo){
		this.sexo=sexo;
	} 
	public String getHorario(){
		return horario;
	}
	public void setHorario(String horario){
		this.horario=horario;
	} 
	public String getCuenta(){
		return cuenta;
	}
	public void setCuenta(String cuenta){
		this.cuenta=cuenta;
	} 
	public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}