package com.dan.epam.client.one.client;

import com.dan.epam.client.one.model.MovieMedia;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "media-service")
public interface MovieMediaClient {

  @GetMapping("/media/movie/{id}")
  MovieMedia findById(@PathVariable("id") Integer id);
}
