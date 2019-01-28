package com.aytdm.springbootjooq.domain.service;

import com.aytdm.springbootjooq.domain.model.City;
import com.aytdm.springbootjooq.domain.model.Country;
import com.aytdm.springbootjooq.domain.repository.CityRepository;
import com.aytdm.springbootjooq.domain.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorldService {

  @Autowired private CityRepository cityRepository;

  @Autowired private CountryRepository countryRepository;

  /**
   * @param code
   * @return {@link Country}
   */
  public Optional<Country> getCountry(String code) {
    Optional<Country> country = countryRepository.findByCode(code);

    if (!country.isPresent()) {
      return Optional.empty();
    }

    return country;
  }

  public Optional<City> getCity(int id) {
    Optional<City> city = cityRepository.findById(id);

    if (!city.isPresent()) {
      return Optional.empty();
    }

    return city;
  }

  public List<City> getCities(String countryCode) {
    return cityRepository.findByCountryCode(countryCode);
  }
}
