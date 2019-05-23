package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class carro {

        
	private String product;
	private int quantity;
	private double price;
 
	//constructor
	public carro(){
            product = "";
            quantity = 0;
            price = 0.0;
	}
        
	public String getProduct(){
            return product;
	}
	public double getPrice(){
            return price;
	}
	public int getQuantity(){
            return quantity;
	}
 
	//constructor with parameters
	public carro(String inProduct, int inQuant, double inPrice){
		product = new String(inProduct);
		quantity = inQuant;
		price = inPrice;
	}
        
	
	public boolean equals(carro item){
		//write the code for the equals method
		//return true;
		boolean resultado = false;
                resultado = this.product.equalsIgnoreCase(item.getProduct()) && this.price == item.getPrice();        
		return resultado;
	}
 
	public String toString(){
            String result="";
            return result;
	}

    
}
 