package com.ideagen.pojo.exp.webservice.springweb.controller;

import com.ideagen.pojo.exp.model.dto.person.PersonDto;
import com.ideagen.pojo.exp.service.person.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    @GetMapping({"/", ""})
    public String showAllPersons(Model model) {
        model.addAttribute("main_greetings", "Welcome");
        model.addAttribute("greetings", "Hi there");
        model.addAttribute("persons", personService.findAll());
        return "hello";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("person", new PersonDto());
        return "register";
    }

    @PostMapping("/completeRegistration")
    public String completeRegistration(@ModelAttribute PersonDto personDto) {
        personService.savePerson(personDto);
        return "redirect:/person/register";
    }

    @PostMapping(value = "/rest/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addPersonApi(@RequestBody PersonDto personDto) {
        try {
            return ResponseEntity.ok(personService.savePerson(personDto));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/rest/get/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getPersonApi(@PathVariable String name) {
        try {
            return ResponseEntity.ok(personService.findPersonByName(name));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}