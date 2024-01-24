package backend.news.util;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NewsDto {
    @NotBlank
    private String newsTitle;
    @Lob
    @NotBlank
    private String news;
    @NotBlank
    private Date date;

}
