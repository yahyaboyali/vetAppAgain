/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.dataAccess.abstracts;

import applicationByYahyaBoyali.vetApplication.entities.concretes.Animal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author yahya
 */
public interface AnimalDao extends JpaRepository<Animal, Integer> {

    List<Animal> getByAnimalName(String animalName);

    List<Animal> getByAnimalNameContains(String animalName);

    List<Animal> getByAnimalNameStartsWith(String animalName);
    
    List<Animal> getByPerson_PersonName(String personName);
    
//    @Query("FROM Animal a WHERE a.animalName LIKE '%:title%'")
//    List<Animal> getByAnimalNameLike(@Param("title") String title);
}
