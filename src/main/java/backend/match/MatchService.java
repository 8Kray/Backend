package backend.match;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match addMatch(Match match) {

        return matchRepository.save(match);
    }

    public List<Match> getMatchByDate(Data date) { return matchRepository.findMatchByDate((Date) date); }


    public void deleteMatchBydate(Date date) {
        matchRepository.deleteMatchByDate(date);
    }

    public Match updateMatchScore(UUID id, Integer teamAScor, Integer teamBScor) {
        Match match = matchRepository.findById(id).orElseThrow();
        match.setTeamA_Scor(teamAScor);
        match.setTeamB_Scor(teamBScor);
        return matchRepository.save(match);
    }

    public Match updateMatchTeams(UUID id, String teamA, String teamB) {
        Match match = matchRepository.findById(id).orElseThrow();
        match.setTeamA(teamA);
        match.setTeamB(teamB);
        return matchRepository.save(match);
    }

    public List<Match> getMatchByTeamB(String teamB) { return matchRepository.findMatchByTeamB(teamB); }

}
