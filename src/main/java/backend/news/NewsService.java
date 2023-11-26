package backend.news;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public News addNews(News news) {

        return newsRepository.save(news);
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News updateNews(News news) {
        return newsRepository.save(news);
    }

    public List<News> getNewsByNewsTitle(String newsTitle) {
        return newsRepository.findNewsByNewsTitle(newsTitle);
    }

    public List<News> getNewsByDate(Data date) {
        return newsRepository.findNewsByDate((Date) date);
    }

    public News updateNewsTitle(UUID id, String newsTitle) {
        News news = newsRepository.findById(id).orElseThrow();
        news.setNewsTitle(newsTitle);
        return newsRepository.save(news);
    }

    public void deleteNewsBydate(Date date) {
        newsRepository.deleteNewsByDate(date);
    }

    public void deleteNewsByNewsTitle(String newsTitle) {
        newsRepository.deleteNewsByNewsTitle(newsTitle);
    }


}
