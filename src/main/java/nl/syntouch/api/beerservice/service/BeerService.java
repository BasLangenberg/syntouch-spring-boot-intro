package nl.syntouch.api.beerservice.service;

import nl.syntouch.api.beerservice.model.Beer;
import nl.syntouch.api.beerservice.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public void saveBeer(Beer beer) {
        beerRepository.save(beer);
    }

    public List<Beer> getBeer() {
        return beerRepository.findAll();
    }
}
