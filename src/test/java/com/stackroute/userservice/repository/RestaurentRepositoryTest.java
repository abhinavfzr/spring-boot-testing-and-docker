package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Restaurent;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RestaurentRepositoryTest {

    @Autowired
    private RestaurentRepository restaurentRepository;
    private Restaurent restaurent;


    @Before
    public void setUp() throws Exception {
        restaurent= new Restaurent();
        restaurent.setId("100");
        restaurent.setRestaurent_name("dhaba");
        restaurent.setRestaurent_img("img");
        restaurent.setRestaurent_location("delhi");
    }

    @After
    public void tearDown() throws Exception {
        restaurentRepository.deleteAll();
    }
    @Test
    public void testSaveUser(){
        restaurentRepository.save(restaurent);
        Restaurent fetchUser = restaurentRepository.findById(restaurent.getId()).get();
        assertEquals("100",fetchUser.getId());

    }

    @Test
    public void testSaveUserFailure(){
        Restaurent testUser = new Restaurent("201","Harry","john","Harry123");
        restaurentRepository.save(restaurent);
        Restaurent fetchUser = restaurentRepository.findById(restaurent.getId()).get();
        assertNotSame(testUser,restaurent);
    }

    @Test
    public void testGetAllUser(){
        Restaurent u = new Restaurent("102","Johny","Jenny","Johny12");
        Restaurent u1 = new Restaurent("103","Harry","Jenny","Harry12");
        restaurentRepository.save(u);
        restaurentRepository.save(u1);

        List<Restaurent> list = restaurentRepository.findAll();
        Assert.assertEquals("Johny",list.get(0).getRestaurent_name());

    }
}