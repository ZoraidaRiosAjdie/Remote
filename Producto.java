import java.io.Serializable;

class Producto implements Serializable{
    private Double precio;
    private Integer cantidad;
    private String name;



    public Producto() {
      precio = 0.0;
      cantidad = 0; 
      name = "";
     
    }


    public Producto( double precio, int cantidad, String name) {
        this.precio = precio;
        this.cantidad = cantidad; 
        this.name = name;

    }

    public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
    }

    public int getCantidad() {
      return cantidad;
    }
    
    public void setName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setPrecio(double precio) {
      this.precio = precio;
    }

    public double getPrecio() {
      return precio;
    }

}

