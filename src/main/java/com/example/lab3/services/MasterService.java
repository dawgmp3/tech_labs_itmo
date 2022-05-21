package com.example.lab3.services;

import com.example.lab3.entity.Kotik;
import com.example.lab3.entity.Master;
import com.example.lab3.repos.MasterRepos;
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

    public Master addMaster(String name, LocalDate birthday){
        Master master = new Master(name, birthday);
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

    public List<Master> findAllMasters() {
        return masterRepos.findAll();
    }
}
