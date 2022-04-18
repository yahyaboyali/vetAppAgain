/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.bussiness.concretes;

import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.AnimalService;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.DataResult;
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

}
