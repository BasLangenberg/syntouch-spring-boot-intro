package nl.syntouch.api.beerservice.repository;

import nl.syntouch.api.beerservice.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
}
