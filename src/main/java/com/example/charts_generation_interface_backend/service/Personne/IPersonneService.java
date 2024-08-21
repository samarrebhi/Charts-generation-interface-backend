package com.example.charts_generation_interface_backend.service.Personne;

import com.example.charts_generation_interface_backend.entity.Personne;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IPersonneService {
   /* Personne addPersonne(Personne person);
*/
    @Transactional
    Personne addPersonne(Personne person, Integer gouverneratId);

    List<Personne> getAllPersonnes();

    Personne findById(Integer id);

    void deleteById(Integer id);

 Personne editPersonne(Integer id, Personne personne);

 //Personne editPersonne(Integer id, Personne personne, Integer idgouv);
}


