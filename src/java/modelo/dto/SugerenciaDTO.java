package modelo.dto;

import java.sql.Timestamp;

public class SugerenciaDTO {

    private int id;
    private String tipo_documento;
    private String nro_documento;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String celular;
    private String correo;
    private String observaciones;
    private byte[] imagen;
    private String pedido_consumidor;
    private Timestamp fecha;

    public SugerenciaDTO() {
    }
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getPedido_consumidor() {
        return pedido_consumidor;
    }

    public void setPedido_consumidor(String pedido_consumidor) {
        this.pedido_consumidor = pedido_consumidor;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
