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

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }

    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable long personId) {
        return personRepository.findById(personId).get();
    }
}
