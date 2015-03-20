package Madness.Repository;

import Madness.model.GameBoxScore;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "boxscore", path = "boxscore")
public interface GameStatRepository extends CrudRepository<GameBoxScore, String> {

    List<GameBoxScore> findByStatus(@Param("status") String status);
}