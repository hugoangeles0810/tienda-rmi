package remoto.entidad;

import java.io.Serializable;
import java.math.BigDecimal;

public class BoletaDetalle implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private BigDecimal cantidad;
  private BigDecimal precio;
  private Producto producto;
  private BoletaCabecera boletaCabecera;

  public BoletaDetalle() {
  }

  public BoletaDetalle(Integer id) {
    this.id = id;
  }

  public BoletaDetalle(Integer id, BigDecimal cantidad, BigDecimal precio) {
    this.id = id;
    this.cantidad = cantidad;
    this.precio = precio;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getCantidad() {
    return cantidad;
  }

  public void setCantidad(BigDecimal cantidad) {
    this.cantidad = cantidad;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public BoletaCabecera getBoletaCabecera() {
    return boletaCabecera;
  }

  public void setBoletaCabecera(BoletaCabecera boletaCabecera) {
    this.boletaCabecera = boletaCabecera;
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
    if (!(object instanceof BoletaDetalle)) {
      return false;
    }
    BoletaDetalle other = (BoletaDetalle) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "remoto.entidad.BoletaDetalle[ id=" + id + " ]";
  }
  
}
