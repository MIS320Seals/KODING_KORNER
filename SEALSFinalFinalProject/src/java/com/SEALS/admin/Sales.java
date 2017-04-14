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
public class Sales
{
    String genre;
    String revenue;

    public Sales()
    {
    }

    public Sales(String genre, String revenue)
    {
        this.genre = genre;
        this.revenue = revenue;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getRevenue()
    {
        return revenue;
    }

    public void setRevenue(String revenue)
    {
        this.revenue = revenue;
    }
    
    
}
