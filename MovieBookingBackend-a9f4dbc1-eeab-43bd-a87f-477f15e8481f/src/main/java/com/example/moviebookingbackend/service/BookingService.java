package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Bookings;
import com.example.moviebookingbackend.repository.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingsRepo repository ;

    public Bookings saveData(Bookings bookings){
        return repository.save(bookings);
    }
    public Bookings getBookings(int id) {
        return repository.findById(id).orElse(null);
    }


    public int getBookingsByBookingidtotal(int theatreid){
        return repository.getBookingsByBookingidtotal(theatreid);
    }


}
