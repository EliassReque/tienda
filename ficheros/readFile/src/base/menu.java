
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



public class menu 
{
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
    
    public static void opcion1(){
        //hacer un pedido1
	System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("Menu pedido:");
	System.out.println(" 1.1 Añadir producto a la cesta\n"
                         + " 1.2 Visualizar precio total de la cesta\n"
                         + " 1.3 Imprimir factura\n"
                         + " 1.4 Terminar pedido");
        System.out.println("--------------------------");
        System.out.println("Selection: ");
        carro tienda = new carro();
	Scanner q = new Scanner(System.in);
       
	switch (q.nextInt()) 
	{
	    case 1:
	    System.out.println ("");
            leerArchivo();
            tienda.addItem();
            opcion1();
	    break;
  
	    case 2:
	    System.out.println ("");
            leerArchivo();
            tienda.precioTotal();
            opcion1();
            break;
            
            case 3:
                    
	    System.out.println ("");
	    break;
            
            case 4:
	    System.out.println ("");
            InputMenu();
	    break;
            
	    default:
	    System.err.println ( "Unrecognized option" );
	    break;
	}
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
            System.out.println("#     Codigo    Nombre                        Precio");
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
                System.out.println("       " + codigo + "       " + nombre  + "       " +precio);
                
                //Añadir producto
                //productos.add(new Producto(codigo, nombre, descripcion, precio));
            }
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

