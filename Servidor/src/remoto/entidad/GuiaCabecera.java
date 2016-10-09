package remoto.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class GuiaCabecera implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String numero;
  private Date fecha;
  private List<GuiaDetalle> guiaDetalleList;

  public GuiaCabecera() {
  }

  public GuiaCabecera(Integer id) {
    this.id = id;
  }

  public GuiaCabecera(Integer id, String numero, Date fecha) {
    this.id = id;
    this.numero = numero;
    this.fecha = fecha;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public List<GuiaDetalle> getGuiaDetalleList() {
    return guiaDetalleList;
  }

  public void setGuiaDetalleList(List<GuiaDetalle> guiaDetalleList) {
    this.guiaDetalleList = guiaDetalleList;
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
    if (!(object instanceof GuiaCabecera)) {
      return false;
    }
    GuiaCabecera other = (GuiaCabecera) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "remoto.entidad.GuiaCabecera[ id=" + id + " ]";
  }
  
}
