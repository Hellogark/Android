package com.example.supdude.appcomidita;

public class datosMenu {
    public String nombrePlato;
    public String descripcion;
    public Double precio;

    public datosMenu(String nombrePlato, String descripcion, Double precio, Double subT, Integer imagenComida, Integer cantidad) {
        this.nombrePlato = nombrePlato;
        this.descripcion = descripcion;
        this.precio = precio;
        this.subT = subT;
        this.imagenComida = imagenComida;
        this.cantidad = cantidad;
    }

    public Double getSubT() {
        return subT;
    }

    public void setSubT(Double subT) {
        this.subT = subT;
    }

    public Double subT;
    public Integer imagenComida;
    public Integer cantidad;

    public datosMenu(){
        nombrePlato="";
        descripcion="";
        precio= 0.0;
        imagenComida=0;
        cantidad=0;
    }

    public datosMenu(String nombrePlato, String descripcion, Double precio, Integer imagenComida, Integer cantidad){
        this.nombrePlato = nombrePlato;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenComida = imagenComida;
        this.cantidad = cantidad;
    }

    public datosMenu(String nombrePlato, String descripcion, Double precio) {
        this.nombrePlato = nombrePlato;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getImagenComida() {
        return imagenComida;
    }

    public void setImagenComida(Integer imagenComida) {
        this.imagenComida = imagenComida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
