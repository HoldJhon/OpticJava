package Modelo;

import java.io.Serializable;

/**
 *
 * @author jhon
 */
public class Admin implements Serializable{

    private String nombre, clave;

    public Admin(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }
}
