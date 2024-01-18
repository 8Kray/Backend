package backend.club.util;

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
        @NotBlank
        private String details;
        @NotBlank
        private Date date;

}
