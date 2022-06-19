package com.example.lab4.wrapper;

import com.example.lab4.entities.Kotik;
import com.example.lab4.enumClasses.Role;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MasterWrapper {
    private Integer id;
    private String name;
    private String login;
    private String password;
    private LocalDate birthday;
    private Role role;
    private List<Kotik> mastersCats;

    public MasterWrapper(String name, LocalDate birthday, String login, String password, Role role, Integer id, List<Kotik> kotiks){
        this.name = name;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
        this.role = role;
        mastersCats = new ArrayList<>();
        this.id = id;
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
}
