package com.XYZairlines.XYZairlines.repositories;

import com.XYZairlines.XYZairlines.models.Airport;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository //CrudRepository<Model, Id-type>
public interface AirportRepository extends CrudRepository<Airport, Long> {
}