package backend.match;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Repository
public interface MatchRepository extends JpaRepository<Match, UUID> {
    List<Match> findMatchByDate(@NotBlank Date date);

    void deleteMatchByDate(Date date);

    List<Match> findMatchByTeamB(String teamB);
}
