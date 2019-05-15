import java.io.*;
import java.util.*;


public class Factura2 implements DAOCompra {

	private FileOutputStream out;
	private ObjectOutputStream obj;
	private File file; 


    public Factura2() {

    	try{

    		this.file = new File("Factura.dat");
			this.out = new FileOutputStream(file);
			this.obj = new ObjectOutputStream(out);
    		
		}

		 catch (IOException e) {

			System.err.println("Error");

			System.err.println(e.getMessage());
		}     
	}

	public void grabar(Compra c){
	
		try {

			obj.writeObject(c);
			
			
		}	    
		
		catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		} 
		
	}
}


