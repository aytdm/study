/*
 * This file is generated by jOOQ.
 */
package com.aytdm.springbootjooq.domain.db.world.enums;


import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum CountryContinent implements EnumType {

    Asia("Asia"),

    Europe("Europe"),

    North_America("North America"),

    Africa("Africa"),

    Oceania("Oceania"),

    Antarctica("Antarctica"),

    South_America("South America");

    private final String literal;

    private CountryContinent(String literal) {
        this.literal = literal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "country_Continent";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLiteral() {
        return literal;
    }
}
