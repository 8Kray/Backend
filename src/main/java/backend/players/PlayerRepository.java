package backend.players;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PlayerRepository extends JpaRepository<Players, UUID> {
    Players findByPlayerName(String playerName);

    void deleteByPlayerName(String playerName);
}
