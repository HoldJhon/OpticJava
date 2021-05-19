package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    Calendar fesha = new GregorianCalendar();
    String fecha;

    String encabezado[] = {
        "Fecha", "Nombre", "Apellido", "Cedula", "Telefono", "OI", "OD", "ADD", "DP"
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
            int temp = fesha.get(Calendar.MONTH) + 1;

            String aux = fesha.get(Calendar.DATE) + "/" + temp + "/" + fesha.get(Calendar.YEAR)
                    + ";" + historia.getNombre() + ";" + historia.getApellido() + ";" + historia.getCedula() + ";" + historia.getTelefono() + ";" + historia.getOi()
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

    public DefaultTableModel mostrar(String busca) {

        String cadena = null;

        if (busca.equals("")) {

            try {

                entrada = new DataInputStream(new FileInputStream("salida.csv"));
                Object fila[] = new Object[9];

                while ((cadena = entrada.readLine()) != null) {

                    String campos[] = cadena.split(";");

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

                entrada = new DataInputStream(new FileInputStream("salida.csv"));
                Object fila[] = new Object[9];

                while ((cadena = entrada.readLine()) != null) {

                    String campos[] = cadena.split(";");

                    for (int i = 0; i < campos.length; i++) {

                        if (campos[i].equals(busca)) {

                            for (int j = 0; j < campos.length; j++) {

                                fila[j] = campos[j];
                            }

                            modelo.addRow(fila);
                            break;
                        }
                    }

                }
                
                if(fila[0] == null){
                    
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
}
