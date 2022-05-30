package Controlador;

import Modelo.Historia;
import Vista.Principal;
import Sql.Sql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    Sql objSql;

    Historia objHistoria;

    Principal VistaPrincipal;

    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador() {

        objSql = new Sql();

        VistaPrincipal = new Principal();
        VistaPrincipal.setVisible(true);
        VistaPrincipal.getBtn_guardar().addActionListener(this);
        VistaPrincipal.getBtn_ver().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == VistaPrincipal.getBtn_guardar()) {

            Object arrayAux[] = new Object[8];

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

            objSql.insertar(objHistoria);

            VistaPrincipal.getTxt_nombre().setText("");
            VistaPrincipal.getTxt_apellido().setText("");
            VistaPrincipal.getTxt_cedula().setText("");
            VistaPrincipal.getTxt_telefono().setText("");
            VistaPrincipal.getTxt_OI().setText("");
            VistaPrincipal.getTxt_OD().setText("");
            VistaPrincipal.getTxt_add().setText("");
            VistaPrincipal.getTxt_dp().setText("");
        }

        if (e.getSource() == VistaPrincipal.getBtn_ver()) {

            String aux = VistaPrincipal.getTxt_buscar().getText();

            modelo.setRowCount(0);
            if (aux.equals("")) {

                modelo = objSql.mostrar("", true);
                VistaPrincipal.getTbl_datos().setModel(modelo);
            } else {
                modelo = objSql.mostrar(VistaPrincipal.getTxt_buscar().getText(), false);
                VistaPrincipal.getTbl_datos().setModel(modelo);
            }
        }
    }
}
