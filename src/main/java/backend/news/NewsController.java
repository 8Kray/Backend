package backend.news;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @PostMapping("/add")
    public ResponseEntity<News> addNews(@RequestBody News news) {
        News addedNews = newsService.addNews(news);
        return new ResponseEntity<>(addedNews, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<News>> getAllNews() {
        List<News> newsList = newsService.getAllNews();
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("/title/{newsTitle}")
    public ResponseEntity<List<News>> getNewsByNewsTitle(@PathVariable String newsTitle) {
        List<News> newsList = newsService.getNewsByNewsTitle(newsTitle);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<News>> getNewsByDate(@PathVariable Date date) {
        List<News> newsList = newsService.getNewsByDate((Data) date);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{newsTitle}")
    public ResponseEntity<News> updateNewsTitle(@PathVariable UUID id, @PathVariable String newsTitle) {
        News updatedNews = newsService.updateNewsTitle(id, newsTitle);
        return new ResponseEntity<>(updatedNews, HttpStatus.OK);
    }

    @DeleteMapping("/delete/title/{newsTitle}")
    public ResponseEntity<Void> deleteNewsByNewsTitle(@PathVariable String newsTitle) {
        newsService.deleteNewsByNewsTitle(newsTitle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/date/{date}")
    public ResponseEntity<Void> deleteNewsByDate(@PathVariable Date date) {
        newsService.deleteNewsBydate(date);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
