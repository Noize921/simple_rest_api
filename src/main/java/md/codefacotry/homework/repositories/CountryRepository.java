package md.codefacotry.homework.repositories;

import md.codefacotry.homework.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    @Override
    List<Country> findAll();

    void deleteById(Long id);
}
