import java.io.Serializable;
import java.util.Scanner;
public class Detalle implements Interface, Serializable{
	private int tipoServicio;
	private String idProducto;
	private double precio;
	private int cantidadP;
	private String cuentaReceptora;
	private String telefono;
	private String tipoServicio2;
	private int tipoServicioI;
	private String servicioPagar;
	private double dinero;
	private double total;
	private String nombreProducto;

	Abarrote ab=new Abarrote();
  Servicio ser=new Servicio();

	public Detalle(int tipoServicio, String idProducto, double precio,int cantidad){
		this.tipoServicio=tipoServicio;
		this.idProducto=idProducto;
		this.precio=precio;
	}

	public Detalle(){}
	public void mostrar(){}

	public void mostrar(boolean tipo){
		if(tipo){
			ab.mostrar();
		}
		else{
			ser.mostrar();
		}
	}
	public void mostrarServ(){
		ser.mostrarServicio();
	}

	public String queSoy(){
		return "Detalle";
	}
	public void capturar(){

	}
	public void capturar(Inventario inv){
		Scanner dato=new Scanner(System.in);
		System.out.println("\n1.-ABARROTE    ||    2.-SERVICIO");
		System.out.print("Opcion: "); tipoServicio=dato.nextInt();
		if(tipoServicio==1){
			ab.capturar(inv);
			idProducto=ab.getIdProductoComprado();
			nombreProducto=getNombreProducto();
			precio=ab.getPrecio();
			cantidadP=ab.getCantidad();
			total=ab.getTotal();
			tipoServicio2="Compra de producto";
		}
		else{
			ser.capturar();
			switch(ser.getTipoServicio()){
				case 1:	tipoServicio2="RECARGA TELEFONICA";
								tipoServicioI=1;
								telefono=ser.getTelefono();
								dinero=ser.getTotal();
								total=dinero;
								break;

				case 2: tipoServicio2="SERVICIO";
								dinero=ser.getTotal();
								total=dinero;
								tipoServicioI=2;
								switch(ser.getServicioPagar()){
									case 1: servicioPagar = "MEGACABLE";
													break;

									case 2:	servicioPagar = "TOTALPLAY";
													break;

									case 3:	servicioPagar = "SKY";
													break;
								}
								total=dinero;
								break;

				case 3: tipoServicio2="DEPOSITO";
								tipoServicioI=3;
								cuentaReceptora=ser.getCuentaReceptora();
								dinero=ser.getTotal();
								total=dinero;
								break;
			}
		}

	}

	public String getNombreProducto(){
		return nombreProducto;
	}
	public int getCantidadP(){
        return cantidadP;
  }
  public void setCantidadP(int cantidadP){
        this.cantidadP=cantidadP;
  }
	public String getTipoServicio2(){
		return tipoServicio2;
	}
	public void setTipoServicio2(String tipoServicio2){
		this.tipoServicio2 = tipoServicio2;
	}
	public int getTipoServicio(){
		return tipoServicio;
	}
	public void setTipoServicio(int tipoServicio){
		this.tipoServicio = tipoServicio;
	}
	public String getIdProducto(){
		return idProducto;
	}
	public void setIdProducto(String idProducto){
		this.idProducto = idProducto;
	}
	public double getPrecio(){
		return precio;
	}
	public void setPrecio(double precio){
		this.precio = precio;
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
  public String getServicioPagar(){
        return servicioPagar;
  }
  public void setServicioPagar(String servicioPagar){
        this.servicioPagar=servicioPagar;
  }
	public double getTotal(){
		return total;
	}
	public void setTotal(double total){
		this.total=total;
	}
}
