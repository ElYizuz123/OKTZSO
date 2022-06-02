import java.util.Scanner;
public class Cliente extends Persona{
	private char sexo;
	private String id;
	private String inscripcion;
	
	public Cliente(){
		
	}
	public Cliente(char sexo, String id, String inscripcion, String nombre, String direccion, String correo, String telefono){
		super(nombre, direccion, correo, telefono);
		this.sexo=sexo;
		this.id=id;
		this.inscripcion=inscripcion;
		
	}
	@Override
	public void mostrar(){
		System.out.println("Sexo: "+sexo);
		System.out.println("ID: "+id);
		System.out.println("Inscripcion: "+inscripcion);
		super.mostrar();
	}
	@Override
	public void capturar(){
		Scanner ent=new Scanner(System.in);
		super.capturar();
		System.out.print("Sexo: ");sexo=ent.nextLine().charAt(0);
		System.out.print("ID: ");id=ent.nextLine();
		System.out.print("Inscripcion: ");inscripcion=ent.nextLine();
	}
	public String queSoy(){
		return "Cliente";
	}
	
	public char getSexo(){
		return sexo;
	}
	public void setSexo(char sexo){
		this.sexo=sexo;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getInscripcion(){
		return inscripcion;
	}
	public void setInscripcion(String inscripcion){
		this.inscripcion=inscripcion;
	}
	
}