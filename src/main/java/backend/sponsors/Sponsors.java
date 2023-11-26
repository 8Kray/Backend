package backend.sponsors;

import backend.user.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sponsors")
public class Sponsors {
    @NotBlank
    @GeneratedValue
    @Id
    private UUID sponsorsID;
    @NotBlank
    private String sponsor;
    @NotBlank
    private String sponsorDetails;
    @NotBlank
    private String sponsorLink;
    @ManyToOne
    private Users users;

}
