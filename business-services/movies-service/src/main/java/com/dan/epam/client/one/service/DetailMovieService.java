package com.dan.epam.client.one.service;

import com.dan.epam.client.one.client.MovieMediaClient;
import com.dan.epam.client.one.model.Movie;
import com.dan.epam.client.one.model.MovieMedia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DetailMovieService {

  private final ResourceLoader resourceLoader;
  private final MovieMediaClient movieMediaClient;

  private List<Movie> movies;

  @PostConstruct
  public void init() throws IOException {
    final Resource resource = resourceLoader.getResource("classpath:data/movies.json");
    final ObjectMapper mapper = new ObjectMapper();
    movies = mapper.readValue(resource.getInputStream(), new TypeReference<List<Movie>>() {
    });
    log.info("{} Movies loaded", movies.size());
  }

  public List<Movie> getAll() {
    Optional.ofNullable(movies)
        .orElse(new ArrayList<>())
        .forEach(movie -> movie.setPosterUrl(getMovieMediaURL(movie.getId())));
    return movies;
  }

  private String getMovieMediaURL(final Integer id) {
    log.info("Getting media url of {}", id);
    return Optional.ofNullable(getMovieMedia(id))
        .map(MovieMedia::getPosterUrl)
        .orElse(null);
  }

  private MovieMedia getMovieMedia(final Integer id) {
    MovieMedia movieMedia;
    try {
      movieMedia = movieMediaClient.findById(id);
    } catch (Exception e) {
      log.error("Error getting the MovieMedia {}", id, e);
      movieMedia = null;
    }
    return movieMedia;
  }


}
