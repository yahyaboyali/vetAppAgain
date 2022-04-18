/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationByYahyaBoyali.vetApplication.api.controllers;

import applicationByYahyaBoyali.vetApplication.bussiness.abstracts.AnimalService;
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
    @GetMapping("/")
    public ModelAndView mainPage(){
        ModelAndView m = new ModelAndView("index");
        return m;
    }
}
