package remoto.entidad;

import java.io.Serializable;
import java.math.BigDecimal;

public class GuiaDetalle implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Producto producto;
  private BigDecimal cantidad;
  private GuiaCabecera guiaCabecera;

  public GuiaDetalle() {
  }

  public GuiaDetalle(Integer id) {
    this.id = id;
  }

  public GuiaDetalle(Integer id, BigDecimal cantidad) {
    this.id = id;
    this.cantidad = cantidad;
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

  public GuiaCabecera getGuiaCabecera() {
    return guiaCabecera;
  }

  public void setGuiaCabecera(GuiaCabecera guiaCabecera) {
    this.guiaCabecera = guiaCabecera;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
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
    if (!(object instanceof GuiaDetalle)) {
      return false;
    }
    GuiaDetalle other = (GuiaDetalle) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "remoto.entidad.GuiaDetalle[ id=" + id + " ]";
  }
  
}
