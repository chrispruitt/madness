package Repository;

import model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "team", path = "team")
public interface TeamRepo extends CrudRepository<Team, Long> {

    List<Team> findByTeamName(@Param("teamName") String teamName);
    List<Team> findByCollegeName(@Param("collegeName") String collegeName);

}
