package com.proyecto.sistemagestion.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="movimientoDinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double monto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Empleado usuario;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;

    public MovimientoDinero(){

    }

    public MovimientoDinero(double monto, String concepto, Empleado usuario, LocalDate fechaCreacion) {
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
