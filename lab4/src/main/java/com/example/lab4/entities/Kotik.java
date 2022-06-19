package com.example.lab4.entities;

import com.example.lab4.enumClasses.Breed;
import com.example.lab4.enumClasses.Color;
import com.example.lab4.wrapper.KotikWrapper;
import com.example.lab4.wrapper.MasterWrapper;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kotiki")
public class Kotik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate birthday;
    private Breed breed;
    private Color color;
    //    @Column(name = "master")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "masterid")
    private Master masterId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Kotik> friends;

    public Kotik(){}

    public Kotik(String name, LocalDate birthday, Breed breed, Color color, Master masterId) {
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.color = color;
        this.masterId = masterId;
        friends = new ArrayList<>();
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

    public KotikWrapper KotikWrapper(){
        return new KotikWrapper(this.name, this.birthday, this.breed, this.color, this.masterId, this.id);
    }
}