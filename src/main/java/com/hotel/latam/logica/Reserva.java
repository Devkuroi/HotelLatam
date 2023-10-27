package com.hotel.latam.logica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reservas")
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private LocalDate fecha_checkIn;
    
    private LocalDate fecha_checkOut;
    
    private BigDecimal valor;
    
    private String formaDePago;

    public Reserva() {
    
    }

    public Reserva(LocalDate fecha_checkIn, LocalDate fecha_checkOut, BigDecimal valor, String formaDePago) {
        this.fecha_checkIn = fecha_checkIn;
        this.fecha_checkOut = fecha_checkOut;
        this.valor = valor;
        this.formaDePago = formaDePago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha_checkIn() {
        return fecha_checkIn;
    }

    public void setFecha_checkIn(LocalDate fecha_checkIn) {
        this.fecha_checkIn = fecha_checkIn;
    }
    
    public void setFecha_checkIn(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fecha_checkIn = LocalDate.parse(fechaStr, formatter);
    }

    public LocalDate getFecha_checkOut() {
        return fecha_checkOut;
    }

    public void setFecha_checkOut(LocalDate fecha_checkOut) {
        this.fecha_checkOut = fecha_checkOut;
    }
    
    public void setFecha_checkOut(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fecha_checkOut = LocalDate.parse(fechaStr, formatter);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }
    
    
}
