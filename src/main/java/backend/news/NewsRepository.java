package backend.news;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface NewsRepository extends JpaRepository<News, UUID> {

    List<News> findNewsByNewsTitle(String newsTitle);

    List<News> findNewsByDate(@NotBlank Date date);

    void deleteNewsByDate(Date date);

    void deleteNewsByNewsTitle(String newsTitle);
}
