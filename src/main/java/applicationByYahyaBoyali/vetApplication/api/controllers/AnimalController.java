/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.api.controllers;

import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.AnimalService;
import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.PersonService;
import applicationByYahyaBoyali.vetApplication.core.utilities.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yahya
 */
@RestController
@RequestMapping("/")
@CrossOrigin
public class AnimalController {

    private AnimalService animalService;
    private PersonService personService;
//    @Autowired
//    public AnimalController(AnimalService animalService) {
//        this.animalService = animalService;
//    }
    @Autowired
    public AnimalController(PersonService personService, AnimalService animalService){
      this.animalService=animalService;
      this.personService=personService;
       
    }

    @GetMapping("/")
    public ModelAndView mainPage() {
        ModelAndView m = new ModelAndView("index");
        return m;
    }

    @GetMapping("/AnimalList")
    public ModelAndView getAnimalList() {
        ModelAndView m = new ModelAndView("animalList");
        m.addObject("animals", animalService.getAll().getData());
        return m;
    }
    @GetMapping("/afterLogin")
     public ModelAndView AfterLogin() {
        ModelAndView m = new ModelAndView("AfterLogin");
        return m;
    }
     @GetMapping("/registerPerson")
    public ModelAndView showAnimalAddPage() {
        Person person = new Person();
        ModelAndView m = new ModelAndView("RegisterPerson");
        m.addObject("person", person);
        return m;
    }
    @PostMapping("/registerPersonMethod")
    public ModelAndView registerPerson(@ModelAttribute("person") Person person) {
        personService.add(person);
        ModelAndView m = new ModelAndView("index");
        return m;
    }

}
