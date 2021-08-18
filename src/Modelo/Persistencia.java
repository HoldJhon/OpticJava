package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhon
 */
public class Persistencia {

    //Archivo salida
    File archivoSalida = new File("Datos.csv");

    DataInputStream entrada;
    DataOutputStream salida;

    String encabezado[] = {
        "Id","Fecha", "Nombre", "Apellido", "Cedula", "Telefono", "OI", "OD", "ADD", "DP"
    };

    DefaultTableModel modelo = new DefaultTableModel(null, encabezado);

    ObjectOutputStream out;
    ObjectInputStream in;

    public Persistencia() {

        //Archivo salida
        try {

            if (!archivoSalida.exists()) {
                salida = new DataOutputStream(new FileOutputStream("Datos.csv"));
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de E/S (salida)", "Leer Archivo (salida)",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void adicionarHistoria(Historia historia, String fecha) {

        try {

            String cadena = null;
            int aumentar = 1;
            String filita = "";

            entrada = new DataInputStream(new FileInputStream("Datos.csv"));

            if (archivoSalida.length() == 0) {

                filita = aumentar + "";
            } else {

                while ((cadena = entrada.readLine()) != null) {

                    String campos[] = cadena.split(",");

                    for (int i = 0; i < campos.length; i++) {

                        aumentar = Integer.parseInt(campos[0]);
                        aumentar++;
                        filita = aumentar + "";
                    }
                }

                entrada.close();
            }

            String aux = filita + "," + fecha + "," + historia.getNombre() + "," + historia.getApellido() + "," + historia.getCedula() + "," + historia.getTelefono() + "," + historia.getOi()
                    + "," + historia.getOd() + "," + historia.getAdd() + "," + historia.getDp() + "\n";

            salida = new DataOutputStream(new FileOutputStream("Datos.csv", true));

            salida.writeBytes(aux);
            salida.flush();

            JOptionPane.showMessageDialog(null, "Registro Guardado!!!", "Adición de información", JOptionPane.WARNING_MESSAGE);

            salida.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Fuck");
        }
    }

    public DefaultTableModel mostrar(String busca) {

        String cadena = null;

        if (busca.equals("")) {

            try {

                entrada = new DataInputStream(new FileInputStream("Datos.csv"));
                Object fila[] = new Object[10];

                while ((cadena = entrada.readLine()) != null) {

                    String campos[] = cadena.split(",");

                    for (int i = 0; i < campos.length; i++) {

                        fila[i] = campos[i];
                    }

                    modelo.addRow(fila);
                }

                entrada.close();

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
        } else {

            try {

                entrada = new DataInputStream(new FileInputStream("Datos.csv"));
                Object fila[] = new Object[10];

                while ((cadena = entrada.readLine()) != null) {

                    String campos[] = cadena.split(",");

                    for (int i = 0; i < campos.length; i++) {

                        if (campos[2].equals(busca) || campos[3].equals(busca) || campos[4].equals(busca)) {

                            for (int j = 0; j < campos.length; j++) {

                                fila[j] = campos[j];
                            }

                            modelo.addRow(fila);
                            break;
                        }
                    }

                }

                if (fila[0] == null) {

                    JOptionPane.showMessageDialog(null, "No existe");
                }

                entrada.close();

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
        }

        return modelo;
    }

    public Object[] editar(String edit) {

        String cadena = null;
        Object fila[] = new Object[10];

        if (edit.equals("")) {

            JOptionPane.showMessageDialog(null, "El campo de texto esta vacio");
        } else {

            try {

                entrada = new DataInputStream(new FileInputStream("Datos.csv"));

                while ((cadena = entrada.readLine()) != null) {

                    String campos[] = cadena.split(",");

                    if (campos[4].equals(edit)) {

                        for (int i = 0; i < campos.length; i++) {

                            fila[i] = campos[i];
                        }

                        break;
                    }

                }

                if (fila[0] == null) {

                    JOptionPane.showMessageDialog(null, "No existe");
                }

                entrada.close();

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
        }

        return fila;
    }
}
