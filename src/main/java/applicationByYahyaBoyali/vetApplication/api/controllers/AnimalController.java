/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.api.controllers;

import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
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

}
