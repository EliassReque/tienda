
package base;

import java.util.*;
import base.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import util.Color;



public  class menu {
   
    
    public static void main(String[] args) {
        InputMenu();
        
    }
   
    
    public static void InputMenu(){
	
        display_menu();
        Scanner scan1 = new Scanner(System.in);
       
	switch (scan1.nextInt())
	{
	    case 1:
	    opcion1();//mmenu pedido
	    break;
  
	    case 2:
	    opcion2();//modificar producto
	    break;
  
	    case 3:
	    opcion3();//cambiar contraseña
            
	    break;
            
            case 4:
	    opcion4();//cerrar sesión
            break;
            
	    default:
	    System.err.println ( "Unrecognized option" );
            InputMenu();
	    break;
	}
        
    }
    
    public static void display_menu(){
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("Menu principal:");
	System.out.println(" 1. Hacer pedido\n"
                         + " 2. Modificar producto\n"
                         + " 3. Cambiar contraseña\n"
                         + " 4. Cerrar cesión");
        System.out.println("--------------------------");
        System.out.println("Selection: ");
    }
    
    public  static void opcion1(){
        // TODO Auto-generated method stub
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
 
		while(keepGoing){
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
				System.out.println("Escoge valor entre 1 y el 4");
			}
			else
			{
				switch (option)
				{
				case 1:
                                        leerArchivo();
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
                                        break;
                                       
				case 2:
					//Total cesta
					for (int i = 0; i<intList.size(); i++)
					{
						item = intList.get(i);
						total = total + item.intValue();
					}
					System.out.println("El valor total de la cesta es "+ total + "$");
					
					break;
				case 3:
					
					System.out.println(intList);
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
					break;        
				}
			}
		}
                InputMenu();
    }
    public static void opcion2(){
        //modificar producto
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("Menu modificar producto:");
	System.out.println(" 2.1 Modificar nombre producto\n"
                         + " 2.2 Modificar precio de producto\n"
                         + " 2.3 Modificar codigo de producto");
        System.out.println("--------------------------");
        System.out.println("Selection: ");
	Scanner scan = new Scanner(System.in);
       
	switch (scan.nextInt()) 
	{
	    case 1:
	    System.out.println ("");
                
	    break;
  
	    case 2:
	    System.out.println ("");
            InputMenu();
	    break;
            
            case 3:
	    System.out.println ("");
	    break;
            
            
	    default:
	    System.err.println ( "Unrecognized option" );
	    break;
	}
    }
    public static void opcion3(){
        //cambiar contraseña
    }
    public static void opcion4(){
        //salir de la tienda
        System.exit(0);
    }
    private static void borrarPantalla() {//no funciona en windows
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    
    //Lee el archivo productos
    public static void leerArchivo(){
        String myFile = "productos.txt";
        Path path = Paths.get(myFile);
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRANCE);
       // List<Producto> productos = new ArrayList<>();
        try(BufferedReader archivo = Files.newBufferedReader(path))
        {
            System.out.println("Codigo    Nombre                        Precio");
            while(archivo.readLine() != null)
            {
                
                //Codigo
                archivo.readLine();
               String  lineaDato = archivo.readLine().trim();
                Number numero = formatoNumero.parse(lineaDato);
                int codigo = numero.intValue();
                //System.out.println(codigo + "");

                //Nombre
                archivo.readLine();
                 lineaDato = archivo.readLine().trim();
                String nombre = lineaDato;
                //System.out.print(nombre +"");

                //Descripcion
                archivo.readLine();
                lineaDato = archivo.readLine().trim();
                String descripcion = lineaDato;
                //System.out.print(descripcion+ "");

                //Precio
                archivo.readLine();
                lineaDato = archivo.readLine().trim();
                numero = formatoNumero.parse(lineaDato);
                double precio = numero.doubleValue();
                //System.out.print(precio+ "");
                System.out.println("" + codigo + "       " + nombre  + "       " +precio);
                
                
                //Añadir producto
                //productos.add(new Producto(codigo, nombre, descripcion, precio));
            }
            System.out.println("");
        }
        catch (ParseException ex)
        {
           // System.out.println("Error de formato en " + archivoProductos);
            System.out.println("Error 1");
            System.exit(1);
        }
        catch (IOException ex)
        {
            System.out.println("Error 2" + ex);
           // System.out.println("Error de lectura en " + archivoProductos);
            System.exit(1);
        }
        
        
         
    }
    
    
}

