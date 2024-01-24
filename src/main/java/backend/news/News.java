package backend.news;

import backend.image.Image;
import backend.user.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.types.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue
    private UUID newsId;
    private String newsTitle;
    @Lob
    private String news;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "EET")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id")
    private Users users;

}
