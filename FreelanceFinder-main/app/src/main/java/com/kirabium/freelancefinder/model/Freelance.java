package com.kirabium.freelancefinder.model;

import java.io.Serializable;
import java.util.Objects;

public class Freelance implements Serializable {
    private String avatarUrl;
    private String firstname;
    private String lastname;
    private String city;
    private int tjm;
    private int radius;
    private int yearOfXp;

    public Freelance() {
    }

    public Freelance(String avatarUrl, String firstname, String lastname, String city, int tjm, int radius, int yearOfXp) {
        this.avatarUrl = avatarUrl;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.tjm = tjm;
        this.radius = radius;
        this.yearOfXp = yearOfXp;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTjm() {
        return tjm;
    }

    public void setTjm(int tjm) {
        this.tjm = tjm;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getYearOfXp() {
        return yearOfXp;
    }

    public void setYearOfXp(int yearOfXp) {
        this.yearOfXp = yearOfXp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Freelance)) return false;
        Freelance freelance = (Freelance) o;
        return tjm == freelance.tjm &&
                radius == freelance.radius &&
                yearOfXp == freelance.yearOfXp &&
                Objects.equals(avatarUrl, freelance.avatarUrl) &&
                Objects.equals(firstname, freelance.firstname) &&
                Objects.equals(lastname, freelance.lastname) &&
                Objects.equals(city, freelance.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avatarUrl, firstname, lastname, city, tjm, radius, yearOfXp);
    }
}
