/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.api.controllers;

import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.AnimalService;
import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.PersonService;
import applicationByYahyaBoyali.vetApplication.core.utilities.Dtos.PersonEmailPasswordDto;
import applicationByYahyaBoyali.vetApplication.core.utilities.entities.Person;
import applicationByYahyaBoyali.vetApplication.entities.concretes.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public AnimalController(PersonService personService, AnimalService animalService) {
        this.animalService = animalService;
        this.personService = personService;

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

//    @GetMapping("/AnimalListSearch/{keyword}")
//    public ModelAndView getAnimalStartsWith(@PathVariable("keyword") String keyword) {
//        ModelAndView m = new ModelAndView("AnimalDetail");
//        m.addObject("animals", this.animalService.getByAnimalNameStartsWith(keyword).getData());
//        return m;
//    }
//    @GetMapping("/afterLogin")
//     public ModelAndView AfterLogin() {
//        ModelAndView m = new ModelAndView("AfterLogin");
//        return m;
//    }
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView m = new ModelAndView("AfterLogin");
        return m;
        //<button type="button" class="btn btn-secondary btn-floating mb-3" ><a class="nav-link" style="color: black" href="/afterLogin">sign in</a></button>
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

    @GetMapping("/getByAnimalName/{animalName}")
    public ModelAndView getByAnimalName(@PathVariable("animalName") String animalName) {
        ModelAndView m = new ModelAndView("AnimalDetail");
        m.addObject("animals", this.animalService.getByAnimalName(animalName).getData());
        return m;
    }

    @GetMapping("/StartsWith")
    public ModelAndView getByAnimalNameStartsWith(String keyword) {
        ModelAndView m = new ModelAndView("AnimalDetail");
        System.out.println(keyword);
        m.addObject("animals", this.animalService.getByAnimalNameStartsWith(keyword).getData());
        System.out.println(this.animalService.getByAnimalNameStartsWith(keyword).getData());
        return m;
    }

}
