package backend.user.util;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogInDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
