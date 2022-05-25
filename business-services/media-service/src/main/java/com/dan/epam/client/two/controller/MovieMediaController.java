package com.dan.epam.client.two.controller;

import com.dan.epam.client.two.model.MovieMedia;
import com.dan.epam.client.two.service.MovieMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MovieMediaController {

  private final MovieMediaService movieMediaService;

  @GetMapping("/movie/{id}")
  public MovieMedia getAllMovieMedias(@PathVariable Integer id) {
    return movieMediaService.getMovieMedia(id);
  }
}
