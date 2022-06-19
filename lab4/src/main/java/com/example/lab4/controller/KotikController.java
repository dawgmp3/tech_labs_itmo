package com.example.lab4.controller;

import com.example.lab4.entities.Kotik;
import com.example.lab4.entities.Master;
import com.example.lab4.enumClasses.Breed;
import com.example.lab4.enumClasses.Color;
import com.example.lab4.services.KotikService;
import com.example.lab4.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@RestController
@RequestMapping
public class KotikController {
    private final KotikService kotikService;
    private final MasterService masterService;

    public KotikController(KotikService kotikService, MasterService masterService) {
        this.kotikService = kotikService;
        this.masterService = masterService;
    }

    @RequestMapping(value = "/user/addKotik")
    public ResponseEntity<Kotik> addKotik(@RequestParam String name,
                                          @RequestParam String birthday,
                                          @RequestParam Breed breed,
                                          @RequestParam Color color,
                                          @RequestParam Integer master) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return ResponseEntity.ok().body(kotikService.addKotik(name, LocalDate.parse(birthday, formatter),
                breed, color, masterService.findMaster(master)));
    }

    @RequestMapping(value = "/admin/deleteKotik")
    public void deleteKotik(@RequestParam Kotik kotik) {
        kotikService.deleteKotik(kotik);
    }

    @GetMapping(value = "/admin/getKotik")
    public ResponseEntity findKotik(@RequestParam Integer kotik) {
        Kotik kot = kotikService.findKotik(kotik);
        return ResponseEntity.ok().body(kot.KotikWrapper());
    }

    @GetMapping(value="/admin/findByColor")
    public void findByColor(@RequestParam Color color){
        kotikService.findByColor(color);
    }

    @GetMapping(value="/admin/findByBreed")
    public void findByBreed(@RequestParam Breed breed){
        kotikService.findByBreed(breed);
    }

    @GetMapping(value="/admin/findByMasterId")
    public void findByMasterId(@RequestParam Integer masterId){
        kotikService.findByMasterId(masterId);
    }

    @GetMapping(value = "/user/findMastersKotiki")
    public ResponseEntity findMastersKotiki(){
        Collection<Kotik> kotiki;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Master master = masterService.findByLogin(authentication.getName());
        kotiki = kotikService.findByMasterId(master.getId());
        return new ResponseEntity(kotiki, HttpStatus.OK);
    }
}