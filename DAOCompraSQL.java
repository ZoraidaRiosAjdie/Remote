import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.*;
import java.io.*;



public class DAOCompraSQL implements DAOCompra {
	private static final String URL = "jdbc:sqlite:Tienda.db";
        public DAOCompraSQL() {
        	CreateTable();
        	CreateDB(); 	
		}




	public void grabar(Compra c){
		//Clase Person
		String person = c.getPer().getName();
		String dni = c.getPer().getDni();
		String direccion = c.getPer().getDireccion();

		//Clase Producto
        String nombre = c.getPro().getName();
        Integer cantidad = c.getPro().getCantidad();
		Double precio = c.getPro().getPrecio();
		Date fecha = new Date();
      	String fechas = fecha.toString();

      	//Se insertan los datos
		insertar(person, dni, direccion, nombre, cantidad, precio, fechas);
	}
	private void insertar(String person, String dni, String direccion, String nombre, Integer cantidad, Double precio, String fecha) {
		final String SQL = "INSERT INTO comprar VALUES(?,?,?,?,?,?,?,?)";
		try (Connection connect = getConnection(); PreparedStatement ps = connect.prepareStatement(SQL);) {


		    ps.setString(1, person);
		    ps.setString(2, dni);
		    ps.setString(3, direccion);
		    ps.setString(4, nombre);
		    ps.setInt(5, cantidad);
		    ps.setDouble(6, precio);
		    ps.setString(7, fecha);
		    ps.executeUpdate();	    
		}
		catch (SQLException e) {
		    System.out.println(e.getMessage());
		}
	}

	private static void CreateTable() {
		final String SQL = "CREATE TABLE IF NOT EXISTS compra (person text, dni text, direccion text, name text, cantidad integer, precio double, fecha text primary key);";
		try (Connection connect = getConnection(); 
			Statement statement = connect.createStatement();) {
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    private static void CreateDB() {

		try (Connection connect = getConnection()) {
			if (connect != null) {
				connect.getMetaData();
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL);
	}
}



       