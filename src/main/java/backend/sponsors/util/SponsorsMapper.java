package backend.sponsors.util;

import backend.sponsors.Sponsors;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class SponsorsMapper {
    public static Sponsors createSponsorsFromDto(SponsorsDto sponsorsDto) {
        Sponsors sponsors = new Sponsors();
        sponsors.setSponsor(sponsorsDto.getSponsor());
        sponsors.setSponsorDetails(sponsorsDto.getSponsorDetails());
        sponsors.setSponsorLink(sponsorsDto.getSponsorLink());

        return sponsors;
    }
    public static SponsorsDto toDto(Sponsors sponsors) {
        SponsorsDto sponsorsDto = new SponsorsDto();
        sponsorsDto.setSponsor(sponsors.getSponsor());
        sponsorsDto.setSponsorDetails(sponsors.getSponsorDetails());
        sponsorsDto.setSponsorLink(sponsors.getSponsorLink());
        return sponsorsDto;
    }
    public static List<SponsorsDto> mapToDtoList(List<Sponsors> sponsorsList) {
        return sponsorsList.stream()
                .map(SponsorsMapper::toDto)
                .collect(Collectors.toList());
    }

}
