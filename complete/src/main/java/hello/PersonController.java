package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonRepository personRepository ;

    @Autowired
    public PersonController(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable long personId) {
        return personRepository.findById(personId).get();
    }

    /*
     * Example usage: curl -i -X POST -H "Content-Type:application/json" -d '{"firstName": "Frodo", "lastName": "Baggins", "country": {"id": 1}}' http://localhost:8080/person_return
     */

    @PostMapping("/person_return")
    public Person personReturn(@RequestBody Person person) {
        return person;
    }

    @PostMapping("/person_save_and_return")
    public Person personSaveAndReturn(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }

    @PostMapping("/person_save_and_return_by_id")
    public Person personSaveAndReturnById(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        Person samePerson = personRepository.findById(savedPerson.getId()).get();
        return samePerson;
    }

}
