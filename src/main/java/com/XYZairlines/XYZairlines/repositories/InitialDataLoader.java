package com.XYZairlines.XYZairlines.repositories;

import com.XYZairlines.XYZairlines.models.Airplane;
import com.XYZairlines.XYZairlines.models.Airport;
import com.XYZairlines.XYZairlines.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialDataLoader {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private AirportRepository airportRepository;

    @PostConstruct
    public void create(){
        List<Airplane> airplanes1 = new ArrayList<>();
        List<Airplane> airplanes2 = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Airplane airplane = new Airplane();
            airplane.setCurrentFuel(i*1000);
            if(i%2 == 0)
                airplanes1.add(airplane);
            else
                airplanes2.add(airplane);
            airplaneRepository.save(airplane);
        }

        Airport airport1 = new Airport();
        Airport airport2 = new Airport();
        airport1.setLocation(Location.AMSTERDAM);
        airport2.setLocation(Location.LONDON);
        airport1.setAirplanes(airplanes1);
        airport2.setAirplanes(airplanes2);
        airportRepository.save(airport1);
        airportRepository.save(airport2);
    }
}
