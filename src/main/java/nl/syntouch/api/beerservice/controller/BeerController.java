package nl.syntouch.api.beerservice.controller;

import nl.syntouch.api.beerservice.dto.BeerDto;
import nl.syntouch.api.beerservice.model.Beer;
import nl.syntouch.api.beerservice.service.BeerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.OffsetDateTime;
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
    public List<BeerDto> getBeers(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam OffsetDateTime offsetDateTime) {
        return modelMapper.map(beerService.getBeer(offsetDateTime), new TypeToken<List<BeerDto>>() {}.getType());
    }

    @DeleteMapping("/{name}")
    public void deleteBeer(@PathVariable String name) {
        beerService.deleteBeerByName(name);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void postBeer(@Valid @RequestBody BeerDto beerDto) {
        beerService.saveBeer(modelMapper.map(beerDto, Beer.class));
    }

}
