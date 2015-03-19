package Madness.Repository;

import Madness.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "team", path = "team")
public interface TeamRepository extends CrudRepository<Team, String> {

    List<Team> findByTeamName(@Param("teamName") String teamName);
    List<Team> findByCollegeName(@Param("collegeName") String collegeName);

}
