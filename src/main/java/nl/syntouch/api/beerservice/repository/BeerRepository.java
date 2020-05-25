package nl.syntouch.api.beerservice.repository;

import nl.syntouch.api.beerservice.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findAllByBrewDateBefore(OffsetDateTime voor);
    void deleteByName(String name);
}
