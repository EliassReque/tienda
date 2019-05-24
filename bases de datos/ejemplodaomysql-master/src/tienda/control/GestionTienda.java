package tienda.control;

import empleado.control.GestionaEmpleados;
import empleado.dominio.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import producto.dominio.Producto;
import tienda.vista.VistaTienda;
import util.Color;

public class GestionTienda {
    
		ArrayList<Integer> codigoProducto = new ArrayList<Integer>();
		ArrayList<String> descripcionProducto = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
                Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		int option = 0;
		//int input = 0;
		int index=0;
		int total = 0;
                String salidaNombre;
		Integer item;

    private Empleado empleadoAutenticado;
    private List<Producto> cesta;
    GestionaEmpleados gestionaEmpleados;

    public GestionTienda() {
        empleadoAutenticado = null;
        cesta = new ArrayList<>();
        gestionaEmpleados = new GestionaEmpleados();
    }

    public void iniciar() {
        boolean esLoginCorrecto = false;
        while (!esLoginCorrecto) {
            try {
                gestionaEmpleados.login();
                esLoginCorrecto = true;
            } catch (Exception e) {
            }
        }

        empleadoAutenticado = gestionaEmpleados.getEmpleadoAutenticado();
        VistaTienda.mensajeBienvenida(empleadoAutenticado);

        menuPrincipal();
    }
    public void menuPrincipal(){
        switch (VistaTienda.opcionDesdeMenuPrincipal()) {
            case HACER_PEDIDO:
                //hacerPedido
                hacerPedido();
                break;
            case MODIFICAR_PRODUCTO:
                // modificarProducto
                break;
            case CAMBIAR_PASSWORD:
                // cambiarPassword
                break;
            case CERRAR_SESION:
                // cerrarSesion
                iniciar();
                break;
        }
    }
    
    public void hacerPedido(){
        
                        System.out.println("--------------------------");
			System.out.println("Menu de pedido");
			System.out.println(" 1.1 Añadir producto a la cesta");//yes
			
			System.out.println(" 1.2 Visualizar precio total cesta");
			System.out.println(" 1.3 Precios en la cesta ");//yes
			System.out.println(" 1.5 Imprimir factura");
			System.out.println(" 1.4 Terminar pedido");
                        System.out.println("--------------------------");
			System.out.println(Color.CONFIRM + "Select option --> " + Color.DEFAULT);
			option = scan.nextInt();
			if (option <1 || option >5)
			{
				System.out.println("Escoge valor entre 1 y el 5");
			}
			else
			{
				switch (option)
				{
				case 1:
                                    
                                    conexion.opraciones.bases();
                                        //leerArchivo();
                                        //System.out.println("Introduce el nombre del producto que desea -->");
                                        //salidaNombre = scan.nextLine();
					//introducir precio producto
                                        System.out.println("Introduce codigo del producto ");
                                        System.out.print("--> ");
                                        int codigo = scan.nextInt();
                                        codigoProducto.add(codigo);
                                        
                                        System.out.println("Introduce nombre del producto");
                                        System.out.print("--> ");
                                        String nameProduct;
                                         nameProduct = scan.next();
                                        descripcionProducto.add(nameProduct);
                                        
					System.out.println("Introduce precio del producto");
                                        System.out.print("--> ");
					double input = scan.nextDouble();
                                        int valor = (int)input;
					item =valor;
					intList.add(item);
                                        hacerPedido();
                                        break;
                                       
				case 2:
					//Total cesta
					for (int i = 0; i<intList.size(); i++)
					{
						item = intList.get(i);
						total = total + item.intValue();
					}
					System.out.println("El valor total de la cesta es "+ total + "$");
					hacerPedido();
					break;
				case 3:
					
					System.out.println(intList);
                                        hacerPedido();
					break;
                                        
				case 4:
					//exit
					keepGoing = false;
					System.out.println("Gracias por la compra");
					break;
                                        
                                case 5:
                                        System.out.println("Factura simplificada:");
                                        System.out.println("-------------------------------------------------------------");
					for (int i = 0; i<intList.size(); i++)
					{//+ " " + descripcionProducto.get(i)+ " " + intList.get(i));
					    
                                            System.out.println("Código:"+ "    " +codigoProducto.get(i));
                                            System.out.println("Descripción:"+ " " +descripcionProducto.get(i));
                                            System.out.println("Precio:"+ "    " +intList.get(i));
                                            System.out.println(" ");
					}
                                        System.out.println("-------------------------------------------------------------");
					hacerPedido();
                                        break;
                                        
				}
			}
                        menuPrincipal();
        
    }
    
    public void seguirComprando(){
        
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Desea seguir comprando(1 = yes / 2 = no)");
        System.out.print("--> ");
        int respuesta = scan2.nextInt();
        
        if(respuesta ==1){
            hacerPedido();
        }else if (respuesta == 2){
            System.out.println("Gracias por haber comprado!!");
            System.out.println("");
            codigoProducto.removeAll(codigoProducto);
            descripcionProducto.removeAll(descripcionProducto);
            intList.removeAll(intList);
            menuPrincipal();
            
        }else{
            System.exit(0);
        }
        
        
    }

}
