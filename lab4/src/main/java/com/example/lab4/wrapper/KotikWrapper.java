package com.example.lab4.wrapper;

import com.example.lab4.entities.Kotik;
import com.example.lab4.entities.Master;
import com.example.lab4.enumClasses.Breed;
import com.example.lab4.enumClasses.Color;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KotikWrapper {
    private Integer id;
    private String name;
    private LocalDate birthday;
    private Breed breed;
    private Color color;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "masterid")
    private Master masterId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Kotik> friends;

    public KotikWrapper(String name, LocalDate birthday, Breed breed, Color color, Master master, Integer kotikId) {
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.color = color;
        masterId = master;
        friends = new ArrayList<>();
        this.id = kotikId;

    }

    public void addMaster(Master master){
        masterId = master;
    }

    public void removeMaster(Master master){
        masterId = null;
    }

    public void addFriend(Kotik cat){
        friends.add(cat);
    }

    public void removeFriend(Kotik cat){
        friends.remove(cat);
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public Breed getBreed(){
        return breed;
    }

    public Color getColor(){
        return color;
    }

    public Master getMaster(){ return masterId; }
}
