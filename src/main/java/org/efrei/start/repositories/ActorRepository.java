package org.efrei.start.repositories;

import org.efrei.start.models.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, String> {

}
