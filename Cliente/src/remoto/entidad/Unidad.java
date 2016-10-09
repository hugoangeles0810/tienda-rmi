package remoto.entidad;

import java.io.Serializable;

public class Unidad implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nombre;
  private String abreviatura;

  public Unidad() {
  }

  public Unidad(Integer id) {
    this.id = id;
  }

  public Unidad(Integer id, String nombre, String abreviatura) {
    this.id = id;
    this.nombre = nombre;
    this.abreviatura = abreviatura;
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

  public String getAbreviatura() {
    return abreviatura;
  }

  public void setAbreviatura(String abreviatura) {
    this.abreviatura = abreviatura;
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
    if (!(object instanceof Unidad)) {
      return false;
    }
    Unidad other = (Unidad) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "remoto.entidad.Unidad[ id=" + id + " ]";
  }
  
}
