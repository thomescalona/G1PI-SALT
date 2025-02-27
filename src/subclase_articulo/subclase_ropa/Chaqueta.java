package com.iescamp.PROYECTO;

public class Chaqueta extends Ropa {

    private boolean impermeable;

    public Chaqueta(String codigoArticulo, String nombre, float precio, String marca, String descripcion, String imagen, Material material, boolean activo, int talla, String color, String tipoCierre, boolean impermeable) {
        super(codigoArticulo, nombre, precio, marca, descripcion, imagen, material, activo, talla, color, tipoCierre);
        this.impermeable = impermeable;
    }

    public boolean isImpermeable() {
        return impermeable;
    }

    public void setImpermeable(boolean impermeable) {
        this.impermeable = impermeable;
    }

    @Override
    public String toString() {
        return "Chaqueta{" +
                "impermeable=" + impermeable +
                '}';
    }

    public void mostrarDetalles(){
        if (impermeable){
            System.out.println(getNombre() + " y soy impermeable");

        }else {
            System.out.println(getNombre() + " y no soy impermeable");
        }

    }
}
