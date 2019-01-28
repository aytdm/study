package com.aytdm.springbootjooq.domain.repository;

import com.aytdm.springbootjooq.domain.model.City;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.aytdm.springbootjooq.domain.db.world.Tables.CITY;

@Repository
@RequiredArgsConstructor
public class CityRepository {

  @Autowired private DSLContext context;

  public Optional<City> findById(int id) {
    return context
        .select(CITY.ID, CITY.NAME, CITY.COUNTRYCODE, CITY.POPULATION, CITY.DISTRICT)
        .from(CITY)
        .where(CITY.ID.eq(id))
        .fetchOptional((r -> r.into(City.builder().build())));
  }

  public List<City> findByCountryCode(String countryCode) {
    return context
        .select()
        .from(CITY)
        .where(CITY.COUNTRYCODE.eq(countryCode))
        .fetch()
        .stream()
        .map(r -> r.into(City.builder().build()))
        .collect(Collectors.toList());
  }
}
