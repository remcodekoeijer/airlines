package com.XYZairlines.XYZairlines.controllers;

import com.XYZairlines.XYZairlines.NotFoundException;
import com.XYZairlines.XYZairlines.models.Airplane;
import com.XYZairlines.XYZairlines.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/airplane/")
public class AirplaneController {

    @Autowired
    AirplaneRepository airplaneRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Airplane> getAllPlanes(){
        return airplaneRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Airplane getOnePlane(@PathVariable long id){
        Optional <Airplane> findAirplane = airplaneRepository.findById(id);
        if(!findAirplane.isPresent()){
            //todo;
            //Make a 404 plane not found exception
            throw new NotFoundException("Plane with id is not found.");
        }
        return findAirplane.get();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Airplane createOnePlane(@RequestBody Airplane airplane){
        return airplaneRepository.save(airplane);
    }
}
