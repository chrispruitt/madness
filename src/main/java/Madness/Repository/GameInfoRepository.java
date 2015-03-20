package Madness.Repository;

import Madness.model.GameInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gameinfo", path = "gameinfo")
public interface GameInfoRepository extends CrudRepository<GameInfo, String> {
}
