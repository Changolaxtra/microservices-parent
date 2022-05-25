package com.dan.epam.client.one.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Setter
@Builder
@Jacksonized
public class Movie {
  int id;
  String title;
  String year;
  String runtime;
  String director;
  String actors;
  String plot;
  List<String> genres;

  @JsonIgnore
  String posterUrl;
}
