package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.exception.RestaurentAlreadyException;
import com.stackroute.userservice.exception.RestaurentNotFoundException;
import com.stackroute.userservice.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurentService
{
    private RestaurentRepository restaurentRepository;


    public RestaurentService(RestaurentRepository restaurentRepository) {
        this.restaurentRepository = restaurentRepository;
    }

    public Restaurent saveRest(Restaurent restaurent)
    {

      Restaurent restaurent1= restaurentRepository.save(restaurent);
      return restaurent1;
    }
    public List<Restaurent> getALLRest(){
     return (List<Restaurent>)restaurentRepository.findAll();
    }

}
