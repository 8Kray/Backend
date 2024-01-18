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

    @GeneratedValue
    @Id
    private UUID matchId;
    private String teamA;
    private String teamB;
    private Integer teamA_Scor;
    private Integer teamB_Scor;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id")
    private Users users;
}
