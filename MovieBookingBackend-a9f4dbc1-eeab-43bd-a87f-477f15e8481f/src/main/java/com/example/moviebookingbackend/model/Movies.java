package com.example.moviebookingbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieid;
    private String title;
    private String cast;
    private LocalDate date;
    private String language;
    private int price;
    private String showTime;
    private String totalTicket;
    private String image ;
    private String location;

    @ManyToOne
    @JoinColumn(name = "theatreid" , referencedColumnName = "theatreid")
    private Theatre theatre;

    public Movies(MoviesModel moviesModel) {
    }
}
