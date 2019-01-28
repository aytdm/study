package com.aytdm.springbootjooq.domain.repository;

import com.aytdm.springbootjooq.domain.model.Country;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.aytdm.springbootjooq.domain.db.world.Tables.COUNTRY;

@Repository
public class CountryRepository {

  @Autowired private DSLContext context;

  public Optional<Country> findByCode(String code) {
    return context
        .select()
        .from(COUNTRY)
        .where(COUNTRY.CODE.eq(code))
        .fetchOptional((r -> r.into(Country.builder().build())));
  }
}
