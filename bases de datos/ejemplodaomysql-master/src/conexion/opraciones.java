/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Virtuo
 */
public class opraciones {
    public static void main(String[] args) {
        bases();
    }
    /*
        Las sentencias sql estan en el archivo .sql que te he adjuntado
        Breve resumen de dichas sentencias:
            CREATE TABLE nombres(p_nombre varchar(255));
            CREATE TABLE apellidos(p_apellidos varchar(255));
            
            INSERT INTO nombre(p_nombre) values ('Pedro');
            INSERT INTO apellidos(p_apellidos) values ('Fernandez');
            INSERT INTO apellidos(p_apellidos) values ('Lopez')
            INSERT INTO apellidos(p_apellidos) values ('Castro')
        */
    
   
    //arr.add(3);
    //arr.add("ss");
    static final String host = "localhost";
    static final String port = "3306";
    static final String database = "tienda";
    static final String user = "root";
    static final String password = "";
    static String urlParameters = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    static final String url = "jdbc:mysql://" 
            + host + ":" + port + "/" + database + urlParameters;

    public static void bases() {
        
        
        try {
            // driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            // conectar
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            
            // crear objeto sentencia
            Statement sentencia = conexion.createStatement();
            
            
            
            // ejecutar la consulta y almacenar resultado
            ResultSet resultadoNombre = sentencia.executeQuery("SELECT * FROM productos");
            
            
            // recorrer el ResulSet
            System.out.println("Codigo     Nombre                          Precio");
            while (resultadoNombre.next()) {                
                int codigo = resultadoNombre.getInt("p_codigo");
                String nombre = resultadoNombre.getString("p_nombre");
                
                //String apellidos = resultadoNombre.getString("p_descripcion");
                String prize = resultadoNombre.getString("p_precio");
                //System.out.printf(" %s",  nombre);
                //listaNombre.add(nombre);
                
                System.out.println(codigo +"        "+ nombre +"            "+ prize);
            }
            /*
            ResultSet resultadoApellidos = sentencia.executeQuery("SELECT * FROM apellidos");
            while (resultadoApellidos.next()) {                
                //int codigo = resultado.getInt("p_codigo");
                String apellidos = resultadoApellidos.getString("p_apellidos");
                //String apellidos = resultado.getString("e_apellidos");
                //String password = resultado.getString("e_password");
                
                //System.out.printf(" %s%n",  apellidos);
                //System.out.println(" " + apellidos);
                //listaApellidos.add(apellidos);
                
            }
           */
            //-----------------------------------------------
            
            // cerrar conexion
            sentencia.close();
            resultadoNombre.close();
            //resultadoApellidos.close();
            conexion.close();
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando driver MySQL");
        } catch (SQLException ex) {
            System.out.println("Error en la conexion a la base de datos");
            ex.printStackTrace();
        }
        //----------------------------
        
    
    }
}