package backend.match.util;

import backend.match.Match;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class MatchMapper {

    public static MatchDto toDto(Match match) {
        MatchDto matchDto = new MatchDto();
        matchDto.setTeamA(match.getTeamA());
        matchDto.setTeamB(match.getTeamB());
        matchDto.setTeamA_Scor(match.getTeamA_Scor());
        matchDto.setTeamB_Scor(match.getTeamB_Scor());
        matchDto.setDate(match.getDate());
        return matchDto;
    }
    public static List<MatchDto> mapToDtoList(List<Match> matchList) {
        return matchList.stream()
                .map(MatchMapper::toDto)
                .collect(Collectors.toList());
    }
}
