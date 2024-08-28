package com.example.charts_generation_interface_backend.service.Personne;

import com.example.charts_generation_interface_backend.entity.Personne;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IPersonneService {

    @Transactional
    Personne addPersonne(Personne person, Integer gouverneratId);

    List<Personne> getAllPersonnes();

    Personne findById(Integer id);

    void deleteById(Integer id);

 Personne editPersonne(Integer id, Personne personne);


}


