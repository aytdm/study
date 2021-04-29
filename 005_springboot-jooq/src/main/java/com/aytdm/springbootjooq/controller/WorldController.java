package com.aytdm.springbootjooq.controller;

import com.aytdm.springbootjooq.domain.model.City;
import com.aytdm.springbootjooq.domain.model.Country;
import com.aytdm.springbootjooq.domain.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorldController {

  @Autowired private WorldService worldService;

  @GetMapping("country/{code}")
  public Country country(@PathVariable String code) {
    return worldService.getCountry(code).get();
  }

  @GetMapping("city/{id}")
  public City city(@PathVariable int id) {
    return worldService.getCity(id).get();
  }

  @GetMapping("city")
  public List<City> cities(@RequestParam String countryCode) {
    return worldService.getCities(countryCode);
  }
}
