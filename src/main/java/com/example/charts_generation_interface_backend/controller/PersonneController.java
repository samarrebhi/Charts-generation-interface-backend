package com.example.charts_generation_interface_backend.controller;

import com.example.charts_generation_interface_backend.entity.Gouvernerat;
import com.example.charts_generation_interface_backend.entity.Personne;
import com.example.charts_generation_interface_backend.service.Gouvernerat.IGouverneratService;
import com.example.charts_generation_interface_backend.service.Personne.IPersonneService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Personnes")
public class
PersonneController {




    @Autowired
    @JsonIgnore
    public IPersonneService service;
    @Autowired
    @JsonIgnore
    public IGouverneratService servicegouv;

    //////////////// api for charts generation
    @GetMapping("/getallentities")
    public List<Object> getAllEntities() {
        List<Object> allEntities = new ArrayList<>();


        allEntities.addAll(servicegouv.getAllgouv());

        allEntities.addAll(service.getAllPersonnes());



        return allEntities;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping("/executeSql")
    public ResponseEntity<List<Map<String, Object>>> executeSql(@RequestBody String sqlQuery) {
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sqlQuery);
        return ResponseEntity.ok(results);
    }
    @PostMapping("/addpersonne/{gouverneartid}")
    public Personne addPersonne(@RequestBody Personne personne,@PathVariable Integer gouverneartid) {return service.addPersonne(personne,gouverneartid);}


    @GetMapping("/getpersonnes")
    public ResponseEntity<List<Personne>> getAllPersonnes(){
        List<Personne> liste=service.getAllPersonnes();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deletePersonneyID(@PathVariable("id") Integer id){
        service.deleteById(id);
    }


    @GetMapping("/getbyid/{id}")
    public Personne getPersonneyID(@PathVariable("id") Integer id){return service.findById(id);
    }
    @PutMapping("updatePersonne/{id}")
    Personne updatePersonne(@PathVariable("id") Integer id , @RequestBody Personne personne){
        return  service.editPersonne(id,personne);
    }

    /*@PutMapping("updatePersonne/{id}/{idgouv}")
    Personne updatePersonne(@PathVariable("id") Integer id ,@PathVariable("idgouv") Integer idgouv , @RequestBody Personne personne){
        return  service.editPersonne(id,personne,idgouv);
    }*/

    ////get liste des gouvernerat

    @GetMapping("/getallgouv")
    public ResponseEntity<List<Gouvernerat>> getAllgouv(){
        List<Gouvernerat> liste=servicegouv.getAllgouv();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

}
