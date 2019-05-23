import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import util.Color;

import base.menu;

public class Tienda extends menu{
    
    public static void main(String[] args){
          loginFile();
          
    }
    
    public  static void loginFile(){
         Scanner leerTeclado = new Scanner(System.in);
            
            System.out.println("-----------------------------------------");
            System.out.println("Bienvenido a la tienda");
            System.out.println("***************************************");
            System.out.print("Introduce el código de tu usuario: ");
            while (!leerTeclado.hasNextInt()) {
                System.out.println(Color.ERROR + "Debe escribir un valor numérico" + Color.DEFAULT);
                System.out.print("Introduce el código de tu usuario: ");
                 leerTeclado.next();
            }
            
             int codigoEntrada = leerTeclado.nextInt();
        
        
            System.out.print("Introduce tu contraseña: ");
             String passwordEntrada = leerTeclado.next();

            
            //leerTeclado.close();
            
            System.out.println("***************************************");
            System.out.println("");

            boolean found = false;
            String tempUsername = "";
            String tempPassword = "";

            try{
                Scanner x = new Scanner(new File("users.txt"));
                x.useDelimiter("[,\n | / \n]");

                while(x.hasNext() && !found ){
                    tempUsername = x.next();
                    tempPassword = x.next();

                    if(!tempUsername.trim().equals(String.valueOf(codigoEntrada))){//Error mal codigo
                        System.out.println(Color.ERROR + "---------> Error nombre !!" + Color.DEFAULT);
                    }
                    if(!tempPassword.trim().equals(passwordEntrada.trim())){
                        System.out.println(Color.ERROR + "---------> Error contraseña !!" + Color.DEFAULT);//Error mala contraseña
                    }
                    //codigo + contraseña validos(estan dentro del fichero y han sido verificados)
                    if(tempUsername.trim().equals(String.valueOf(codigoEntrada)) && tempPassword.trim().equals(passwordEntrada.trim())){
                        
                        System.out.println(Color.EXITO + "Esta dentro de la aplicacion!!!" + Color.DEFAULT);
                        
                        InputMenu();
                       
                        found = true;
                        
                    }
                }
                
                
                //x.close();
                //System.out.println(found);
            }catch(Exception e){
                System.out.println("Error0: " + e.getMessage());
            }

    
    }
    
    

    
    

    public static void muestraMensaje(String mensaje, Color color) {
        System.out.println(color + mensaje + Color.DEFAULT);
    }

    public static void muestraMensaje(String mensaje) {
        muestraMensaje(mensaje, Color.DEFAULT);
    }

    private static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    
   
}