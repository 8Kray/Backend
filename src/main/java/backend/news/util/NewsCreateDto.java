package backend.news.util;

import backend.user.util.UserAdminMedia;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NewsCreateDto {

    private String newsTitle;
    @Lob
    private String news;
    private Date date;

    private UserAdminMedia users;

}
