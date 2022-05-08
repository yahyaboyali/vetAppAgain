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
import javax.validation.Valid;
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

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView m = new ModelAndView("AfterLogin");
        return m;
        //<button type="button" class="btn btn-secondary btn-floating mb-3" ><a class="nav-link" style="color: black" href="/afterLogin">sign in</a></button>
    }

    @GetMapping("/registerPerson")
    public ModelAndView showPersonAddPage() {
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
    public ModelAndView getByAnimalNameStartsWith(String animalName) {
        ModelAndView m = new ModelAndView("AnimalDetail");
        System.out.println(animalName);
        m.addObject("animals", this.animalService.getByAnimalNameStartsWith(animalName).getData());
        return m;
    }

    @GetMapping("/getByAnimalId")
    public ModelAndView getByAnimalId(@RequestParam int animalId) {
        ModelAndView m = new ModelAndView("index");

        m.addObject("animals", this.animalService.getByAnimalId(animalId).getData());
        return m;
    }

    @GetMapping("/deleteAnimal")
    public ModelAndView deleteAnimal(@RequestParam int animalId) {
        this.animalService.deleteByAnimalId(animalId);
        ModelAndView m = new ModelAndView("AnimalList");
        m.addObject("animals", this.animalService.getAll().getData());
        return m;
    }

    @GetMapping("/AddAnimal")
    public ModelAndView showAnimalAddPage() {
        Animal animal = new Animal();
        ModelAndView m = new ModelAndView("AddAnimal");
        m.addObject("animal", animal);
        return m;
    }

    @PostMapping("/saveAnimal")
    public ModelAndView add(@ModelAttribute("animal") Animal animal) {
        animalService.add(animal);
        ModelAndView m = new ModelAndView("AnimalList");
        m.addObject("animals", this.animalService.getAll().getData());
        return m;
    }

    @GetMapping("/edit/{animalId}")
    public ModelAndView showUpdateForm(@PathVariable("animalId") int animalId) {
        Animal animal = animalService.getByAnimalId(animalId).getData();
        ModelAndView m = new ModelAndView("AnimalUpdate");
        m.addObject("animal", animal);
        return m;
    }

    @PostMapping("/update/{animalId}")
    public ModelAndView updateAnimal(@PathVariable("animalId") int animalId, @Valid Animal animal) {
        animalService.add(animal);
        ModelAndView m = new ModelAndView("AnimalList");
        m.addObject("animals", this.animalService.getAll().getData());
        return m;
    }

}
