package com.example.moviebookingbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Table
@Data
@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingid;
    private LocalDate bookingDate;
    private int totalNoTicket ;
    private int totalCost ;

    @ManyToOne
    @JoinColumn(name = "movieid" , referencedColumnName = "movieid")
    private Movies movies ;

    @ManyToOne
    @JoinColumn(name = "customerid" , referencedColumnName = "customerid")
    private Customer customer;

    public Bookings(BookingsModel bookingsModel) {

    }
}
