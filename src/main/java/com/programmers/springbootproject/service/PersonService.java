package com.programmers.springbootproject.service;

import com.programmers.springbootproject.commom.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
  /**
   * List used for persistence. For a real scenario the data persistence showld be implemented using
   * a database or external service
   */
  private List<Person> personList = new ArrayList<>();

  /**
   * Service method that return all the persons
   * 
   * @return List
   */
  public List<Person> getPersonList() {
    return personList;
  }

  /**
   * Service method to add a person
   * 
   * @param person person to add
   */
  public void add(Person person) {
    this.personList.add(person);
  }

  /**
   * Service method to remove a person
   * 
   * @param person person to remove
   */
  public void remove(Person person) {
    this.personList.remove(person);
  }

  /**
   * Service method to search for persons
   * 
   * @param person person parameter to search
   */
  public List<Person> search(Map<String, Object> searchOptions) {
    return this.personList.stream()
        .filter(p -> !searchOptions.containsKey("firstName")
            || searchOptions.get("firstName").equals(p.getFirstName()))
        .filter(p -> !searchOptions.containsKey("lastName")
            || searchOptions.get("lastName").equals(p.getLastName()))
        .filter(
            p -> !searchOptions.containsKey("age") || searchOptions.get("age").equals(p.getAge()))
        .collect(Collectors.toList());
  }
}
