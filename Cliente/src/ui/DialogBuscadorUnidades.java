package ui;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import presentador.UnidadesPresentador;
import presentador.impl.UnidadesPresentadorImpl;
import remoto.entidad.Unidad;
import util.UIHelper;
import vista.UnidadesVista;

public class DialogBuscadorUnidades extends javax.swing.JDialog implements UnidadesVista{

  public interface OnUnidadSelected {
    public void unidadSelected(Unidad unidad);
  }
  
  public DialogBuscadorUnidades(java.awt.Frame parent, boolean modal, OnUnidadSelected onUnidadSelected) {
    super(parent, modal);
    initComponents();
    
    this.onUnidadSelected = onUnidadSelected;
    
    unidadesPresentador = new UnidadesPresentadorImpl(this);
    unidadesPresentador.buscar(readBuscarForm());
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextFieldBNombre = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jTextFieldBAbreviatura = new javax.swing.JTextField();
    jButtonBuscar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTableListado = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Buscador Unidades");

    jPanelPrincipal.setName(""); // NOI18N

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscador"));

    jLabel1.setText("Nombre");

    jTextFieldBNombre.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextFieldBNombreKeyPressed(evt);
      }
    });

    jLabel2.setText("Abreviatura");

    jTextFieldBAbreviatura.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextFieldBAbreviaturaKeyPressed(evt);
      }
    });

    jButtonBuscar.setText("Buscar");
    jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonBuscarActionPerformed(evt);
      }
    });

    jTableListado.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "#", "Nombre", "Abreviatura"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTableListado.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTableListadoMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTableListado);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(jTextFieldBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextFieldBAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscar))))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jTextFieldBAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButtonBuscar)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
    unidadesPresentador.buscar(readBuscarForm());
  }//GEN-LAST:event_jButtonBuscarActionPerformed

  private void jTextFieldBNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBNombreKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     unidadesPresentador.buscar(readBuscarForm());
    }
  }//GEN-LAST:event_jTextFieldBNombreKeyPressed

  private void jTextFieldBAbreviaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBAbreviaturaKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     unidadesPresentador.buscar(readBuscarForm());
    }
  }//GEN-LAST:event_jTextFieldBAbreviaturaKeyPressed

  private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoMouseClicked
    int row = jTableListado.rowAtPoint(evt.getPoint());
    if (row >= 0) {
      if (onUnidadSelected != null) {
        onUnidadSelected.unidadSelected(unidades.get(row));
      }
    }
  }//GEN-LAST:event_jTableListadoMouseClicked


  private UnidadesPresentador unidadesPresentador;
  private List<Unidad> unidades;
  private DialogBuscadorUnidades.OnUnidadSelected onUnidadSelected;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonBuscar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTableListado;
  private javax.swing.JTextField jTextFieldBAbreviatura;
  private javax.swing.JTextField jTextFieldBNombre;
  // End of variables declaration//GEN-END:variables

  @Override
  public void mostrarUnidades(List<Unidad> unidades) {
    DefaultTableModel model = (DefaultTableModel) jTableListado.getModel();
    
    UIHelper.removeRowsOfTable(model);
    
    Integer index = 0;
    for (Unidad unidad : unidades) {
      Object datos[] = new Object[3];
      datos[0] = ++index;
      datos[1] = unidad.getNombre();
      datos[2] = unidad.getAbreviatura();
      
      model.addRow(datos);
    }
    
    this.unidades = unidades;
    jTableListado.setModel(model);
  }

  @Override
  public void showError(String msg) {
    UIHelper.showError(this, msg);
  }

  @Override
  public void onActionSuccess(String msg) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void onActionFailed(String cause) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  private Unidad readBuscarForm() {
    Unidad unidad = new Unidad();
    unidad.setNombre(jTextFieldBNombre.getText());
    unidad.setAbreviatura(jTextFieldBAbreviatura.getText());
    return unidad;
  }
}
