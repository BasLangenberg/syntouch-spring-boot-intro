package nl.syntouch.api.beerservice.controller;

import nl.syntouch.api.beerservice.dto.BeerDto;
import nl.syntouch.api.beerservice.model.Beer;
import nl.syntouch.api.beerservice.service.BeerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/beer")
public class BeerController {

    private final BeerService beerService;
    private final ModelMapper modelMapper;

    public BeerController(BeerService beerService, ModelMapper modelMapper) {
        this.beerService = beerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BeerDto> getBeers() {
        return modelMapper.map(beerService.getBeer(), new TypeToken<List<BeerDto>>() {}.getType());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void postBeer(@RequestBody BeerDto beerDto) {
        beerService.saveBeer(modelMapper.map(beerDto, Beer.class));
    }

}
