package page;

import java.util.Date;

public class Farmacia {

    Date fecha;
    int local_id;
    int fk_region;
    int fk_comuna;
    int fk_localidad;
    String local_nombre;
    String comuna_nombre;
    String localidad_nombre;
    String local_direccion;
    String funcionamiento_hora_apertura;
    String funcionamiento_hora_cierre;
    String local_telefono;
    String local_lat;
    String local_lng;
    String funcionamiento_dia;

    public Farmacia(Date fecha, int local_id, int fk_region, int fk_comuna, int fk_localidad, String local_nombre, String comuna_nombre, String localidad_nombre, String local_direccion, String funcionamiento_hora_apertura, String funcionamiento_hora_cierre, String local_telefono, String local_lat, String local_lng, String funcionamiento_dia) {
        this.fecha = fecha;
        this.local_id = local_id;
        this.fk_region = fk_region;
        this.fk_comuna = fk_comuna;
        this.fk_localidad = fk_localidad;
        this.local_nombre = local_nombre;
        this.comuna_nombre = comuna_nombre;
        this.localidad_nombre = localidad_nombre;
        this.local_direccion = local_direccion;
        this.funcionamiento_hora_apertura = funcionamiento_hora_apertura;
        this.funcionamiento_hora_cierre = funcionamiento_hora_cierre;
        this.local_telefono = local_telefono;
        this.local_lat = local_lat;
        this.local_lng = local_lng;
        this.funcionamiento_dia = funcionamiento_dia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getLocal_id() {
        return local_id;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
    }

    public int getFk_region() {
        return fk_region;
    }

    public void setFk_region(int fk_region) {
        this.fk_region = fk_region;
    }

    public int getFk_comuna() {
        return fk_comuna;
    }

    public void setFk_comuna(int fk_comuna) {
        this.fk_comuna = fk_comuna;
    }

    public int getFk_localidad() {
        return fk_localidad;
    }

    public void setFk_localidad(int fk_localidad) {
        this.fk_localidad = fk_localidad;
    }

    public String getLocal_nombre() {
        return local_nombre;
    }

    public void setLocal_nombre(String local_nombre) {
        this.local_nombre = local_nombre;
    }

    public String getComuna_nombre() {
        return comuna_nombre;
    }

    public void setComuna_nombre(String comuna_nombre) {
        this.comuna_nombre = comuna_nombre;
    }

    public String getLocalidad_nombre() {
        return localidad_nombre;
    }

    public void setLocalidad_nombre(String localidad_nombre) {
        this.localidad_nombre = localidad_nombre;
    }

    public String getLocal_direccion() {
        return local_direccion;
    }

    public void setLocal_direccion(String local_direccion) {
        this.local_direccion = local_direccion;
    }

    public String getFuncionamiento_hora_apertura() {
        return funcionamiento_hora_apertura;
    }

    public void setFuncionamiento_hora_apertura(String funcionamiento_hora_apertura) {
        this.funcionamiento_hora_apertura = funcionamiento_hora_apertura;
    }

    public String getFuncionamiento_hora_cierre() {
        return funcionamiento_hora_cierre;
    }

    public void setFuncionamiento_hora_cierre(String funcionamiento_hora_cierre) {
        this.funcionamiento_hora_cierre = funcionamiento_hora_cierre;
    }

    public String getLocal_telefono() {
        return local_telefono;
    }

    public void setLocal_telefono(String local_telefono) {
        this.local_telefono = local_telefono;
    }

    public String getLocal_lat() {
        return local_lat;
    }

    public void setLocal_lat(String local_lat) {
        this.local_lat = local_lat;
    }

    public String getLocal_lng() {
        return local_lng;
    }

    public void setLocal_lng(String local_lng) {
        this.local_lng = local_lng;
    }

    public String getFuncionamiento_dia() {
        return funcionamiento_dia;
    }

    public void setFuncionamiento_dia(String funcionamiento_dia) {
        this.funcionamiento_dia = funcionamiento_dia;
    }
}
