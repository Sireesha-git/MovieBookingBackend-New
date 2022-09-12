package com.example.moviebookingbackend.service;
import com.example.moviebookingbackend.model.Payment;
import com.example.moviebookingbackend.model.PaymentModel;
import com.example.moviebookingbackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public boolean checkPayment(PaymentModel admin) {
        if(paymentRepository.existsById(admin.getCardNumber())) {
            Payment currentAdmin = paymentRepository.findById(admin.getCardNumber()).get();

            return  (currentAdmin.getCustomerName().equals(admin.getCustomerName()) && currentAdmin.getCvv().equals(admin.getCvv())
                    && currentAdmin.getExpireDate().equals(admin.getExpireDate()));

        }else {

            return false;
        }

    }
}
