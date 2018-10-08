package com.XYZairlines.XYZairlines.controllers;

import com.XYZairlines.XYZairlines.NotFoundException;
import com.XYZairlines.XYZairlines.models.Airplane;
import com.XYZairlines.XYZairlines.models.Airport;
import com.XYZairlines.XYZairlines.repositories.AirplaneRepository;
import com.XYZairlines.XYZairlines.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/airport/")
public class AirportController {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirplaneRepository airplaneRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Airport getOneAirport(@PathVariable long id){
        Optional<Airport> findAirport = airportRepository.findById(id);
        if(!findAirport.isPresent()){
            throw new NotFoundException("Airport with id is not found.");
        }
        return findAirport.get();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Airport createOneAirport(@RequestBody Airport airport){
        return airportRepository.save(airport);
    }
}
