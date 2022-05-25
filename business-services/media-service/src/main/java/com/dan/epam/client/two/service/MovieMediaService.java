package com.dan.epam.client.two.service;

import com.dan.epam.client.two.model.MovieMedia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieMediaService {

  private final ResourceLoader resourceLoader;

  private Map<Integer, MovieMedia> movieMediasMap;

  @PostConstruct
  public void init() throws IOException {
    final Resource resource = resourceLoader.getResource("classpath:data/movies-media.json");
    final ObjectMapper mapper = new ObjectMapper();
    List<MovieMedia> movieMedias = mapper.readValue(resource.getInputStream(), new TypeReference<List<MovieMedia>>() {
    });
    movieMediasMap = movieMedias.stream().collect(Collectors.toMap(MovieMedia::getId, Function.identity()));
    log.info("{} URLs loaded for movies", movieMedias.size());
  }

  public MovieMedia getMovieMedia(final Integer id) {
    log.info("Returning media of {}", id);
    return movieMediasMap.get(id);
  }
}
