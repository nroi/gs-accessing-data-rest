package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final CountryRepository countryRepository;

    @Autowired
    public DataLoader(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public void run(ApplicationArguments args) {
        Country france = new Country("FR", "France");
        Country germany = new Country("DE", "Germany");
        countryRepository.save(france);
        countryRepository.save(germany);

        Application.log.warn("inserted France with id " + france.getId());
        Application.log.warn("inserted Germany with id " + germany.getId());
    }

}
