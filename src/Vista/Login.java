package Vista;

import Modelo.PlaceHolder;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jhon
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        
        initComponents();
        
        setTitle("Login");
        setLocationRelativeTo(null);    //Coloca la ventana en medio de la pantalla
        setResizable(false);    //No deja cambiar el tamaño de la ventana

        PlaceHolder usu = new PlaceHolder("Usuario", txt_usuario);
        PlaceHolder contra = new PlaceHolder("Contraseña", txt_contraseña);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_usuario = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JPasswordField();
        boton_entrar = new javax.swing.JButton();
        ImagenContraseña = new javax.swing.JLabel();
        ImagenUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_usuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_usuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_usuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        txt_contraseña.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_contraseña.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_contraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        boton_entrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_entrar.setText("Entrar");

        ImagenContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagenContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/login.png"))); // NOI18N
        ImagenContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        ImagenUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagenUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/usuario.png"))); // NOI18N
        ImagenUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/imagenusuario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImagenContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ImagenUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txt_usuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ImagenContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txt_contraseña))
                .addGap(30, 30, 30)
                .addComponent(boton_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenContraseña;
    private javax.swing.JLabel ImagenUsuario;
    private javax.swing.JButton boton_entrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    public JButton getBoton_entrar() {
        return boton_entrar;
    }

    public JPasswordField getTxt_contraseña() {
        return txt_contraseña;
    }

    public JTextField getTxt_usuario() {
        return txt_usuario;
    }
}