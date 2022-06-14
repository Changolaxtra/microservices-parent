package com.dan.epam.client.one.controller;

import com.dan.epam.client.one.model.Movie;
import com.dan.epam.client.one.service.DetailMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DetailController {

  private final DetailMovieService detailMovieService;

  @GetMapping
  public List<Movie> getMoviesList(){
    return detailMovieService.getAll();
  }
}
