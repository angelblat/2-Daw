package iescamp.com.ud04_tarea4.entities;

import java.util.ArrayList;

public class PedidoPizza {
    private String size, formaPago, nombre, direccion, instruccionesEspeciales;
    private ArrayList<String> ingredientes = new ArrayList<>();
    private boolean extraQueso = false;

    public PedidoPizza(String size, String formaPago, String nombre, String direccion, String instruccionesEspeciales, ArrayList<String> ingredientes, boolean extraQueso) {
        this.size = size;
        this.formaPago = formaPago;
        this.nombre = nombre;
        this.direccion = direccion;
        this.instruccionesEspeciales = instruccionesEspeciales;
        this.ingredientes = ingredientes;
        this.extraQueso = extraQueso;
    }

    public PedidoPizza() {
    }


    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isExtraQueso() {
        return extraQueso;
    }

    public void setExtraQueso(boolean extraQueso) {
        this.extraQueso = extraQueso;
    }

    public String getInstruccionesEspeciales() {
        return instruccionesEspeciales;
    }

    public void setInstruccionesEspeciales(String instruccionesEspeciales) {
        this.instruccionesEspeciales = instruccionesEspeciales;
    }

}
