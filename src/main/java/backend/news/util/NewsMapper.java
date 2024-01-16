package backend.news.util;

import backend.news.News;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class NewsMapper {
    public static NewsDto toDto(News news) {
        return new NewsDto(news.getNewsTitle(), news.getNews(), news.getDate());
    }
    public static List<NewsDto> mapToDtoList(List<News> newsList) {
        return newsList.stream()
                .map(NewsMapper::toDto)
                .collect(java.util.stream.Collectors.toList());
    }
}
