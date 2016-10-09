package remoto.entidad;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nombre;
  private BigDecimal stock;
  private BigDecimal precio;
  private Unidad unidad;

  public Producto() {
  }

  public Producto(Integer id) {
    this.id = id;
  }

  public Producto(Integer id, String nombre, BigDecimal stock) {
    this.id = id;
    this.nombre = nombre;
    this.stock = stock;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public BigDecimal getStock() {
    return stock;
  }

  public void setStock(BigDecimal stock) {
    this.stock = stock;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  public Unidad getUnidad() {
    return unidad;
  }

  public void setUnidad(Unidad unidad) {
    this.unidad = unidad;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Producto)) {
      return false;
    }
    Producto other = (Producto) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "remoto.entidad.Producto[ id=" + id + " ]";
  }
  
}
