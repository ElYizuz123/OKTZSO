import java.util.Scanner;
public class Detalle {
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


	public Detalle(int tipoServicio, String idProducto, double precio,int cantidad){
		this.tipoServicio=tipoServicio;
		this.idProducto=idProducto;
		this.precio=precio;
	}

	public Detalle(){}

	public void mostrar(){
		System.out.println("----------VENTA----------");
		System.out.println("Tipo de Servicio: "+tipoServicio2);
		if(tipoServicio==1){
			System.out.println(idProducto+" ("+cantidadP+")"+" ----------- "+total);
		}
		else if(tipoServicio==2){
			switch(tipoServicioI){
				case 1:
					System.out.println("Telefono "+telefono);
					System.out.println("Monto: "+dinero);
				break;
				case 2:
					System.out.println("Servicio a pagar: "+servicioPagar);
					System.out.println("Monto: "+dinero);
				break;
				case 3:
					System.out.println("Cuenta receptora: "+cuentaReceptora);
					System.out.println("Monto: "+dinero);
				break;
			}
		}


	}
	public String queSoy(){
		return "Detalle";
	}
	public void capturar(){
		Abarrote ab=new Abarrote();
		Servicio ser=new Servicio();
		System.out.println("\n----------CAPTURA LA VENTA-----------");
		Scanner dato=new Scanner(System.in);
		System.out.println("\n1.-ABARROTE     2.-SERVICIO");
		System.out.print("Opcion: "); tipoServicio=dato.nextInt();
		if(tipoServicio==1){
			ab.capturar();
			idProducto=ab.getIdProductoComprado();
			precio=ab.getPrecio();
			cantidadP=ab.getCantidad();
			total=ab.getTotal();
			tipoServicio2="Compra de producto";
		}
		else{
			ser.capturar();
			switch(ser.getTipoServicio()){
				case 1:	tipoServicio2="Recarga telefonica";
								tipoServicioI=1;
								telefono=ser.getTelefono();
								dinero=ser.getTotal();
								total=dinero;
								break;

				case 2: tipoServicio2="Servicio a pagar";
								dinero=ser.getTotal();
								total=dinero;
								tipoServicioI=2;
								switch(ser.getServicioPagar()){
									case 1: servicioPagar = "Megacable";
													break;

									case 2:	servicioPagar = "TotalPlay";
													break;

									case 3:	servicioPagar = "Sky";
													break;
								}
								total=dinero;
								break;

				case 3: tipoServicio2="Deposito";
								tipoServicioI=3;
								cuentaReceptora=ser.getCuentaReceptora();
								dinero=ser.getTotal();
								total=dinero;
								break;
			}
		}

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
