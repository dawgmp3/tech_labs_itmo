package entity;

import enumClasses.Breed;
import enumClasses.Color;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "kotiki")
public class Kotik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private LocalDate birthday;
    private Breed breed;
    private Color color;
    @Column(name = "master")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MastersCats")
    private Master masterId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Kotik> friends;

    public Kotik(){}

    public Kotik(String name, LocalDate birthday, Breed breed, Color color, Master master) {
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.color = color;
        masterId = master;
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

    public UUID getId(){
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
}
