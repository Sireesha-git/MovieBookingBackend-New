package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.model.Theatre;
import com.example.moviebookingbackend.model.TheatreModel;
import com.example.moviebookingbackend.repository.TheatreRepo;
import com.example.moviebookingbackend.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TheatreController {

    @Autowired
    private TheatreService service ;

    @Autowired
    private TheatreRepo repository ;


    // theatre register

    @PostMapping("/theatre")
    public Theatre saveData(@RequestBody TheatreModel theatreModel){
        Theatre theatre=new Theatre(theatreModel);
        return service.saveData(theatre);
    }

    //theatre login
    @PostMapping("/TheatreLogin")
    public int loginUser(@RequestBody TheatreModel theatreModel) throws IllegalAccessException {
        String tempEmailId = theatreModel.getTheatreEmail();
        String tempPass = theatreModel.getPassword();
        Theatre userObj = null;
        if(tempEmailId != null && tempPass != null) {
            userObj = service.fetchUserByEmailAndPassword(tempEmailId, tempPass);
        }
        if(userObj == null) {
            throw new IllegalAccessException("Bad credentials");
        }
        return userObj.getTheatreid();
    }



    @GetMapping("/findAll")
    public List<Theatre> getData(){
        return repository.findAll();
    }



    @GetMapping("TheatreBy/{id}")
    public Theatre findMoviesById(@PathVariable int id) {
        return service.getMovieById(id);
    }



    @GetMapping("/Revenue/{theatreid}/{bookingDate}/{endDate}")
    public ResponseEntity<Double> calculateRevenue(@PathVariable(value="theatreid")int id, @PathVariable(value = "bookingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate bookingDate, @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return service.calculateRevenue(id,bookingDate,endDate);
    }

}
