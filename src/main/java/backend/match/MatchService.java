package backend.match;

import backend.match.util.MatchCreateDto;
import backend.match.util.MatchDto;
import backend.players.Players;
import backend.user.UserRepository;
import backend.user.Users;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    public Match addMatch(MatchCreateDto matchCreateDto) throws Exception {
        Users existingUser = userRepository.findByUsername(matchCreateDto.getUsers().getUsername());

        if (existingUser != null) {
            if (existingUser.getLevel().equalsIgnoreCase("admin")) {
                Match newMatch = new Match();
                newMatch.setTeamA(matchCreateDto.getTeamA());
                newMatch.setTeamB(matchCreateDto.getTeamB());
                newMatch.setTeamA_Scor(matchCreateDto.getTeamA_Scor());
                newMatch.setTeamB_Scor(matchCreateDto.getTeamB_Scor());
                newMatch.setDate((Date) matchCreateDto.getDate());
                newMatch.setUsers(existingUser);
                return matchRepository.save(newMatch);
            } else {
                throw new Exception("User does not have admin level");
            }
        } else {
            throw new Exception("User not found");
        }
    }
    public Match getMatchById(UUID id) {
        return matchRepository.findById(id).orElse(null);
    }
    public Match getMatchByDate(Date date) {
        return matchRepository.findByDate(date);
    }
    public void deleteMatchById(UUID id) {
        matchRepository.deleteById(id);
    }
    public void updateMatchByDate(Date date, MatchDto matchDto) {
        Match existingMatch = matchRepository.findByDate(date);
        existingMatch.setDate(matchDto.getDate());
        existingMatch.setTeamA(matchDto.getTeamA());
        existingMatch.setTeamB(matchDto.getTeamB());
        existingMatch.setTeamA_Scor(matchDto.getTeamA_Scor());
        existingMatch.setTeamB_Scor(matchDto.getTeamB_Scor());
        matchRepository.save(existingMatch);
    }

}
