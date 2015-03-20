package Madness.Repository;

import Madness.model.TeamBoxScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "teamboxscore", path = "teamboxscore")
public interface TeamStatRepository extends CrudRepository<TeamBoxScore, String> {

    List<TeamBoxScore> findByName(@Param("name") String name);
    List<TeamBoxScore> findByMarket(@Param("market") String market);

}
