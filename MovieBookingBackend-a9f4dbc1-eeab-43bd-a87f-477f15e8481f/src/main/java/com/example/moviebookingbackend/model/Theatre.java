package com.example.moviebookingbackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Table
@Data
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int theatreid;
    private String theatreName ;
    private String theatreEmail ;
    private String password ;

    public Theatre(TheatreModel theatreModel) {
    }
}
