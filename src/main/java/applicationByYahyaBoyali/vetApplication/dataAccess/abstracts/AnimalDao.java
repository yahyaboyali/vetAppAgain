/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.dataAccess.abstracts;

import applicationByYahyaBoyali.vetApplication.entities.concretes.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yahya
 */
public interface AnimalDao extends JpaRepository<Animal, Integer>{
    
}
