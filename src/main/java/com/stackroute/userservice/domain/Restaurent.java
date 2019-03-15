package com.stackroute.userservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Document(collection = "Restaurent")
public class Restaurent {
    @Id
    String id;
    @NotNull
    String restaurent_name;
    @NotNull
    String restaurent_img;
    @NotNull
    String restaurent_location;

    public Restaurent(String restaurent_name, String restaurent_img, String restaurent_location) {
        this.restaurent_name = restaurent_name;
        this.restaurent_img = restaurent_img;
        this.restaurent_location = restaurent_location;
    }

    public Restaurent() {
    }

    public Restaurent(String id, String restaurent_name, String restaurent_img, String restaurent_location) {
        this.id = id;
        this.restaurent_name = restaurent_name;
        this.restaurent_img = restaurent_img;
        this.restaurent_location = restaurent_location;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurent_name() {
        return restaurent_name;
    }

    public void setRestaurent_name(String restaurent_name) {
        this.restaurent_name = restaurent_name;
    }

    public String getRestaurent_img() {
        return restaurent_img;
    }

    public void setRestaurent_img(String restaurent_img) {
        this.restaurent_img = restaurent_img;
    }

    public String getRestaurent_location() {
        return restaurent_location;
    }

    public void setRestaurent_location(String restaurent_location) {
        this.restaurent_location = restaurent_location;
    }
}
