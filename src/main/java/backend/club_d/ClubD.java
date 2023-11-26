package backend.club_d;

import backend.user.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clubd")
public class ClubD {
    @NotBlank
    @GeneratedValue
    @Id
    private UUID id;
    @NotBlank
    private String title;
    @NotBlank
    private String details;
    @NotBlank
    private Date date;
    @ManyToOne
    private Users users;
}
