import java.util.Scanner;
public class Ap{
	public static void main(String args[]){
		int dato2;
		System.out.println("BIENVENIDOS");
		System.out.println("\"Para todas tus reuniones OXXO\"");
		Oxxo okzo = new Oxxo("NHB770831BW3", "8183202020", "https://www.oxxo.com");
		do{
			dato2=mostrarMenu();
			switch(dato2){
				case 1: okzo.mostrarTrabajadores(); break;
				case 2: okzo.capturarTrabajador(); break;
				case 3: //okzo.buscarTrabajador(); break;
				case 4: okzo.editarTrabajador(); break;
				case 11: okzo.mostrarProveedores(); break;
				case 12: okzo.capturarProveedor(); break;
				case 13: //okzo.buscarProveedor(); break;
				case 14: okzo.editarProveedor(); break;
				case 21: okzo.mostrarProveedores(); break;
				case 31: okzo.mostrarClientes(); break;
				case 32: okzo.capturarCliente(); break;
				case 34: okzo.editarCliente(); break;
				case 42:okzo.capturarVenta(); break;
				case 41:okzo.mostrarVentas(); break;
			}
		}while(dato2!=0);
		okzo.guardarProveedor();
		okzo.guardarCliente();
		okzo.guardarTrabajador();
	}
	public static int mostrarMenu(){
		Scanner leer=new Scanner(System.in);
		int dato=0;
		System.out.println("\n1.- GERENTE      2.-TRABAJADOR      3.-SALIR");
		System.out.print("Opcion: ");dato=leer.nextInt();
		switch(dato){
			case 1:
				System.out.println("\n1.-TRABAJADORES       2.-PROVEEDORES      3.-SALIR");
				System.out.print("Opcion: ");dato=leer.nextInt();
				if(dato==1){
					System.out.println("\n1.-MOSTRAR       2.-CAPTURAR     3.-BUSCAR     4.-ELIMINAR     5.-SALIR");
					System.out.print("Opcion: ");dato=leer.nextInt();
					return dato;
				}
				else if(dato==2){
					System.out.println("\n1.-MOSTRAR       2.-CAPTURAR     3.-BUSCAR     4.-ELIMINAR     5.-SALIR");
					System.out.print("Opcion: ");dato=leer.nextInt()+10;
					return dato;
				}
				else if(dato==3){
					return 0;
				}
			break;
			case 2:
			System.out.println("\n1.-MOSTRAR PROVEEDORES     2.-CLIENTES      3.-VENTA       4.-SALIR");
			System.out.print("Opcion: "); dato=leer.nextInt();
			if(dato==1){
				return dato+20;
			}
			if(dato==2){
				System.out.println("\n1.-MOSTRAR       2.-CAPTURAR     3.-BUSCAR     4.-ELIMINAR     5.-SALIR");
					System.out.print("Opcion: ");dato=leer.nextInt();
					return dato+30;
			}
			else if(dato==3){
				System.out.println("\n1.-MOSTRAR      2.-CAPTURAR");
				System.out.print("Opcion: ");
				return 40+leer.nextInt();
			}
			break;
			case 3:

			break;
		}
		return 0;
	}
}
