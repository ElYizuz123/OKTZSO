import java.util.Scanner;
import java.io.Serializable;
public abstract class Persona implements Interface, Serializable{
	protected String nombre;
	protected String direccion;
	protected String correo;
	protected String telefono;
	
	public Persona(){
	}
	
	public Persona(String nombre, String direccion, String correo, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }
	
	public abstract String queSoy();
	public void capturar(){
		Scanner leer= new Scanner(System.in);
		System.out.print("Nombre: ");nombre=leer.nextLine();
		System.out.print("Correo: ");correo=leer.nextLine();
		System.out.print("Telefono: ");telefono=leer.nextLine();
		System.out.print("Direccion: ");direccion=leer.nextLine();
	}
	public void mostrar(){
		System.out.println("Nombre: "+nombre);
		System.out.println("Correo: "+correo);
		System.out.println("Telefono: "+telefono);
		System.out.println("Direccion: "+direccion);
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}