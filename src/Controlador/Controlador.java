package Controlador;

import Modelo.*;
import Vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    Historia objHistoria;
    Principal VistaPrincipal;
    Editar VistaEditar;

    Persistencia objPersistencia;

    DefaultTableModel modelo = new DefaultTableModel();
    Object fila[] = new Object[10];

    Calendar fesha = new GregorianCalendar();
    String fecha;

    public Controlador() {

        VistaPrincipal = new Principal();
        VistaPrincipal.setVisible(true);
        VistaPrincipal.getBtn_guardar().addActionListener(this);
        VistaPrincipal.getBtn_ver().addActionListener(this);
        VistaPrincipal.getBtn_editar().addActionListener(this);
        VistaPrincipal.getBtn_nueva().addActionListener(this);
        VistaPrincipal.getBtn_antigua().addActionListener(this);

        VistaEditar = new Editar(VistaPrincipal, true);
        VistaEditar.getBtn_aceptar().addActionListener(this);
        VistaEditar.getBtn_cancelar().addActionListener(this);

        objPersistencia = new Persistencia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (VistaPrincipal.getBtn_nueva().isSelected()) {

            VistaPrincipal.getTxt_fecha().setVisible(false);
            VistaPrincipal.getLbl_fecha().setVisible(false);

            int temp = fesha.get(Calendar.MONTH) + 1;
            fecha = fesha.get(Calendar.DATE) + "/" + temp + "/" + fesha.get(Calendar.YEAR);
        } else if (VistaPrincipal.getBtn_antigua().isSelected()) {

            VistaPrincipal.getTxt_fecha().setVisible(true);
            VistaPrincipal.getLbl_fecha().setVisible(true);
            fecha = VistaPrincipal.getTxt_fecha().getText();
        }

        if (e.getSource() == VistaPrincipal.getBtn_guardar()) {

            Object arrayAux[] = new Object[8];

            if (VistaPrincipal.getTxt_cedula().getText().equals("")) {

                JOptionPane.showMessageDialog(VistaPrincipal, "El campo de cedula es obligatorio");
            } else {

                arrayAux[0] = VistaPrincipal.getTxt_nombre().getText();
                arrayAux[1] = VistaPrincipal.getTxt_apellido().getText();
                arrayAux[2] = VistaPrincipal.getTxt_cedula().getText();
                arrayAux[3] = VistaPrincipal.getTxt_telefono().getText();
                arrayAux[4] = VistaPrincipal.getTxt_OD().getText();
                arrayAux[5] = VistaPrincipal.getTxt_OI().getText();
                arrayAux[6] = VistaPrincipal.getTxt_add().getText();
                arrayAux[7] = VistaPrincipal.getTxt_dp().getText();

                for (int i = 0; i < arrayAux.length; i++) {

                    if (arrayAux[i].equals("")) {
                        arrayAux[i] = "*";
                    }
                }

                objHistoria = new Historia((String) arrayAux[0], (String) arrayAux[1], (String) arrayAux[2],
                        (String) arrayAux[3], (String) arrayAux[4], (String) arrayAux[5], (String) arrayAux[6],
                        (String) arrayAux[7]);

                objPersistencia.adicionarHistoria(objHistoria, fecha);

                VistaPrincipal.getTxt_nombre().setText("");
                VistaPrincipal.getTxt_apellido().setText("");
                VistaPrincipal.getTxt_cedula().setText("");
                VistaPrincipal.getTxt_telefono().setText("");
                VistaPrincipal.getTxt_OI().setText("");
                VistaPrincipal.getTxt_OD().setText("");
                VistaPrincipal.getTxt_add().setText("");
                VistaPrincipal.getTxt_dp().setText("");
            }
        }

        if (e.getSource() == VistaPrincipal.getBtn_ver()) {

            modelo.setRowCount(0);

            modelo = objPersistencia.mostrar(VistaPrincipal.getTxt_buscar().getText());
            VistaPrincipal.getTbl_datos().setModel(modelo);

            VistaPrincipal.getTxt_buscar().setText("");
        }

        if (e.getSource() == VistaPrincipal.getBtn_editar()) {

            VistaEditar.setVisible(true);
        }

        if (e.getSource() == VistaEditar.getBtn_aceptar()) {

            fila = objPersistencia.editar(VistaEditar.getTxt_editar().getText());

            VistaPrincipal.getTxt_nombre().setText((String) fila[2]);
            VistaPrincipal.getTxt_apellido().setText((String) fila[3]);
            VistaPrincipal.getTxt_cedula().setText((String) fila[4]);
            VistaPrincipal.getTxt_telefono().setText((String) fila[5]);
            VistaPrincipal.getTxt_OI().setText((String) fila[6]);
            VistaPrincipal.getTxt_OD().setText((String) fila[7]);
            VistaPrincipal.getTxt_add().setText((String) fila[8]);
            VistaPrincipal.getTxt_dp().setText((String) fila[9]);

            VistaEditar.getTxt_editar().setText("");

            VistaEditar.dispose();  //cierra
        }

        if (e.getSource() == VistaEditar.getBtn_cancelar()) {

            VistaEditar.dispose();
        }
    }
}
