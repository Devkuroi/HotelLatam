package com.hotel.latam.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Huespedes")
public class Huesped implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="huested_id")
    private Long id;
    
    private String nombre;
    
    private String apellido;
    
    private LocalDate fechaDeNacimiento;
    
    private String nacionalidad;
    
    private String telefono;
    
    @OneToOne
    private Reserva reserva;

    public Huesped() {
    
    }

    public Huesped(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono, Reserva reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.reserva = reserva;
    }

    public Huesped(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    public void setFechaDeNacimiento(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fechaDeNacimiento = LocalDate.parse(fechaStr, formatter);
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
}
