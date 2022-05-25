package com.dan.epam.client.one.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class MovieMedia {
  int id;
  String posterUrl;
}
