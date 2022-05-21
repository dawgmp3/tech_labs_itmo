package com.example.lab3.repos;
import com.example.lab3.entity.Kotik;
import com.example.lab3.enumClasses.Breed;
import com.example.lab3.enumClasses.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface KotikRepos extends JpaRepository<Kotik, Integer> {
    Collection<Kotik> findByColor(Color color);
    Collection<Kotik> findByBreed(Breed breed);
    Collection<Kotik> findByMasterId(Integer masterId);
}
