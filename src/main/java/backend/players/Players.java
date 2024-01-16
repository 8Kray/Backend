package backend.players;

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
@Table(name = "players")
public class Players {

    @GeneratedValue
    @Id
    private UUID playerId;
    @NotBlank
    private String playerName;
    @NotBlank
    private String playerDetails;
    @NotBlank
    private String statistic;
    @ManyToOne
    @JoinColumn(name ="id")
    private Users users;

}
