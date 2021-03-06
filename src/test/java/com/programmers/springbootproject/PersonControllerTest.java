package com.programmers.springbootproject;

import static org.assertj.core.api.Assertions.assertThat;

import com.programmers.springbootproject.commom.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  private Map<String, Object> searchOptions = new HashMap<>();
  private Person person = new Person();

  @Before
  public void setUp() {
    this.searchOptions.put("firstName", "Robin");
    this.searchOptions.put("lastName", "Guelta");
    this.searchOptions.put("id", 1);

    this.person.setFirstName("Robin");
    this.person.setLastName("Guelta");
    this.person.setId(1);
  }

  @Test
  public void testSavePerson() throws Exception {
    ResponseEntity<Void> responseEntity =
        this.restTemplate.postForEntity("/person/save", this.person, Void.class);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  }

  @Test
  public void testListPerson() throws Exception {
    this.restTemplate.postForEntity("/person/save", this.person, Void.class);

    ResponseEntity<?> responseEntity =
        this.restTemplate.getForEntity("/person/list", List.class, Void.class);

    assertThat(responseEntity.getBody().toString())
        .isEqualTo("[{firstName=Robin, lastName=Guelta, id=1}]");
  }

  @Test
  public void testRemovePerson() throws Exception {
    this.restTemplate.postForEntity("/person/save", this.person, Void.class);

    ResponseEntity<Void> responseEntity =
        this.restTemplate.getForEntity("/person/remove/1", null, Void.class);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  }

  @Test
  public void testSearchPerson() throws Exception {
    this.restTemplate.postForEntity("/person/save", this.person, Void.class);

    ResponseEntity<?> responseEntity =
        this.restTemplate.postForEntity("/person/search", this.searchOptions, List.class);

    assertThat(responseEntity.getBody().toString())
        .isEqualTo("[{firstName=Robin, lastName=Guelta, id=1}]");
  }
}
