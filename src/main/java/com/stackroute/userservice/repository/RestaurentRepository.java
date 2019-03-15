package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Restaurent;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RestaurentRepository extends MongoRepository<Restaurent, String> {

}
