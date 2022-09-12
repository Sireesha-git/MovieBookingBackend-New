package com.example.moviebookingbackend.controller;


import com.example.moviebookingbackend.model.Payment;
import com.example.moviebookingbackend.model.PaymentModel;
import com.example.moviebookingbackend.repository.PaymentRepository;
import com.example.moviebookingbackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PaymentController {

    @Autowired
    private PaymentService paymentService ;

    @Autowired
    private PaymentRepository paymentRepository;
    @PostMapping("/payment")
    public boolean checkPayment(@RequestBody PaymentModel admin) {

        Optional<Payment> value=this.paymentRepository.findById(admin.getCardNumber());
        if(paymentRepository.existsById(admin.getCardNumber()) && value.isPresent()  ) {

            Payment currentAdmin = value.get();

            return  (currentAdmin.getCustomerName().equals(admin.getCustomerName()) && currentAdmin.getCvv().equals(admin.getCvv())
                    && currentAdmin.getExpireDate().equals(admin.getExpireDate()));

        }
        else {

            return false;
        }

    }



}