package com.example.charts_generation_interface_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Table(name="Gouvernerat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gouvernerat implements Serializable {
    @Id

    private Integer gouverneratId ;
    private String gouverneratLibelle;

    @OneToMany(mappedBy="personneGouvernerat",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnoreProperties("personneGouvernerat")
    List<Personne> personneList =new ArrayList<>();
}
