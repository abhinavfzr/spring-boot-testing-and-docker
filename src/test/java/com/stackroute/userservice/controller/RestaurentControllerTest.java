package com.stackroute.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.service.RestaurentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
public class RestaurentControllerTest {



    @Autowired
    private MockMvc mockMvc;
    private Restaurent restaurent;
    @MockBean
    private RestaurentService restaurentService;
    @InjectMocks
    private RestaurentController restaurentController;

    private List<Restaurent> list =null;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restaurentController).build();
        restaurent = new Restaurent();
        restaurent.setId("100");
        restaurent.setRestaurent_name("dhaba");
        restaurent.setRestaurent_img("img");
        restaurent.setRestaurent_location("delhi");
        list = new ArrayList();
        list.add(restaurent);
    }

    @Test
    public void saveRestaurents() throws Exception{
        when(restaurentService.saveRest(any())).thenReturn(restaurent);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurent")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurent)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void getALlRestaurents() throws Exception{
        when(restaurentService.getALLRest()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurents")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurent)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


}