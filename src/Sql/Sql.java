package Sql;

import Modelo.Historia;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Sql extends SqlConnection {

    java.sql.Statement st;
    ResultSet rs;
    Historia objHistoria = new Historia();

    String encabezado[] = {
        "Cedula", "Apellido", "Nombre", "Telefono", "OI", "OD", "ADD", "DP"
    };

    DefaultTableModel modelo = new DefaultTableModel(null, encabezado);

    public void insertar(Historia historia) {

        try {

            Connection conexion = conectar();
            st = conexion.createStatement();

            String sqlC = "insert into clientes(cedula, apellido, nombre, telefono)"
                    + "values ('" + historia.getCedula() + "', '" + historia.getApellido() + "', '" + historia.getNombre() + "', '" + historia.getTelefono() + "');";

            String sqlH = "insert into historias (cedulaCliente, oi, od, add, dp)"
                    + "values ('" + historia.getCedula() + "', '" + historia.getOi() + "', '" + historia.getOd() + "', '" + historia.getAdd() + "', '" + historia.getDp() + "');";

            st.execute(sqlC);
            st.execute(sqlH);

            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocurrió un error" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel mostrar(String cedula, Boolean vacio) {
        try {

            String donde = ";";
            if(!vacio){
                
                donde = "where c.cedula = '" + cedula + "';";
            }
            
            Connection conexion = conectar();
            st = conexion.createStatement();

            String sql = "select c.cedula, c.apellido, c.nombre, c.telefono, h.oi, h.od, h.\"add\", h.dp "
                    + "from clientes c join historias h on (c.cedula = h.cedulacliente) "
                    + donde;

            System.out.println(sql);
            rs = st.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();

            int cantidadCol = rsmd.getColumnCount();

            while (rs.next()) {

                Object[] fila = new Object[cantidadCol];
                for (int i = 0; i < cantidadCol; i++) {

                    fila[i] = rs.getObject(i + 1);
                }

                modelo.addRow(fila);
            }

            st.close();
            conexion.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocurrió un error" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }
}
