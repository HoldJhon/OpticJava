package Controlador;

import Modelo.Admin;
import Modelo.Historia;
import Modelo.Persistencia;
import Vista.Login;
import Vista.Principal;
import Vista.Registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    Historia objHistoria;

    Admin objAdmin;

    Login VistaLogin;
    Registro VistaRegistro;
    Principal VistaPrincipal;

    Persistencia objPersistencia;

    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador() {

        VistaLogin = new Login();
        VistaLogin.getBoton_entrar().addActionListener(this);
        VistaLogin.getBtn_registrar().addActionListener(this);
        VistaLogin.setVisible(true);

        VistaRegistro = new Registro(VistaLogin, true);
        VistaRegistro.getBtn_registro().addActionListener(this);
        VistaRegistro.getBtn_cancelar().addActionListener(this);

        VistaPrincipal = new Principal();
        VistaPrincipal.getBtn_guardar().addActionListener(this);
        VistaPrincipal.getBtn_ver().addActionListener(this);

        objPersistencia = new Persistencia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == VistaLogin.getBtn_registrar()) {

            VistaRegistro.setVisible(true);

        }

        if (e.getSource() == VistaRegistro.getBtn_registro()) {

            if (VistaRegistro.getTxt_regContra().getText().equals(VistaRegistro.getTxt_regConfirmContra().getText())) {

                objAdmin = new Admin(VistaRegistro.getTxt_regUsuario().getText(), VistaRegistro.getTxt_regContra().getText());

                objPersistencia.adicionarUsuario(objAdmin);

                VistaRegistro.getTxt_regUsuario().setText("");
                VistaRegistro.getTxt_regContra().setText("");
                VistaRegistro.getTxt_regConfirmContra().setText("");
            } else {

                JOptionPane.showMessageDialog(VistaRegistro, "La clave no es la misma");
            }
        }
        
        if(e.getSource() == VistaRegistro.getBtn_cancelar()){
            
            VistaRegistro.setVisible(false);
            VistaRegistro.dispose();
        }

        if (e.getSource() == VistaLogin.getBoton_entrar()) {

            boolean aux = objPersistencia.temporal(VistaLogin.getTxt_usuario().getText(), VistaLogin.getTxt_contraseña().getText());

            if (aux == true) {

                VistaLogin.setVisible(false);
                VistaLogin.dispose();
                VistaPrincipal.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(VistaLogin, "Usuario o contraseña incorrecta");
                VistaLogin.getTxt_contraseña().setText("");
            }
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

                if (arrayAux[i].equals("")) {
                    arrayAux[i] = "*";
                }
            }

            objHistoria = new Historia((String) arrayAux[0], (String) arrayAux[1], (String) arrayAux[2],
                    (String) arrayAux[3], (String) arrayAux[4], (String) arrayAux[5], (String) arrayAux[6],
                    (String) arrayAux[7]);

            objPersistencia.adicionarHistoria(objHistoria);

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

            modelo = objPersistencia.mostrar(VistaPrincipal.getTxt_buscar().getText());
            VistaPrincipal.getTbl_datos().setModel(modelo);
        }
    }
}
