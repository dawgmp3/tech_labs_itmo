package com.example.lab4.controller;

import com.example.lab4.entities.Master;
import com.example.lab4.enumClasses.Role;
import com.example.lab4.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping
public class MasterController {
    private final MasterService masterService;

    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @RequestMapping(value = "/admin/addMaster")
    public ResponseEntity<Master> addMaster(@RequestParam String name,
                                            @RequestParam String birthday,
                                            @RequestParam String login,
                                            @RequestParam String password,
                                            @RequestParam String role) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return ResponseEntity.ok().body(masterService.addMaster(name, LocalDate.parse(birthday, formatter),
                                        login, password, Role.valueOf(role)));
    }

    @GetMapping(value = "/")
    public String Hello(){
        return "hello";
    }

    @RequestMapping(value = "/user/deleteMaster")
    public void deleteMaster(@RequestParam Master master){
        masterService.deleteMaster(master);
    }

    @GetMapping(value = "/admin/getMaster")
    public ResponseEntity findMaster(@RequestParam Integer id){
        Master master = masterService.findMaster(id);
        return ResponseEntity.ok().body(master.MasterWrapper());
    }
}