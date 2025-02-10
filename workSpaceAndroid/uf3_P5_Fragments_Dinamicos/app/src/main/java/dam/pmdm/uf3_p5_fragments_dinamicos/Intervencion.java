package dam.pmdm.uf3_p5_fragments_dinamicos;

public class Intervencion {

    private String fecha;
    private String motivo;
    private String observacion;

    public Intervencion(String fecha, String motivo, String observacion) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.observacion = observacion;
    }

    // alt + ins

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
