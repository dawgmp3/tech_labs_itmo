package com.example.lab3.controller;

import com.example.lab3.entity.Master;
import com.example.lab3.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "masters")
public class MasterController {
    @Autowired
    private MasterService masterService;

    @PostMapping(value = "/addMaster")
    public ResponseEntity<Master> addMaster(@RequestParam String name,
                                            @RequestParam String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return ResponseEntity.ok().body(masterService.addMaster(name, LocalDate.parse(birthday, formatter)));
    }

    @DeleteMapping(value = "/delete")
    public void deleteMaster(@RequestParam Master master){
        masterService.deleteMaster(master);
    }

    @GetMapping(value = "/get")
    public void findMaster(@RequestParam Master master){
        masterService.findMaster(master.getId());
    }
}
