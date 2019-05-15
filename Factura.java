import java.io.*;
import java.util.*;

public class Factura{

	public static void main(String[] args) throws Exception{
        	Compra c = null;

		    try {

		      FileInputStream file = new FileInputStream("Factura.dat");

		      ObjectInputStream ob = new ObjectInputStream(file);
		      while (file.available() > 0) {

			      c = (Compra)ob.readObject();

			      System.out.println(c.toString());
			  }

		    }
		    catch(IOException e)

		    {
		      System.err.println("Error");
		    }

		    catch(ClassNotFoundException e)

		    {
		      System.err.println("Error");
		    }


	}
}