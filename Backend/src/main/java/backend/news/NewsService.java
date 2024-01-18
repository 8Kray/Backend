package backend.news;

import backend.news.util.NewsDto;
import backend.user.UserRepository;
import backend.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
    public News addNews(News news) throws Exception {
        Users existingUser = userRepository.findByUsername(news.getUsers().getUsername());

        if (existingUser != null) {
            news.getUsers().setId(existingUser.getId());
            news.getUsers().setEmail(existingUser.getEmail());
            news.getUsers().setLevel(existingUser.getLevel());
            return newsRepository.save(news);
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
