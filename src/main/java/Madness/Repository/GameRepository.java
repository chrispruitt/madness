package Madness.Repository;

import Madness.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "game", path = "game")
public interface GameRepository extends CrudRepository<Game, String> {

}