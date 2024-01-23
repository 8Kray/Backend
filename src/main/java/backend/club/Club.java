package backend.club;

import backend.image.Image;
import backend.user.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

;

import java.util.Date;
import java.util.UUID;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "club")
public class Club
{


    @GeneratedValue
    @Id
    private UUID clubId;
    private String title;
    private String details;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id")
    private Users users;

}
