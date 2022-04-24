/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.core.dataAccess;

import applicationByYahyaBoyali.vetApplication.core.utilities.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yahya
 */
public interface PersonDao extends JpaRepository<Person, Integer> {
    
}
