package com.example.moviebookingbackend.model;


import lombok.*;

import javax.persistence.*;


@Table
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerid;
    private String email;
    private String userName;
    private String password;
    private String mobileNumber;
    private String location;

    public Customer(CustomerModel customerModel) {
    }
}
