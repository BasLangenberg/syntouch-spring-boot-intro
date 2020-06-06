package nl.syntouch.api.beerservice.service;

import nl.syntouch.api.beerservice.model.Beer;
import nl.syntouch.api.beerservice.repository.BeerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public void saveBeer(Beer beer) {
        beerRepository.save(beer);
    }

    public List<Beer> getBeer(OffsetDateTime offsetDateTime) {
        return beerRepository.findAllByBrewDateBefore(offsetDateTime);
    }

    public Optional<Beer> getBeerById(long id) {
        return beerRepository.findById(id);
    }

    public void deleteBeerByName(String name) {
        beerRepository.deleteByName(name);
    }
}
