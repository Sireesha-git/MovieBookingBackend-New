package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.model.Bookings;
import com.example.moviebookingbackend.model.BookingsModel;
import com.example.moviebookingbackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class BookingController {

    @Autowired
    private BookingService bookingService ;



    @PostMapping("/addBooking")
    public Bookings saveData(@RequestBody BookingsModel bookingsModel){
        Bookings bookings=new Bookings(bookingsModel);
        return bookingService.saveData(bookings);
    }



    @GetMapping("BookingId/{id}")
    public Bookings findBookingId(@PathVariable int id) {
        return bookingService.getBookings(id);
    }

    @GetMapping("SumBooking/{theatreid}")
    public int getBookingsByBookingidtotal(@PathVariable int theatreid){
        return bookingService.getBookingsByBookingidtotal(theatreid);
    }







}
