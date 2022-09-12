package com.example.moviebookingbackend.controller;


import com.example.moviebookingbackend.model.PaymentModel;
import com.example.moviebookingbackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PaymentController {

    @Autowired
    private PaymentService paymentService ;

    @PostMapping("/payment")
    public ResponseEntity<Boolean> checkPayment(@RequestBody PaymentModel paymentModel){
        return new ResponseEntity<>(paymentService.checkPayment(paymentModel), HttpStatus.OK);
    }

}