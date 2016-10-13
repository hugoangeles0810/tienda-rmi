package remoto.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BoletaCabecera implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String cliente;
  private String direccion;
  private BigDecimal monto;
  private Date fecha;
  private List<BoletaDetalle> boletaDetalleList;

  public BoletaCabecera() {
  }

  public BoletaCabecera(Integer id) {
    this.id = id;
  }

  public BoletaCabecera(Integer id, String cliente, BigDecimal monto, Date fecha) {
    this.id = id;
    this.cliente = cliente;
    this.monto = monto;
    this.fecha = fecha;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public BigDecimal getMonto() {
    return monto;
  }

  public void setMonto(BigDecimal monto) {
    this.monto = monto;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public List<BoletaDetalle> getBoletaDetalleList() {
    return boletaDetalleList;
  }

  public void setBoletaDetalleList(List<BoletaDetalle> boletaDetalleList) {
    this.boletaDetalleList = boletaDetalleList;
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
    if (!(object instanceof BoletaCabecera)) {
      return false;
    }
    BoletaCabecera other = (BoletaCabecera) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "remoto.entidad.BoletaCabecera[ id=" + id + " ]";
  }
  
}
