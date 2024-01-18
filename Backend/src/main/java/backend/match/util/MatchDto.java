package backend.match.util;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {
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
}
