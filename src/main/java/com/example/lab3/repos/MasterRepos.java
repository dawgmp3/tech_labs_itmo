package com.example.lab3.repos;
import com.example.lab3.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepos extends JpaRepository<Master, Integer> {
}
