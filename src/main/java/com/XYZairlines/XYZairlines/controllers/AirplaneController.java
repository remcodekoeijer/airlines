package com.XYZairlines.XYZairlines.controllers;

import com.XYZairlines.XYZairlines.NotFoundException;
import com.XYZairlines.XYZairlines.models.Airplane;
import com.XYZairlines.XYZairlines.models.Location;
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
            throw new NotFoundException("Plane with id is not found.");
        }
        return findAirplane.get();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Airplane createOnePlane(@RequestBody Airplane airplane){
        return airplaneRepository.save(airplane);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Airplane addFuel(@PathVariable long id){
        Optional <Airplane> findAirplane = airplaneRepository.findById(id);
        if(!findAirplane.isPresent()){
            throw new NotFoundException("Plane with id is not found.");
        }
        findAirplane.get().setToMaxFuel();
        return airplaneRepository.save(findAirplane.get());
    }

//    @RequestMapping(value = "fly/{location}", method = RequestMethod.PUT)
//    public Airplane flyToLocation(@PathVariable Location newLocation, @RequestBody Airplane airplane){
//        if(airplane == null)
//            throw new NotFoundException("Airplane not found. Body is null.");
//
//        long id = airplane.getId();
//        Optional <Airplane> findAirplane = airplaneRepository.findById(id);
//        if(!findAirplane.isPresent()){
//            throw new NotFoundException("Plane with id is not found.");
//        }
//
//        boolean exists = false;
//        for (Location location : Location.values()) {
//            if(newLocation == location){
//                exists = true;
//                break;
//            }
//        }
//        if(exists == false)
//            throw new NotFoundException("No valid location");
//
//        airplane.setCurrentLocation(newLocation);
//        return airplaneRepository.save(airplane);
//
//
//    }
}
