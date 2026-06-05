package edu.uce.ec.domain.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignatura")
@NamedQueries({
    @NamedQuery(name = "Asignatura.findNivel", query = "SELECT a FROM Asignatura a WHERE a.nivel = :nivel"),
    @NamedQuery(name = "Asignatura.findNombre", query = "SELECT a FROM Asignatura a WHERE a.nombre LIKE :texto"),
    @NamedQuery(name = "Asignatura.countAll", query = "SELECT COUNT(a) FROM Asignatura a")
})
public class Asignatura {

    @Id
    @SequenceGenerator(name = "asignatura_seq", sequenceName = "asignatura_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignatura_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "codigo", unique = true)
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "creditos")
    private Integer creditos;
    
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
