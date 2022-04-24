/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.bussiness.concretes;

import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.PersonService;
import applicationByYahyaBoyali.vetApplication.core.dataAccess.PersonDao;
import applicationByYahyaBoyali.vetApplication.core.utilities.entities.Person;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.Result;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yahya
 */
@Service
public class PersonManager implements PersonService {

    private PersonDao personDao;

    @Autowired
    public PersonManager(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Result add(Person person) {
        this.personDao.save(person);
         return new SuccessResult("kullanıcı eklendi");
    }

}
