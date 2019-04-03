package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String countryCodeIso;

    private String description;

    public Country(final String countryCodeIso, final String description) {
        this.countryCodeIso = countryCodeIso;
        this.description = description;
    }

    public String getCountryCodeIso() {
        return countryCodeIso;
    }

    public void setCountryCodeIso(final String countryCodeIso) {
        this.countryCodeIso = countryCodeIso;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }
}
