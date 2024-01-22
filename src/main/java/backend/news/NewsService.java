package backend.news;

import backend.news.util.NewsCreateDto;
import backend.news.util.NewsDto;
import backend.user.UserRepository;
import backend.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    public boolean isUserAdmin(String username) {
        Users user = userRepository.findByUsername(username);
        return user != null && "admin".equalsIgnoreCase(user.getLevel());
    }



    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News addNews(NewsCreateDto news) throws Exception {
        Users existingUser = userRepository.findByUsername(news.getUsers().getUsername());
        if (existingUser != null) {
            if (isUserAdmin(existingUser.getUsername())) {
                // Create a new Sponsors object and populate its properties
                News newSponsor = new News();

                newSponsor.setNewsTitle(news.getNewsTitle());
                newSponsor.setNews(news.getNews());
                newSponsor.setDate(news.getDate());
                newSponsor.setUsers(existingUser);

                // Save the new sponsor
                return newsRepository.save(newSponsor);
            } else {
                throw new Exception("User does not have admin level");
            }
        } else {
            throw new Exception("User not found");
        }
    }

    public News getNewsById(UUID id) {
        return newsRepository.findById(id).orElse(null);
    }

    public News getNewsByNewsTitle(String newsTitle) {
        return newsRepository.findByNewsTitle(newsTitle);
    }

    public void deleteNewsById(UUID id) {
        newsRepository.deleteById(id);
    }

    public void updateNewsByNewsTitle(String newsTitle, NewsDto newsDto) {
        News existingNews = newsRepository.findByNewsTitle(newsTitle);
        existingNews.setNewsTitle(newsDto.getNewsTitle());
        existingNews.setNews(newsDto.getNews());
        newsRepository.save(existingNews);
    }
}
