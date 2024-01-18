package backend.sponsors.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SponsorsDto {

    private String sponsor;
    private String sponsorDetails;
    private String sponsorLink;


}
