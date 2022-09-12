package com.example.moviebookingbackend.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
public class BookingsModel {
    private LocalDate bookingDate;
    private int totalNoTicket ;
    private int totalCost ;

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTotalNoTicket() {
        return totalNoTicket;
    }

    public void setTotalNoTicket(int totalNoTicket) {
        this.totalNoTicket = totalNoTicket;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
