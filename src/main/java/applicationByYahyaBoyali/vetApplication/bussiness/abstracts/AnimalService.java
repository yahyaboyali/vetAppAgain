/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.bussiness.abstracts;

import applicationByYahyaBoyali.vetApplication.core.utilities.results.DataResult;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.Result;
import applicationByYahyaBoyali.vetApplication.entities.concretes.Animal;
import java.util.List;

/**
 *
 * @author yahya
 */
public interface AnimalService {

    DataResult<List<Animal>> getAll();

    DataResult<List<Animal>> getByAnimalName(String animalName);

    DataResult<List<Animal>> getByAnimalNameContains(String animalName);

    DataResult<List<Animal>> getByAnimalNameStartsWith(String animalName);

    DataResult<Animal> getByAnimalId(int animalId);

    String deleteByAnimalId(int animalId);

    Result add(Animal animal);
    DataResult<List<Animal>> getByPerson_PersonName(String personName);
    
}
