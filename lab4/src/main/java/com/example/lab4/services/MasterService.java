package com.example.lab4.services;

import com.example.lab4.entities.Kotik;
import com.example.lab4.entities.Master;
import com.example.lab4.enumClasses.Role;
import com.example.lab4.repos.MasterRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MasterService {
    @Autowired
    private MasterRepos masterRepos;

    public MasterService(MasterRepos masterRep) {
        this.masterRepos = masterRep;
    }

    public Master addMaster(String name, LocalDate birthday, String login, String password, Role role){
        Master master = new Master(name, birthday, login, password, role);
        return masterRepos.save(master);
    }

    public Master findMaster(Integer id) {
        return masterRepos.findById(id).get();
    }

    public void saveMaster(Master master) {
        masterRepos.save(master);
    }

    public void deleteMaster(Master master) {
        masterRepos.delete(master);
    }

    public Master findByLogin(String login){
       return masterRepos.findMasterByLogin(login);
    }

    public List<Master> findAllMasters() {
        return masterRepos.findAll();
    }
}