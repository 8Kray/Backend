package backend.sponsors;

import backend.image.Image;
import backend.image.ImageUtil;
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

    @GeneratedValue
    @Id
    private UUID sponsorsID;

    private String sponsor;

    private String sponsorDetails;

    private String sponsorLink;
    @ManyToOne
    @JoinColumn(name = "id")
    private Users users;

}
