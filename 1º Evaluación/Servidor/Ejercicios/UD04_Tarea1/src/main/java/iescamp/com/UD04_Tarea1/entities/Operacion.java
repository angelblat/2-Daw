package iescamp.com.UD04_Tarea1.entities;

public class Operacion {

    private String operando1;
    private String operando2;
    private String operador;

    public Operacion() {
    }

    public String getOperando1() {
        return operando1;
    }

    public void setOperando1(String operando1) {
        this.operando1 = operando1;
    }

    public String getOperando2() {
        return operando2;
    }

    public void setOperando2(String operando2) {
        this.operando2 = operando2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "operando1='" + operando1 + '\'' +
                ", operando2='" + operando2 + '\'' +
                ", operador='" + operador + '\'' +
                '}';
    }
}
