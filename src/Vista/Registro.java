package Vista;

import Modelo.PlaceHolder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jhon
 */
public class Registro extends javax.swing.JDialog {

    public Registro(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();

        setTitle("Registro");
        setLocationRelativeTo(null);    //Coloca la ventana en medio de la pantalla
        setResizable(false);    //No deja cambiar el tamaño de la ventana

        PlaceHolder usuario = new PlaceHolder("Usuario", txt_regUsuario);
        PlaceHolder contra = new PlaceHolder("Contraseña", txt_regContra);
        PlaceHolder comfirContra = new PlaceHolder("Confirmacion", txt_regConfirmContra);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_regUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_registro = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_regContra = new javax.swing.JPasswordField();
        txt_regConfirmContra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear una cuenta de usuario");

        btn_registro.setText("Registrarme");

        btn_cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_registro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cancelar))
                            .addComponent(txt_regUsuario)
                            .addComponent(txt_regContra)
                            .addComponent(txt_regConfirmContra))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(txt_regUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_regContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_regConfirmContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_registro)
                    .addComponent(btn_cancelar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_registro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txt_regConfirmContra;
    private javax.swing.JPasswordField txt_regContra;
    private javax.swing.JTextField txt_regUsuario;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxt_regUsuario() {
        return txt_regUsuario;
    }

    public void setTxt_regUsuario(JTextField txt_regUsuario) {
        this.txt_regUsuario = txt_regUsuario;
    }

    public JPasswordField getTxt_regConfirmContra() {
        return txt_regConfirmContra;
    }

    public void setTxt_regConfirmContra(JPasswordField txt_regConfirmContra) {
        this.txt_regConfirmContra = txt_regConfirmContra;
    }

    public JPasswordField getTxt_regContra() {
        return txt_regContra;
    }

    public void setTxt_regContra(JPasswordField txt_regContra) {
        this.txt_regContra = txt_regContra;
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public JButton getBtn_registro() {
        return btn_registro;
    }
}
