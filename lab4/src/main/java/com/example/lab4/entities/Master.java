package com.example.lab4.entities;

import com.example.lab4.enumClasses.Role;
import com.example.lab4.wrapper.MasterWrapper;

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
    private String login;
    private String password;
    private LocalDate birthday;
    private Role role;
    @OneToMany(mappedBy = "masterId", cascade = CascadeType.ALL, orphanRemoval = true)
    //    @Column(name="masterId")
    private List<Kotik> mastersCats;

    public Master(){}

    public Master(String name, LocalDate birthday, String login, String password, Role role){
        this.name = name;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
        this.role = role;
        mastersCats = new ArrayList<>();
    }

    public void addCat(Kotik cat){
        mastersCats.add(cat);
        cat.addMaster(this);
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void removeCat(Kotik cat){
        mastersCats.remove(cat);
        cat.removeMaster(this);
    }
    public void setRoles(Role role) {
        this.role = role;
    }

    public Role getRole() { return role; }

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

    public MasterWrapper MasterWrapper(){
        return new MasterWrapper(this.name, this.birthday, this.login, this.password, this.role, this.id, this.mastersCats);
    }
}