package backend.club.util;

import backend.club.Club;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class ClubMapper {

    public static ClubDto toDto(Club club) {
        ClubDto clubDto = new ClubDto();
        clubDto.setTitle(club.getTitle());
        clubDto.setDetails(club.getDetails());
        clubDto.setDate(club.getDate());
        return clubDto;
    }
    public static List<ClubDto> mapToDtoList(List<Club> clubList) {
        return clubList.stream()
                .map(ClubMapper::toDto)
                .collect(Collectors.toList());
    }
}
