package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class carro {

        
    private  ArrayList<productos> ItemList;
    private  Scanner scan = new Scanner(System.in);
    
    public carro() {
        
        ItemList = new ArrayList<productos>();
    }
    
    
    public int getSize() {
        return ItemList.size();

    }

    private  productos search(long code) {
        Iterator<productos> itr = ItemList.iterator();
        productos producto;
        while (itr.hasNext()) {
            producto = new productos(itr.next());
            if (producto.getCode() == code) {
                return producto;
            }
        }
        return null;
    }

    public  productos search(String name) {
        Iterator<productos> itr = ItemList.iterator();
        productos producto;
        while (itr.hasNext()) {
            producto = new productos(itr.next());
            if (producto.getName().equals(name)) {
                return producto;
            }
        }
        return null;
    }

    public  void addItem() {
        
        long anadirCodigo;
        String anadirNombre;
        double anadirPrecio;
        int anadirCantidad;
        productos foundItem;

        System.out.println("Entre código producto --> ");
        anadirCodigo = scan.nextLong();
        foundItem = search(anadirCodigo);
        if (foundItem == null) {
            System.out.println("Nombre producto -->  ");
            anadirNombre = scan.next();
            System.out.println("Precio --> ");
            anadirPrecio = scan.nextDouble();
            System.out.println("Cantidad --> ");
            anadirCantidad = scan.nextInt();
            productos aItem = new productos(anadirNombre, anadirPrecio, anadirCodigo, anadirCantidad);
            ItemList.add(aItem);
        } else if (foundItem != null) {
            System.out.println("Producto ya existe");
        }

    }
    public void obtenerDatos(){
        long anadirCodigo;
        String anadirNombre;
        double anadirPrecio;
        int anadirCantidad;
        productos foundItem;
        
        System.out.println("Entre código producto --> ");
        anadirCodigo = scan.nextLong();
        System.out.println("Nombre producto -->  ");
        anadirNombre = scan.next();
        System.out.println("Precio --> ");
        anadirPrecio = scan.nextDouble();
        System.out.println("Cantidad --> ");
        anadirCantidad = scan.nextInt();
    }
     
    public   void precioTotal() {
        int quantity;
        long code;
        productos foundItem;
        int cantidadComprada;
        ItemList.size();
        System.out.println("Entre código del producto --> ");
        code = scan.nextLong();
        System.out.println("Entre cantidad comprada de dicho codigo");
        cantidadComprada = scan.nextInt();
        foundItem = search(code);
        
        if (foundItem == null) {
            System.out.println("Item not found");
            //foundItem.setQuantity(foundItem.getQuantity() - quantity);
            return;
        }
     
        System.out.println("Cantida  del producto --> ");
        quantity = scan.nextInt();
        if (quantity > foundItem.getQuantity()) {
            System.out.println("\n Fuera de stock \n\n");
        }

        else {
            System.out.println("\nEl coste de " + quantity + " copias --> "+ quantity * foundItem.getPrize());
            foundItem.setQuantity(foundItem.getQuantity() - quantity);
        }
    }
    
    
    
    public double checkPrice(long code) {
        productos foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Producto no encontrado(checkprice)");
            return 0.0;
        }

        else
            return foundItem.getPrize();
    }
}
 