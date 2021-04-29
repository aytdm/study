/*
 * This file is generated by jOOQ.
 */
package com.aytdm.springbootjooq.domain.db.world.tables.records;


import com.aytdm.springbootjooq.domain.db.world.enums.CountryContinent;
import com.aytdm.springbootjooq.domain.db.world.tables.Country;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CountryRecord extends UpdatableRecordImpl<CountryRecord> implements Record15<String, String, CountryContinent, String, Double, Short, Integer, Double, Double, Double, String, String, String, Integer, String> {

    private static final long serialVersionUID = -450804612;

    /**
     * Setter for <code>world.country.Code</code>.
     */
    public void setCode(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>world.country.Code</code>.
     */
    public String getCode() {
        return (String) get(0);
    }

    /**
     * Setter for <code>world.country.Name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>world.country.Name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>world.country.Continent</code>.
     */
    public void setContinent(CountryContinent value) {
        set(2, value);
    }

    /**
     * Getter for <code>world.country.Continent</code>.
     */
    public CountryContinent getContinent() {
        return (CountryContinent) get(2);
    }

    /**
     * Setter for <code>world.country.Region</code>.
     */
    public void setRegion(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>world.country.Region</code>.
     */
    public String getRegion() {
        return (String) get(3);
    }

    /**
     * Setter for <code>world.country.SurfaceArea</code>.
     */
    public void setSurfacearea(Double value) {
        set(4, value);
    }

    /**
     * Getter for <code>world.country.SurfaceArea</code>.
     */
    public Double getSurfacearea() {
        return (Double) get(4);
    }

    /**
     * Setter for <code>world.country.IndepYear</code>.
     */
    public void setIndepyear(Short value) {
        set(5, value);
    }

    /**
     * Getter for <code>world.country.IndepYear</code>.
     */
    public Short getIndepyear() {
        return (Short) get(5);
    }

    /**
     * Setter for <code>world.country.Population</code>.
     */
    public void setPopulation(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>world.country.Population</code>.
     */
    public Integer getPopulation() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>world.country.LifeExpectancy</code>.
     */
    public void setLifeexpectancy(Double value) {
        set(7, value);
    }

    /**
     * Getter for <code>world.country.LifeExpectancy</code>.
     */
    public Double getLifeexpectancy() {
        return (Double) get(7);
    }

    /**
     * Setter for <code>world.country.GNP</code>.
     */
    public void setGnp(Double value) {
        set(8, value);
    }

    /**
     * Getter for <code>world.country.GNP</code>.
     */
    public Double getGnp() {
        return (Double) get(8);
    }

    /**
     * Setter for <code>world.country.GNPOld</code>.
     */
    public void setGnpold(Double value) {
        set(9, value);
    }

    /**
     * Getter for <code>world.country.GNPOld</code>.
     */
    public Double getGnpold() {
        return (Double) get(9);
    }

    /**
     * Setter for <code>world.country.LocalName</code>.
     */
    public void setLocalname(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>world.country.LocalName</code>.
     */
    public String getLocalname() {
        return (String) get(10);
    }

    /**
     * Setter for <code>world.country.GovernmentForm</code>.
     */
    public void setGovernmentform(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>world.country.GovernmentForm</code>.
     */
    public String getGovernmentform() {
        return (String) get(11);
    }

    /**
     * Setter for <code>world.country.HeadOfState</code>.
     */
    public void setHeadofstate(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>world.country.HeadOfState</code>.
     */
    public String getHeadofstate() {
        return (String) get(12);
    }

    /**
     * Setter for <code>world.country.Capital</code>.
     */
    public void setCapital(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>world.country.Capital</code>.
     */
    public Integer getCapital() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>world.country.Code2</code>.
     */
    public void setCode2(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>world.country.Code2</code>.
     */
    public String getCode2() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<String, String, CountryContinent, String, Double, Short, Integer, Double, Double, Double, String, String, String, Integer, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<String, String, CountryContinent, String, Double, Short, Integer, Double, Double, Double, String, String, String, Integer, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Country.COUNTRY.CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Country.COUNTRY.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<CountryContinent> field3() {
        return Country.COUNTRY.CONTINENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Country.COUNTRY.REGION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field5() {
        return Country.COUNTRY.SURFACEAREA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field6() {
        return Country.COUNTRY.INDEPYEAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Country.COUNTRY.POPULATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field8() {
        return Country.COUNTRY.LIFEEXPECTANCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field9() {
        return Country.COUNTRY.GNP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field10() {
        return Country.COUNTRY.GNPOLD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Country.COUNTRY.LOCALNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Country.COUNTRY.GOVERNMENTFORM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return Country.COUNTRY.HEADOFSTATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field14() {
        return Country.COUNTRY.CAPITAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return Country.COUNTRY.CODE2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryContinent component3() {
        return getContinent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component5() {
        return getSurfacearea();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component6() {
        return getIndepyear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getPopulation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component8() {
        return getLifeexpectancy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component9() {
        return getGnp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component10() {
        return getGnpold();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getLocalname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getGovernmentform();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getHeadofstate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component14() {
        return getCapital();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getCode2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryContinent value3() {
        return getContinent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value5() {
        return getSurfacearea();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value6() {
        return getIndepyear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getPopulation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value8() {
        return getLifeexpectancy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value9() {
        return getGnp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value10() {
        return getGnpold();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getLocalname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getGovernmentform();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getHeadofstate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value14() {
        return getCapital();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getCode2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value1(String value) {
        setCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value3(CountryContinent value) {
        setContinent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value4(String value) {
        setRegion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value5(Double value) {
        setSurfacearea(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value6(Short value) {
        setIndepyear(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value7(Integer value) {
        setPopulation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value8(Double value) {
        setLifeexpectancy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value9(Double value) {
        setGnp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value10(Double value) {
        setGnpold(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value11(String value) {
        setLocalname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value12(String value) {
        setGovernmentform(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value13(String value) {
        setHeadofstate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value14(Integer value) {
        setCapital(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord value15(String value) {
        setCode2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryRecord values(String value1, String value2, CountryContinent value3, String value4, Double value5, Short value6, Integer value7, Double value8, Double value9, Double value10, String value11, String value12, String value13, Integer value14, String value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CountryRecord
     */
    public CountryRecord() {
        super(Country.COUNTRY);
    }

    /**
     * Create a detached, initialised CountryRecord
     */
    public CountryRecord(String code, String name, CountryContinent continent, String region, Double surfacearea, Short indepyear, Integer population, Double lifeexpectancy, Double gnp, Double gnpold, String localname, String governmentform, String headofstate, Integer capital, String code2) {
        super(Country.COUNTRY);

        set(0, code);
        set(1, name);
        set(2, continent);
        set(3, region);
        set(4, surfacearea);
        set(5, indepyear);
        set(6, population);
        set(7, lifeexpectancy);
        set(8, gnp);
        set(9, gnpold);
        set(10, localname);
        set(11, governmentform);
        set(12, headofstate);
        set(13, capital);
        set(14, code2);
    }
}