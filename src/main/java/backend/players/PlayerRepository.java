package backend.players;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    Player findPlayerByplayerName(String name);

    void deletePlayerByplayerName(String name);

}
