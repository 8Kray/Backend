package backend.news;

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
@Table(name = "news")
public class News {
    @NotBlank
    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank
    private String newsTitle;
    @NotBlank
    private String news;
    @NotBlank
    private Date date;
    @ManyToOne
    private Users users;
}
