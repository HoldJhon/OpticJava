package Controlador;

import Modelo.Administrador;
import Modelo.Historia;
import Modelo.Persistencia;
import Vista.Login;
import Vista.Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    Historia objHistoria;
    //Administrador admin = new Administrador();

    Login VistaLogin;
    Principal VistaPrincipal;

    Persistencia objPersistencia;

    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador() {

        VistaLogin = new Login();
        VistaLogin.getBoton_entrar().addActionListener(this);
        VistaLogin.setVisible(true);

        VistaPrincipal = new Principal();
        VistaPrincipal.getBtn_guardar().addActionListener(this);
        VistaPrincipal.getBtn_ver().addActionListener(this);
        
        objPersistencia = new Persistencia();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == VistaLogin.getBoton_entrar()) {

            VistaLogin.setVisible(false);
            VistaPrincipal.setVisible(true);

        }

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

                if (arrayAux[i] == null) {
                    arrayAux[i] = "-";
                }
            }

            objHistoria = new Historia((String) arrayAux[0], (String) arrayAux[1], (String) arrayAux[2],
                    (String) arrayAux[3], (String) arrayAux[4], (String) arrayAux[5], (String) arrayAux[6],
                    (String) arrayAux[7]);

            objPersistencia.adicionar(objHistoria);

            //this.admin.getListaHistoria().add(objHistoria);
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

            modelo.setRowCount(0);

            modelo = objPersistencia.mostrar();
            VistaPrincipal.getTbl_datos().setModel(modelo);
        }
    }
}
