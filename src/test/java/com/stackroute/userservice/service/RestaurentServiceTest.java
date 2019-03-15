package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.repository.RestaurentRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class RestaurentServiceTest {



    private Restaurent restaurent;

    //Create a mock for UserRepository
    @Mock
    private RestaurentRepository restaurentRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private RestaurentService restaurentService;
    List<Restaurent> list= null;


    @Before
    public void setUp() throws Exception {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        restaurent= new Restaurent();
        restaurent.setId("100");
        restaurent.setRestaurent_name("dhaba");
        restaurent.setRestaurent_img("img");
        restaurent.setRestaurent_location("delhi");
        list = new ArrayList<>();
        list.add(restaurent);
    }

    @After
    public void tearDown() throws Exception {
        restaurentRepository.deleteAll();
    }

    @Test
    public void saveUserTestSuccess() {

        when(restaurentRepository.save((Restaurent) any())).thenReturn(restaurent);
        Restaurent savedUser = restaurentService.saveRest(restaurent);
        Assert.assertEquals(restaurent,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(restaurentRepository,times(1)).save(restaurent);

    }


    @Test
    public void getAllUser(){

        restaurentRepository.save(restaurent);
        //stubbing the mock to return specific data
        when(restaurentRepository.findAll()).thenReturn(list);
        List<Restaurent> userlist = restaurentService.getALLRest();
        assertEquals(list,userlist);
    }
}