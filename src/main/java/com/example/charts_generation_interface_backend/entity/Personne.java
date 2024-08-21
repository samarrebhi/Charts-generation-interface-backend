package com.example.charts_generation_interface_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="Personne")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personneId ;


    private String personneNom;

    private String personnePrenom;

    private String personneMail;

  /* private Integer personneGouvernerat;*/

    @ManyToOne
    //@JoinColumn(name = "gouvernerat_id", nullable = false)
    @JsonIgnoreProperties("personneList")
    private Gouvernerat personneGouvernerat;


}
