package com.example.lab3.controller;

import com.example.lab3.entity.Kotik;
import com.example.lab3.enumClasses.Breed;
import com.example.lab3.enumClasses.Color;
import com.example.lab3.services.KotikService;
import com.example.lab3.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "kotiki")
public class KotikController {
    @Autowired
    private KotikService kotikService;
    @Autowired
    private MasterService masterService;

    @PostMapping(value = "/addKotik")
    public ResponseEntity<Kotik> addKotik(@RequestParam String name,
                                            @RequestParam String birthday,
                                            @RequestParam Breed breed,
                                            @RequestParam Color color,
                                            @RequestParam Integer master) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return ResponseEntity.ok().body(kotikService.addKotik(name, LocalDate.parse(birthday, formatter),
                                                                        breed, color, masterService.findMaster(master)));
    }

    @DeleteMapping(value = "/delete")
    public void deleteKotik(@RequestParam Kotik kotik) {
        kotikService.deleteKotik(kotik);
    }

    @GetMapping(value = "/get")
    public ResponseEntity findKotik(@RequestParam Integer kotik) {
        return ResponseEntity.ok().body(kotikService.findKotik(kotik));
    }

    @GetMapping(value="/findByColor")
    public void findByColor(@RequestParam Color color){
        kotikService.findByColor(color);
    }

    @GetMapping(value="/findByBreed")
    public void findByBreed(@RequestParam Breed breed){
        kotikService.findByBreed(breed);
    }

    @GetMapping(value="/findByMasterId")
    public void findByMasterId(@RequestParam Integer masterId){
        kotikService.findByMasterId(masterId);
    }
}
