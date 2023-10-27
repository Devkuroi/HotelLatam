package com.hotel.latam.persistencia;

import com.hotel.latam.logica.Huesped;
import com.hotel.latam.logica.Reserva;
import com.hotel.latam.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        

public class ControladoraPersistencia {
    
    HuespedJpaController huesJpa = new HuespedJpaController();
    ReservaJpaController reserJpa = new ReservaJpaController();
    
    //Persistence Huesped
    
    public void saveHuesped(Huesped huesped) {
        huesJpa.create(huesped);
    }
    
    public List<Huesped> ListHuespedes() {
        return huesJpa.findHuespedEntities();
    }
    
    public Huesped SearchHuesped(Long id) {
        return huesJpa.findHuesped(id);
    }
    
    public List<Huesped> SearchHuesped(String nombre) {
        return huesJpa.findHuesped(nombre);
    }
    
    public void deleteHuesped(Long id) {
        try {
            huesJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editHuesped(Huesped huesped) {
        try {
            huesJpa.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Persistence Reserva
    
    public void saveReserva(Reserva reserva) {
        reserJpa.create(reserva);
    }
    
    public List<Reserva> ListReserva() {
        return reserJpa.findReservaEntities();
    }
    
    public Reserva SearchReserva(Long id) {
        return reserJpa.findReserva(id);
    }
    
    public void deleteReserva(Long id) {
        try {
            reserJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editReserva(Reserva reserva) {
        try {
            reserJpa.edit(reserva);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
