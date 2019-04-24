import java.util.*;
import java.io.Serializable;


public class Compra implements Serializable{
  private Person per;
  private Producto pro;
  private int cant;


  public Compra() {
    per = new Person();
    pro = new Producto();
    cant = 0;


  }

  public void setPer(String name, String dni, String direccion) {
    per.setName(name);
    per.setDni(dni);
    per.setDireccion(direccion);
  }
  public void setAp(String name, Double precio) {
    pro.setName(name);
    pro.setPrecio(precio);
  }

    
    public void setCant(int cant) {
      this.cant = cant;
    }

    
    public int getCant() {
      return cant;
    }
  
    public Producto getPro() {
      return pro;
    }

    public Person getPer() {
      return per;
    }



  @Override
  public String toString() {
    String string = per.getName() + "--o--" + per.getDni() + "--o--" + per.getDireccion() + " --o-- " + pro.getName() + " --o-- " + pro.getPrecio() + "--o--" + pro.getCantidad();
    return string;
  }

}

