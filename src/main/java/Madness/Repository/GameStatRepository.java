package Madness.Repository;

import Madness.model.GameStat;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "game", path = "game")
public interface GameStatRepository extends CrudRepository<GameStat, String> {

    List<GameStat> findByStatus(@Param("status") String status);
}