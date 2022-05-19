package com.example.lab3.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate birthday;
    @OneToMany(mappedBy = "masterId", cascade = CascadeType.ALL, orphanRemoval = true)
//    @Column(name="masterId")
    private List<Kotik> mastersCats;

    public Master(){}

    public Master(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
        mastersCats = new ArrayList<>();
    }

    public void addCat(Kotik cat){
        mastersCats.add(cat);
        cat.addMaster(this);
    }

    public void removeCat(Kotik cat){
        mastersCats.remove(cat);
        cat.removeMaster(this);
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

    public List<Kotik> getMastersCats(){
        return mastersCats;
    }
}