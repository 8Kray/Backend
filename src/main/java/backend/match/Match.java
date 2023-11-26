package backend.match;

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
@Table(name = "match")
public class Match {
    @NotBlank
    @GeneratedValue
    @Id
    private UUID id;
    @NotBlank
    private String teamA;
    @NotBlank
    private String teamB;
    @NotBlank
    private Integer teamA_Scor;
    @NotBlank
    private Integer teamB_Scor;
    @NotBlank
    private Date date;
    @ManyToOne
    private Users users;
}
