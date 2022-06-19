package com.example.lab4.repos;
import com.example.lab4.entities.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepos extends JpaRepository<Master, Integer> {
    Master findMasterByLogin(String login);
}