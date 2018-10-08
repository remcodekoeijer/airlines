package com.XYZairlines.XYZairlines.repositories;

import com.XYZairlines.XYZairlines.models.Airplane;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository //CrudRepository<Model, Id-type>
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
}
