package Madness.Repository;

import Madness.model.GameInfo;
import org.springframework.data.repository.CrudRepository;

public interface GameInfoRepository extends CrudRepository<GameInfo, String> {
}
