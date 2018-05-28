package com.example.supdude.appcomidita;

import android.graphics.Bitmap;

import java.io.Serializable;

public class datosLocal implements Serializable {
    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String nombreLocal;
    public String mail;
    public String contra;
    public String direccion;
    public double lat,longitud;
    public String tel1,tel2;
    public String horario;

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    public datosLocal(String nombreLocal, String mail, String direccion, String tel1) {
        this.nombreLocal = nombreLocal;
        this.mail = mail;
        this.direccion = direccion;
        this.tel1 = tel1;
    }

    public datosLocal(Double lat, Double lon) {
        this.lat = lat;
        this.longitud = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String sitio;
    public int logo;

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public datosLocal(String nombreLocal, String sitio, String direccion, int logo, String tel1, String horario){
        this.nombreLocal = nombreLocal;
        this.sitio = sitio;
        this.direccion = direccion;
        this.logo = logo;
        this.tel1 = tel1;
        this.horario = horario;
    }








    public datosLocal(String nombreLocal, String mail, String contra, String direccion, String tel1, String tel2, String sitio, int tipoLocal, String categoria, int tipoCuenta) {
        this.nombreLocal = nombreLocal;
        this.mail = mail;
        this.contra = contra;
        this.direccion = direccion;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.sitio = sitio;
        this.tipoLocal = tipoLocal;
        this.categoria = categoria;
        this.tipoCuenta = tipoCuenta;
    }

    public datosLocal(String nombreLocal, String mail, String contra, double lat, double longitud) {
        this.nombreLocal = nombreLocal;
        this.mail = mail;
        this.contra = contra;
        this.lat = lat;
        this.longitud = longitud;
    }

    public int getTipoLocal() {
        return tipoLocal;

    }

        String desayuno="Desayuno";
    String comida = "Comida";
    String cena="Cena";
    String cafe="Café";
    String bares="bares";
    int tipoLocal;
    String categoria;

    public datosLocal(String nombreLocal, String direccion, String tel1, String sitio, String categoria) {
        this.nombreLocal = nombreLocal;
        this.direccion = direccion;
        this.tel1 = tel1;
        this.sitio = sitio;
        this.categoria = categoria;
    }

    public String getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(String desayuno) {
        this.desayuno = desayuno;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public String getBares() {
        return bares;
    }

    public void setBares(String bares) {
        this.bares = bares;
    }

    public void setTipoLocal(int tipoLocal) {
        this.tipoLocal = tipoLocal;
    }



    public int tipoCuenta;

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombComida() {
        return nombComida;
    }

    public void setNombComida(String nombComida) {
        this.nombComida = nombComida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    String nombComida, descripcion;

String lunes;
    String martes;
    String miercoles;

    public datosLocal(String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo) {
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    String jueves;
    String viernes;
    String sabado;

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    public datosLocal(String nombreLocal,String direccion , String tel1, String sitio, String categoria, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo) {
        this.nombreLocal = nombreLocal;

        this.direccion = direccion;
        this.tel1 = tel1;
        this.sitio = sitio;
        this.categoria = categoria;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public datosLocal(String nombreLocal, String direccion) {
        this.nombreLocal = nombreLocal;
        this.direccion = direccion;
    }


    String domingo;

    Double precio;

}
