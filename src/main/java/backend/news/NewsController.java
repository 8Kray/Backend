package backend.news;

import backend.news.util.NewsCreateDto;
import backend.news.util.NewsDto;
import backend.news.util.NewsMapper;
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

    @GetMapping("/all")
    public ResponseEntity<List<NewsDto>> getAllNews() {
        List<News> news = newsService.getAllNews();
        List<NewsDto> newsDtoList = NewsMapper.mapToDtoList(news);
        return new ResponseEntity<>(newsDtoList, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<News>> getAllNewss() {
        List<News> news = newsService.getAllNews();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<News> addNews(@RequestBody NewsCreateDto news) {
        try {
            News newNews = newsService.addNews(news);
            return new ResponseEntity<>(newNews, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> getNewsById(@PathVariable UUID id) {
        News news = newsService.getNewsById(id);
        if (news != null) {
            NewsDto newsDto = NewsMapper.toDto(news);
            return new ResponseEntity<>(newsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<NewsDto> getNewsByNewsTitle(@RequestParam String newsTitle) {
        News news = newsService.getNewsByNewsTitle(newsTitle);
        if (news != null) {
            NewsDto newsDto = NewsMapper.toDto(news);
            return new ResponseEntity<>(newsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update{newsTitle}")
    public ResponseEntity<String> updateNewsByNewsTitle(@RequestParam String newsTitle, @RequestBody NewsDto newsDto) {
        try {
            newsService.updateNewsByNewsTitle(newsTitle, newsDto);
            return ResponseEntity.status(HttpStatus.OK).body("News updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("News not found");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNewsById(@PathVariable UUID id) {
        try {
            newsService.deleteNewsById(id);
            return ResponseEntity.status(HttpStatus.OK).body("News deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("News not found");
        }
    }
    
}
