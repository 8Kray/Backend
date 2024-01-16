package backend.news.util;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NewsDto {
    @NotBlank
    private String newsTitle;
    @NotBlank
    private String news;
    @NotBlank
    private Date date;
}
