package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.exception.RestaurentAlreadyException;
import com.stackroute.userservice.exception.RestaurentNotFoundException;
import com.stackroute.userservice.service.RestaurentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class RestaurentController {
    private RestaurentService restaurentService;

    @Autowired
    public RestaurentController(RestaurentService restaurentService) {

        this.restaurentService = restaurentService;
    }

    //this method will add new restaurent
    @PostMapping("/restaurent")
    public ResponseEntity<?> saveRestaurents(@RequestBody Restaurent restaurent) {
        ResponseEntity responseEntity;

            restaurentService.saveRest(restaurent);
            responseEntity = new ResponseEntity<String>("succefullly created", HttpStatus.CREATED);
        return responseEntity;
    }

    // this method will get all restaurents
    @GetMapping("restaurents")
    public List<Restaurent> getALlRestaurents() {
        List<Restaurent> list = restaurentService.getALLRest();
        return list;
    }


}
