package com.programmers.springbootproject.controller;

import com.programmers.springbootproject.commom.Person;
import com.programmers.springbootproject.service.PersonService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for Person
 * 
 * @author robin
 *
 */

// TODO improve exception handling, add return messages for all controllers
@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  /**
   * List all persons
   * 
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ResponseEntity<List<Person>> list() {
    return new ResponseEntity<>(personService.getPersonList(), HttpStatus.OK);
  }

  @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
  public ResponseEntity<Person> get(@PathVariable Integer id) {
    return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
  }

  /**
   * Search for persons
   * 
   * @param searchOptions
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/search", method = RequestMethod.POST)
  public ResponseEntity<List<Person>> search(@RequestBody Map<String, Object> searchOptions) {
    return new ResponseEntity<>(personService.search(searchOptions), HttpStatus.OK);
  }

  /**
   * Add a person
   * 
   * @param person
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ResponseEntity<Void> save(@RequestBody Person person) {
    personService.save(person);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * Remove a person
   * 
   * @param person
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
  public ResponseEntity<Void> remove(@PathVariable Integer id) {
    personService.remove(id);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
