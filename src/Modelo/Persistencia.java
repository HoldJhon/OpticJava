package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhon
 */
public class Persistencia {

    File archivo = new File("salida.csv");

    DataInputStream entrada;
    DataOutputStream salida;

    String encabezado[] = {
        "Nombre", "Apellido", "Cedula", "Telefono", "OI", "OD", "ADD", "DP"
    };

    DefaultTableModel modelo = new DefaultTableModel(null, encabezado);

    public Persistencia() {

        try {

            if (!archivo.exists()) {
                salida = new DataOutputStream(new FileOutputStream("salida.csv"));
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de E/S", "Leer Archivo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void adicionar(Historia historia) {

        try {

            String aux = historia.getNombre() + ";" + historia.getApellido() + ";" + historia.getCedula() + ";" + historia.getTelefono() + ";" + historia.getOi()
                    + ";" + historia.getOd() + ";" + historia.getAdd() + ";" + historia.getDp() + "\n";

            salida = new DataOutputStream(new FileOutputStream("salida.csv", true));

            salida.writeBytes(aux);
            salida.flush();

            JOptionPane.showMessageDialog(null, "Registro Guardado!!!", "Adición de información", JOptionPane.WARNING_MESSAGE);

            salida.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Fuck");
        }
    }

    public DefaultTableModel mostrar() {

        String cadena = null;

        try {

            entrada = new DataInputStream(new FileInputStream("salida.csv"));
            Object fila[] = new Object[8];

            while ((cadena = entrada.readLine()) != null) {

                String campos[] = cadena.split(";");

                fila[0] = campos[0];
                fila[1] = campos[1];
                fila[2] = campos[2];
                fila[3] = campos[3];
                fila[4] = campos[4];
                fila[5] = campos[5];
                fila[6] = campos[6];
                fila[7] = campos[7];

                modelo.addRow(fila);
            }

        } catch (EOFException ex) {
            JOptionPane.showMessageDialog(null, "Información leida, de clic en en boton",
                    "Fin del Archivo", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo", "Leer Archivo",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "Errorsito de E/S", "Leer Archivo",
                    JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }
}
