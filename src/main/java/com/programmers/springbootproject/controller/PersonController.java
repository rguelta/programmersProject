package com.programmers.springbootproject.controller;

import com.programmers.springbootproject.commom.Person;
import com.programmers.springbootproject.service.PersonService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<List<Person>> list() {
    return new ResponseEntity<>(personService.getPersonList(), HttpStatus.OK);
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
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity<Void> add(@RequestBody Person person) {
    personService.add(person);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Remove a person
   * 
   * @param person
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/remove", method = RequestMethod.POST)
  public ResponseEntity<Void> remove(@RequestBody Person person) {
    personService.remove(person);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
