package edu.uce.ec.auditable;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registros_auditoria")
public class AuditRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nombre_metodo")
    private String nombreMetodo;

    @Column(name = "argumentos")
    private String argumentos;

    @Column(name = "fecha_ejecucion")
    private LocalDateTime fechaHoraEjecucion;

    @Column(name = "tiempo_ms")
    private Long tiempoEjecucionMs;

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public void setArgumentos(String argumentos) {
        this.argumentos = argumentos;
    }

    public void setFechaHoraEjecucion(LocalDateTime fechaHoraEjecucion) {
        this.fechaHoraEjecucion = fechaHoraEjecucion;
    }

    public void setTiempoEjecucionMs(Long tiempoEjecucionMs) {
        this.tiempoEjecucionMs = tiempoEjecucionMs;
    }
}
