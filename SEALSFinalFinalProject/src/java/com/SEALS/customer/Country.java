/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SEALS.customer;
//import java.util.Date;
import java.sql.Date;
/**
 *
 * @author ering
 */
public class Country 
{
    public static int countryID;
    int country_id;
    String country;
    Date last_update; 

    public static int getCountryID() {
        return countryID;
    }

    public static void setCountryID(int countryID) {
        Country.countryID = countryID;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }   
}
