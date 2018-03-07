package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: mFacepileText */
public enum GraphQLPageInfoFieldType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SHORT_DESCRIPTION,
    RELEASE_DATE,
    GENRE,
    STUDIO,
    NETWORK,
    SEASON,
    BAND_MEMBERS,
    HOMETOWN,
    RECORD_LABEL,
    AFFILIATION,
    POST,
    ISBN,
    PUBLISHER,
    SCHEDULE,
    AWARDS,
    POPULATION,
    IMPRESSUM,
    LANGUAGE,
    CAPITAL,
    AREA,
    GOVERNMENT,
    START_DATE,
    STARRING,
    DIRECTED_BY,
    WRITTEN_BY,
    RELIGION,
    PRODUCTS,
    BUILT,
    FEATURES,
    MPG,
    INFLUENCES,
    CURRENT_LOCATION,
    SCREENPLAY_BY,
    PRODUCED_BY,
    MISSION,
    DESCRIPTION,
    GENERAL_INFO,
    ABOUT_ME,
    QUOTE,
    ACTIVITIES,
    INTERESTS,
    BAND_INTERESTS,
    BOOKS,
    MUSIC,
    MOVIES,
    TV,
    ARTISTS_WE_LIKE,
    BIOGRAPHY,
    COMPANY_OVERVIEW,
    CULINARY_TEAM,
    GENERAL_MANAGER,
    HISTORY,
    MEMBERS,
    PERSONAL_INFO,
    PERSONAL_INTERESTS,
    PHARMA_SAFETY_INFO,
    PLOT_OUTLINE,
    PUBLIC_TRANSIT,
    SPOTLIGHT_LOCALS_SNIPPETS;

    public static GraphQLPageInfoFieldType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 31) {
            case 0:
                if (str.equalsIgnoreCase("POST")) {
                    return POST;
                }
                if (str.equalsIgnoreCase("INFLUENCES")) {
                    return INFLUENCES;
                }
                if (str.equalsIgnoreCase("MOVIES")) {
                    return MOVIES;
                }
                if (str.equalsIgnoreCase("TV")) {
                    return TV;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 1:
                if (str.equalsIgnoreCase("DESCRIPTION")) {
                    return DESCRIPTION;
                }
                if (str.equalsIgnoreCase("MEMBERS")) {
                    return MEMBERS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("HOMETOWN")) {
                    return HOMETOWN;
                }
                if (str.equalsIgnoreCase("PRODUCED_BY")) {
                    return PRODUCED_BY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("CULINARY_TEAM")) {
                    return CULINARY_TEAM;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (str.equalsIgnoreCase("AREA")) {
                    return AREA;
                }
                if (str.equalsIgnoreCase("GENERAL_INFO")) {
                    return GENERAL_INFO;
                }
                if (str.equalsIgnoreCase("ABOUT_ME")) {
                    return ABOUT_ME;
                }
                if (str.equalsIgnoreCase("GENERAL_MANAGER")) {
                    return GENERAL_MANAGER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("IMPRESSUM")) {
                    return IMPRESSUM;
                }
                if (str.equalsIgnoreCase("PRODUCTS")) {
                    return PRODUCTS;
                }
                if (str.equalsIgnoreCase("CURRENT_LOCATION")) {
                    return CURRENT_LOCATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("MISSION")) {
                    return MISSION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("GENRE")) {
                    return GENRE;
                }
                if (str.equalsIgnoreCase("PUBLISHER")) {
                    return PUBLISHER;
                }
                if (str.equalsIgnoreCase("SCREENPLAY_BY")) {
                    return SCREENPLAY_BY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("WRITTEN_BY")) {
                    return WRITTEN_BY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("MPG")) {
                    return MPG;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("STUDIO")) {
                    return STUDIO;
                }
                if (str.equalsIgnoreCase("NETWORK")) {
                    return NETWORK;
                }
                if (str.equalsIgnoreCase("PUBLIC_TRANSIT")) {
                    return PUBLIC_TRANSIT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("SEASON")) {
                    return SEASON;
                }
                if (str.equalsIgnoreCase("ARTISTS_WE_LIKE")) {
                    return ARTISTS_WE_LIKE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("POPULATION")) {
                    return POPULATION;
                }
                if (str.equalsIgnoreCase("RELIGION")) {
                    return RELIGION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("PERSONAL_INFO")) {
                    return PERSONAL_INFO;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("LANGUAGE")) {
                    return LANGUAGE;
                }
                if (str.equalsIgnoreCase("MUSIC")) {
                    return MUSIC;
                }
                if (str.equalsIgnoreCase("PERSONAL_INTERESTS")) {
                    return PERSONAL_INTERESTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("QUOTE")) {
                    return QUOTE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("RECORD_LABEL")) {
                    return RECORD_LABEL;
                }
                if (str.equalsIgnoreCase("BIOGRAPHY")) {
                    return BIOGRAPHY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("BUILT")) {
                    return BUILT;
                }
                if (str.equalsIgnoreCase("PHARMA_SAFETY_INFO")) {
                    return PHARMA_SAFETY_INFO;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("AWARDS")) {
                    return AWARDS;
                }
                if (str.equalsIgnoreCase("STARRING")) {
                    return STARRING;
                }
                if (str.equalsIgnoreCase("BOOKS")) {
                    return BOOKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("SHORT_DESCRIPTION")) {
                    return SHORT_DESCRIPTION;
                }
                if (str.equalsIgnoreCase("SCHEDULE")) {
                    return SCHEDULE;
                }
                if (str.equalsIgnoreCase("DIRECTED_BY")) {
                    return DIRECTED_BY;
                }
                if (str.equalsIgnoreCase("HISTORY")) {
                    return HISTORY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("PLOT_OUTLINE")) {
                    return PLOT_OUTLINE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("START_DATE")) {
                    return START_DATE;
                }
                if (str.equalsIgnoreCase("ACTIVITIES")) {
                    return ACTIVITIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("RELEASE_DATE")) {
                    return RELEASE_DATE;
                }
                if (str.equalsIgnoreCase("SPOTLIGHT_LOCALS_SNIPPETS")) {
                    return SPOTLIGHT_LOCALS_SNIPPETS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("BAND_MEMBERS")) {
                    return BAND_MEMBERS;
                }
                if (str.equalsIgnoreCase("FEATURES")) {
                    return FEATURES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("COMPANY_OVERVIEW")) {
                    return COMPANY_OVERVIEW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("GOVERNMENT")) {
                    return GOVERNMENT;
                }
                if (str.equalsIgnoreCase("BAND_INTERESTS")) {
                    return BAND_INTERESTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("AFFILIATION")) {
                    return AFFILIATION;
                }
                if (str.equalsIgnoreCase("CAPITAL")) {
                    return CAPITAL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("ISBN")) {
                    return ISBN;
                }
                if (str.equalsIgnoreCase("INTERESTS")) {
                    return INTERESTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}
