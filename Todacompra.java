import java.io.*;
import java.util.*;



public class Todacompra {
    public static void main(String args[]) {
   		DAOCompra factura2 = new Factura2();
   		DAOCompra txt = new LeerFichero();
   		DAOCompra sql = new DAOCompraSQL();

	    List<Compra> lista = new ArrayList<Compra>();
	    String str;
	    String a;
	    String b;
	    String linea;
	    String listado = "";
	    Console console = System.console();
	    System.out.println("Bienvenido a Compras Online Wonferfull");
	    System.out.println("");
	    System.out.println("");
	    System.out.println("--------**-------**--------**-------**-------**-------**-------");
	    System.out.println("Este es el listado de productos de Compras Online Wonderfull");
	    System.out.println("_______________________________________________________________");
	    System.out.println("");

	    try (BufferedReader br = new BufferedReader(new FileReader("Productos"))) {
        	while((linea = br.readLine()) != null) {
				String[] line = linea.split(":");
				String part1 = line[0];
				String part2 = line[1];
				String part3 = line[2];
				listado = part1 + ";" + part2 + ";" + part3 + ";" + listado;
	    		System.out.println(linea);
				
			}			
        }
        		
        catch (Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("\n");
	    System.out.println("Desea hacer la compra para rellenar la nevera? (s/n)");
	    a = console.readLine();

	    while(a.contains("s")) {

	        Compra compra = new Compra();
	        Person p = new Person();
	        System.out.println("Ahora, vamos a recabar sus datos personales para comprobar que no es un robot");
	        System.out.println("");


	        System.out.println("Nombre del cliente: ");
	        String persona = console.readLine();
	        System.out.println("DNI del cliente:  ");
	        String dni = console.readLine();
	        System.out.println("Direccion del cliente:  ");
	        String direccion = console.readLine();

	        compra.setPer(persona,dni,direccion);

	        while (true) {
		        System.out.println("Que desea comprar ? ");
		        String nombre = console.readLine();
		        String[] producto = listado.split(":");
		        for (String pr : producto) {
		        	if (pr.contains(nombre)) {
		        		String[] pro = pr.split(";");
		        		String marca = pro[2];
		        		String precio = pro[1];
				        System.out.println("Cantidad de " + nombre + " que desea meter en el carrito ? ");
				        str = console.readLine();
				        int cantidad = Integer.parseInt(str);
				        Double c = Double.valueOf(cantidad);
				        Double precio_total = Double.parseDouble(precio) * c;
				        compra.setAp(nombre, precio_total);
				        compra.setCant(cantidad);


				        //A grabar datos se dijo
				        factura2.grabar(compra);
				        sql.grabar(compra);
				        txt.grabar(compra);
				        lista.add(compra);
		        	}
		        }
		        System.out.println("Desea comprar otro producto " + persona + "? (s/n)");
		        if (console.readLine().equals("n")) { 
		            break;
		        }
		        else {
		        	compra = new Compra();
		        	compra.setPer(persona,dni,direccion);
		        }
		    }
		    System.out.println("Desea " + persona + " realizar una compra diferente? (s/n)");
	    	a = console.readLine();
		}

		    System.out.println("Listado de Productos comprados:");
		    for(Compra c : lista){
		        System.out.println(c.getPer().getName() + " ha comprado " + c.getCant() + " " + c.getPro().getName()  + " ------ " + c.getPro().getPrecio() + "€");
		    }


	        
	    	    	     
	}
}
