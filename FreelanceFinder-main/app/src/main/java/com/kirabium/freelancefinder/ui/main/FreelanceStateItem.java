package com.kirabium.freelancefinder.ui.main;

import androidx.annotation.NonNull;

import com.kirabium.freelancefinder.model.Freelance;

import java.util.Objects;

public class FreelanceStateItem {

    @NonNull
    private final String firstname;
    @NonNull
    private final String avatarUrl;
    @NonNull
    private final String tjm;
    @NonNull
    private final String city;
    @NonNull
    private final String seniority;

    public FreelanceStateItem(Freelance freelance){
        this.firstname = freelance.getFirstname();
        this.avatarUrl = freelance.getAvatarUrl();
        this.city = freelance.getCity();
        this.tjm = freelance.getTjm() + "€/jours";
        this.seniority = freelance.getYearOfXp()<3?"Junior":"Confirmé";
    }

    public FreelanceStateItem(@NonNull String firstname, @NonNull String avatarUrl, @NonNull String tjm, @NonNull String city, @NonNull String seniority) {
        this.firstname = firstname;
        this.avatarUrl = avatarUrl;
        this.tjm = tjm;
        this.city = city;
        this.seniority = seniority;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    @NonNull
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @NonNull
    public String getTjm() {
        return tjm;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    @NonNull
    public String getSeniority() {
        return seniority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FreelanceStateItem)) return false;
        FreelanceStateItem that = (FreelanceStateItem) o;
        return firstname.equals(that.firstname) &&
                avatarUrl.equals(that.avatarUrl) &&
                tjm.equals(that.tjm) &&
                city.equals(that.city) &&
                seniority.equals(that.seniority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, avatarUrl, tjm, city, seniority);
    }
}
