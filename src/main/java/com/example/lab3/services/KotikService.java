package com.example.lab3.services;

import com.example.lab3.entity.Kotik;
import com.example.lab3.entity.Master;
import com.example.lab3.enumClasses.Breed;
import com.example.lab3.enumClasses.Color;
import com.example.lab3.repos.KotikRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class KotikService {
    @Autowired
    private KotikRepos kotikRepos;

    public KotikService(KotikRepos kotikRepos) {
        this.kotikRepos = kotikRepos;
    }

    public Kotik addKotik(String name, LocalDate birthday, Breed breed, Color color, Master master){
        Kotik kotik = new Kotik(name,  birthday, breed, color, master);
        return kotikRepos.save(kotik);
    }

    public Kotik findKotik(Integer id) {
        Kotik kotik = kotikRepos.findById(id).get();
        return kotik;
    }

    public Collection<Kotik> findByColor(Color color){
        return kotikRepos.findByColor(color);
    }

    public Collection<Kotik> findByBreed(Breed breed){
        return kotikRepos.findByBreed(breed);
    }

    public Collection<Kotik> findByMasterId(Integer masterId){
        return kotikRepos.findByMasterId(masterId);
    }

    public void deleteKotik(Kotik kotik) {
        kotikRepos.delete(kotik);
    }
}
