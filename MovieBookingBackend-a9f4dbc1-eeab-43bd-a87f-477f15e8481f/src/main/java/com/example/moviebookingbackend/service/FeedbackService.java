package com.example.moviebookingbackend.service;


import com.example.moviebookingbackend.model.FeedBack;
import com.example.moviebookingbackend.repository.FeedBackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedBackRepo repository ;

    public FeedBack saveDetails(FeedBack module){
        return repository.save(module);
    }
    public List<FeedBack> getAll (){
        return repository.findAll();
    }
}
