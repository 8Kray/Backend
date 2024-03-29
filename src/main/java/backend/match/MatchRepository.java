package backend.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;
@Repository
public interface MatchRepository extends JpaRepository<Match, UUID> {


    Match findByDate(Date date);

    Match findByTeamA(String teamA);
}
