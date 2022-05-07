/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.bussiness.abstracts;

import applicationByYahyaBoyali.vetApplication.core.utilities.Dtos.PersonEmailPasswordDto;
import applicationByYahyaBoyali.vetApplication.core.utilities.entities.Person;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.DataResult;
import applicationByYahyaBoyali.vetApplication.core.utilities.results.Result;

/**
 *
 * @author yahya
 */
public interface PersonService {
    Result add(Person person);
    DataResult getByEmailAndPassword(PersonEmailPasswordDto personEmailPasswordDto);
}
