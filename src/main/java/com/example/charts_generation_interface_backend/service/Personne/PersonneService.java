package com.example.charts_generation_interface_backend.service.Personne;

import com.example.charts_generation_interface_backend.entity.Gouvernerat;
import com.example.charts_generation_interface_backend.entity.Personne;
import com.example.charts_generation_interface_backend.repository.GouverneratRepository;
import com.example.charts_generation_interface_backend.repository.PersonneRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Service
@AllArgsConstructor
public class PersonneService implements IPersonneService {
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
GouverneratRepository gouverneratRepository;
    @Override
    @Transactional
    public Personne addPersonne(Personne person, Integer gouverneratId) {

        Gouvernerat gouvernerat = gouverneratRepository.findById(gouverneratId)
                .orElseThrow(() -> new EntityNotFoundException("Gouvernerat with ID " + gouverneratId + " not found"));


        person.setPersonneGouvernerat(gouvernerat);


        return personneRepository.save(person);
    }


    @Override
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    @Override
    public Personne findById(Integer id) {
        return personneRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        if (!personneRepository.existsById(id)) {
            throw new EmptyResultDataAccessException("Personne with ID " + id + "does not exist", 1);
        }
        personneRepository.deleteById(id);
    }
    @Override
    public Personne editPersonne(Integer id, Personne personne) {
        if (personneRepository.findById(id).isPresent()) {
            Personne personne1 = personneRepository.findById(id).get();
            //Gouvernerat gouv=gouverneratRepository.findById(idgouv).get();
            personne1.setPersonneGouvernerat(personne.getPersonneGouvernerat());
            personne1.setPersonneMail(personne.getPersonneMail());
            personne1.setPersonnePrenom(personne.getPersonnePrenom());
            personne1.setPersonneNom(personne.getPersonneNom());

            return personneRepository.save(personne1);
        }
        return null;
    }


    }



