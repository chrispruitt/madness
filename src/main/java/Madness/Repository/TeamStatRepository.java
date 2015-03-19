package Madness.Repository;

import Madness.model.TeamStat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "team", path = "team")
public interface TeamStatRepository extends CrudRepository<TeamStat, String> {

    List<TeamStat> findByName(@Param("name") String name);
    List<TeamStat> findByMarket(@Param("market") String market);

}