package com.hotel.latam.logica;

import com.hotel.latam.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    // CRUD Huesped
    
    public void saveHuesped(Huesped huesped) {
        controlPersis.saveHuesped(huesped);
    }
    
    public List<Huesped> ListHuesped () {
        return controlPersis.ListHuespedes();
    }
    
    public Huesped SearchHuesped(Long id) {
        return controlPersis.SearchHuesped(id);
    }
    
    public List<Huesped> SearchHuesped(String nombre) {
        return controlPersis.SearchHuesped(nombre);
    }
    
    public void deleteHuesped(Long id) {
        controlPersis.deleteHuesped(id);
    }
    
    public void editHuesped(Huesped huesped) {
        controlPersis.editHuesped(huesped);
    }
    
    // CRUD Reserva
    
    public void saveReserva(Reserva reserva) {
        controlPersis.saveReserva(reserva);
    }
    
    public List<Reserva> ListReserva () {
        return controlPersis.ListReserva();
    }
    
    public Reserva SearchReserva(Long id) {
        return controlPersis.SearchReserva(id);
    }
    
    public void deleteReserva(Long id) {
        controlPersis.deleteReserva(id);
    }
    
    public void editReserva(Reserva reserva) {
        controlPersis.editReserva(reserva);
    }
}
