import java.io.Serializable;


public class Person implements Serializable {
 private String name;
 private String dni;
 private String direccion;

 public Person() {
  // Nothing to do...
 }
 public Person(String name, String direccion, String dni) {
    this.name = name;
    this.direccion = direccion;
    this.dni = dni;
    
  
 }

 @ Override
 public String toString() {
  String string =  name + "-o-" + dni + "-o-" + direccion;
  return string;
}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getDni(){
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }
  public String getDireccion(){
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

}
