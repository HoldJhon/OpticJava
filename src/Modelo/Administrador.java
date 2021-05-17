package Modelo;

import java.util.ArrayList;

public class Administrador {
    
    private ArrayList<Historia> listaHistoria = new ArrayList<>();

    public ArrayList<Historia> getListaHistoria() {
        return listaHistoria;
    }

    public void setListaHistoria(ArrayList<Historia> listaHistoria) {
        this.listaHistoria = listaHistoria;
    }
}