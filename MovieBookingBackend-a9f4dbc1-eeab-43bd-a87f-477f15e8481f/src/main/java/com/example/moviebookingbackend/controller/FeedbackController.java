package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.model.FeedBack;
import com.example.moviebookingbackend.model.FeedbackModel;
import com.example.moviebookingbackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class FeedbackController {

    @Autowired
    private FeedbackService service ;

    @PostMapping("/add")
    public FeedBack saveData(@RequestBody FeedbackModel feedbackModel ){
        FeedBack feedBack=new FeedBack(feedbackModel);
        return service.saveDetails(feedBack);
    }
    @GetMapping("/get")
    public List<FeedBack> getModule() {
        return service.getAll();
    }
}
