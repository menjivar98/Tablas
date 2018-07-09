package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultaProducto;
import modelo.Producto;
import vista.frmProducto;

public class CtrlProducto implements ActionListener {

    private Producto mod;
    private ConsultaProducto modC;
    private frmProducto frm;

    public CtrlProducto(Producto mod, ConsultaProducto modC, frmProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtCodigo.getText());
            mod.setPrecio(Double.parseDouble(frm.txtCodigo.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCodigo.getText()));

            if (modC.registar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardado");
                limpiar();
            }

        }

        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtCodigo.getText());
            mod.setPrecio(Double.parseDouble(frm.txtCodigo.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCodigo.getText()));

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modicado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }

        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminar");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }

        }

        if (e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtId.getText());

            if (modC.buscar(mod)) {

                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtId.setText(String.valueOf(mod.getCodigo()));
                frm.txtId.setText(String.valueOf(mod.getNombre()));
                frm.txtId.setText(String.valueOf(mod.getPrecio()));
                frm.txtId.setText(String.valueOf(mod.getCantidad()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }

        }

        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }

    }

    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
    }

}
