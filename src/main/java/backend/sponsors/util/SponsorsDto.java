package backend.sponsors.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SponsorsDto {

    private String sponsor;
    private String sponsorDetails;
    private String sponsorLink;


}
