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

  public Person getPerson(Integer id) {
    return personList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
  }

  /**
   * Service method to add a person
   * 
   * @param person person to add
   */
  public void save(Person person) {
    if (personList.contains(person)) {
      personList.remove(person);
      personList.add(person);
    } else {
      this.personList.add(person);
    }
  }

  /**
   * Service method to remove a person
   * 
   * @param person person to remove
   */
  public void remove(Integer id) {
    this.personList.removeIf(p -> p.getId().equals(id));
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
        .collect(Collectors.toList());
  }
}
