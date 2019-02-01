package md.codefacotry.homework.controller;

import md.codefacotry.homework.domain.Country;
import md.codefacotry.homework.exceptions.CountryNotFoundException;
import md.codefacotry.homework.repositories.CountryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IndexController {

    private CountryRepository countryRepository;

    public IndexController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("api/countries")
    private List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("api/countries/{id}")
    private Country getCountryById(@PathVariable Long id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);

        return optionalCountry.isPresent() ? optionalCountry.get() : null;
    }

    @PostMapping("api/countries")
    private Country addNewCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @PutMapping("api/countries/{id}")
    private Country updateCountry(@RequestBody Country country,
                                  @PathVariable Long id) {

        Optional<Country> countryOptional = countryRepository.findById(id);

        if (!countryOptional.isPresent()) throw new CountryNotFoundException();

        Country updatedCountry = countryOptional.get();
        updatedCountry.setName(country.getName());
        updatedCountry.setCapital(country.getCapital());

        return countryRepository.save(updatedCountry);
    }

    @DeleteMapping("api/countries/{id}")
    private Country deleteCountry(@PathVariable Long id) {

        Optional<Country> countryOptional = countryRepository.findById(id);

        if (!countryOptional.isPresent()) throw new CountryNotFoundException();

        countryRepository.deleteById(id);

        return countryOptional.get();
    }
}
