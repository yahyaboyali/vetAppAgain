/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.entities.concretes;

import applicationByYahyaBoyali.vetApplication.core.utilities.entities.Person;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yahya
 */
@Entity
@Data
@Table(name = "animal")
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private int animalId;

    @Column(name = "animal_name")
    private String animalName;
    
    @Column(name = "species")
    private String species;
    
    @Column(name = "genus")
    private String genus;
    
    @Column(name = "animal_age")
    private int animalAge;
    
    @Column(name = "explanation")
    private String explanation;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private Person person;

}
