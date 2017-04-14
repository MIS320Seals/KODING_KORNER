/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SEALS.admin;

/**
 *
 * @author Austin
 */
public class CustInfo
{
    private String id;
    private String name;
    private String address;
    private String zip;
    private String phoneNumber;
    private String city;
    private String country;
    private String notes;
    private String storeId;

    public CustInfo()
    {
    }

    public CustInfo(String id, String name, String address, String zip, String phoneNumber, String city, String country, String notes, String storeId)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.notes = notes;
        this.storeId = storeId;
    }

    
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public void setStoreId(String storeId)
    {
        this.storeId = storeId;
    }

    
    
    
}
