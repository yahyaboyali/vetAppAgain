/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.bussiness.concretes;

import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.AnimalService;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.DataResult;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.ErrorDataResult;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.Result;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.SuccessDataResult;
import applicationByYahyaBoyali.vetApplication.dataAccess.abstracts.AnimalDao;
import applicationByYahyaBoyali.vetApplication.entities.concretes.Animal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yahya
 */
@Service
public class AnimalManager implements AnimalService {

    private AnimalDao animalDao;

    @Autowired
    public AnimalManager(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public DataResult<List<Animal>> getAll() {
        return new SuccessDataResult<List<Animal>>(this.animalDao.findAll(), "listed by getAll");
    }

    @Override
    public DataResult<List<Animal>> getByAnimalName(String animalName) {
        return new SuccessDataResult(this.animalDao.getByAnimalName(animalName), "data Listed by getby animal name");
    }

    @Override
    public DataResult<List<Animal>> getByAnimalNameContains(String animalName) {
        return new SuccessDataResult(this.animalDao.getByAnimalNameContains(animalName), "data listed");
    }

    @Override
    public DataResult<List<Animal>> getByAnimalNameStartsWith(String animalName) {
        return new SuccessDataResult(this.animalDao.getByAnimalNameStartsWith(animalName), "data listed by starts with");
    }

//    @Override
//    public DataResult<List<Animal>> getByAnimalNameLike(String title) {
//        return new SuccessDataResult(this.animalDao.getByAnimalNameLike(title),"listed");
//    }
    @Override
    public DataResult<Animal> getByAnimalId(int animalId) {
        if (this.animalDao.existsById(animalId)) {
            return new SuccessDataResult<Animal>(this.animalDao.getById(animalId), "listed by animal id");
        } else {
            return new ErrorDataResult("data not found");
        }
    }

    @Override
    public String deleteByAnimalId(int animalId) {
        this.animalDao.deleteById(animalId);
        return "deleted";
    }

    @Override
    public Result add(Animal animal) {
        this.animalDao.save(animal);
        return new SuccessDataResult("added");
    }

    @Override
    public DataResult<List<Animal>> getByPerson_PersonName(String personName) {
        return new SuccessDataResult(this.animalDao.getByPerson_PersonName(personName),"data listed by person name");
    }

}
