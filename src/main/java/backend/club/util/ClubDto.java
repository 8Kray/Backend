package backend.club.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubDto {
        @NotBlank
        private String title;
        @Lob
        @NotBlank
        private String details;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "EET")
        @NotBlank
        private Date date;

}
