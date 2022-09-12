package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingsRepo extends JpaRepository<Bookings , Integer> {
    @Query("select sum(totalCost) from Bookings where movies.theatre.theatreid=:theatreid")
    int getBookingsByBookingidtotal(@Param("theatreid") int theatreid);

}
