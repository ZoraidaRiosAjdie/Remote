import java.io.*;
import java.util.*;


public class LeerFichero implements DAOCompra {

	private FileWriter fw;


    public LeerFichero() {

    	try  {

	     	this.fw = new FileWriter("ComprasRealizadas.txt",true);
	    }


	    catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		} 
	}

	public void grabar(Compra c) {
		String str = "";
		str += c.getPer().getName() + "-*-";
		str += c.getPer().getDni() + "-*-";
		str += c.getPer().getDireccion() + "-*-";
        str += c.getPro().getName() + "-*-";
        str += c.getPro().getPrecio() + "-*-";
        str += c.getCant() + "-*-";

        try {

        	fw = new FileWriter("ComprasRealizadas.txt",true);

        	fw.write(str);

	        fw.close();    
        }

        catch (IOException e) {

			System.err.println("Error");

			System.err.println(e.getMessage());
		} 
        

    }
}
