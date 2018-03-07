package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: mTypeString */
public enum GraphQLInfoRequestFieldType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ADDRESS,
    BIRTHDAY,
    BOOK_SUGGESTION,
    COLLEGE,
    CURRENT_CITY,
    CURRENT_LOCATION,
    EMAIL,
    GENERIC,
    GRAD_SCHOOL,
    HIGH_SCHOOL,
    HOMETOWN,
    HOURS,
    MESSAGE_RESPONSIVENESS,
    MOVIE_SUGGESTION,
    MUSIC_SUGGESTION,
    NAME_PRONUNCIATION,
    PAGE_ADDRESS,
    PAGE_CATEGORIES,
    PAGE_PHONE,
    PAGE_PRICE_RANGE,
    PAGE_WEBSITE,
    PHONE,
    PROFILE_PIC,
    RELATIONSHIP,
    TV_SUGGESTION,
    WORK,
    EDUCATION,
    CAMERA_SUGGESTION,
    CAR_SUGGESTION,
    DENTIST_SUGGESTION,
    DOCTOR_SUGGESTION,
    OTHER_SUGGESTION,
    PERSON_SUGGESTION,
    PHOTOGRAPHER_SUGGESTION,
    PLACE_SUGGESTION,
    PLUMBER_SUGGESTION,
    RECIPE_SUGGESTION,
    RESTAURANT_SUGGESTION,
    SALON_SUGGESTION,
    THINGS_TO_DO_SUGGESTION,
    TRAVEL_SUGGESTION;

    public static GraphQLInfoRequestFieldType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 31) {
            case 0:
                if (str.equalsIgnoreCase("EDUCATION")) {
                    return EDUCATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("HOMETOWN")) {
                    return HOMETOWN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("BOOK_SUGGESTION")) {
                    return BOOK_SUGGESTION;
                }
                if (str.equalsIgnoreCase("CAR_SUGGESTION")) {
                    return CAR_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("COLLEGE")) {
                    return COLLEGE;
                }
                if (str.equalsIgnoreCase("CURRENT_LOCATION")) {
                    return CURRENT_LOCATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("GRAD_SCHOOL")) {
                    return GRAD_SCHOOL;
                }
                if (str.equalsIgnoreCase("CAMERA_SUGGESTION")) {
                    return CAMERA_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("HIGH_SCHOOL")) {
                    return HIGH_SCHOOL;
                }
                if (str.equalsIgnoreCase("DOCTOR_SUGGESTION")) {
                    return DOCTOR_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("DENTIST_SUGGESTION")) {
                    return DENTIST_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("PAGE_ADDRESS")) {
                    return PAGE_ADDRESS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("GENERIC")) {
                    return GENERIC;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("PAGE_CATEGORIES")) {
                    return PAGE_CATEGORIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("RELATIONSHIP")) {
                    return RELATIONSHIP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("MOVIE_SUGGESTION")) {
                    return MOVIE_SUGGESTION;
                }
                if (str.equalsIgnoreCase("MUSIC_SUGGESTION")) {
                    return MUSIC_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("MESSAGE_RESPONSIVENESS")) {
                    return MESSAGE_RESPONSIVENESS;
                }
                if (str.equalsIgnoreCase("PHONE")) {
                    return PHONE;
                }
                if (str.equalsIgnoreCase("WORK")) {
                    return WORK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("BIRTHDAY")) {
                    return BIRTHDAY;
                }
                if (str.equalsIgnoreCase("OTHER_SUGGESTION")) {
                    return OTHER_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("NAME_PRONUNCIATION")) {
                    return NAME_PRONUNCIATION;
                }
                if (str.equalsIgnoreCase("PLACE_SUGGESTION")) {
                    return PLACE_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("TV_SUGGESTION")) {
                    return TV_SUGGESTION;
                }
                if (str.equalsIgnoreCase("PERSON_SUGGESTION")) {
                    return PERSON_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("PLUMBER_SUGGESTION")) {
                    return PLUMBER_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("ADDRESS")) {
                    return ADDRESS;
                }
                if (str.equalsIgnoreCase("PAGE_PHONE")) {
                    return PAGE_PHONE;
                }
                if (str.equalsIgnoreCase("RECIPE_SUGGESTION")) {
                    return RECIPE_SUGGESTION;
                }
                if (str.equalsIgnoreCase("SALON_SUGGESTION")) {
                    return SALON_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("CURRENT_CITY")) {
                    return CURRENT_CITY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("PAGE_WEBSITE")) {
                    return PAGE_WEBSITE;
                }
                if (str.equalsIgnoreCase("TRAVEL_SUGGESTION")) {
                    return TRAVEL_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("PROFILE_PIC")) {
                    return PROFILE_PIC;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("PHOTOGRAPHER_SUGGESTION")) {
                    return PHOTOGRAPHER_SUGGESTION;
                }
                if (str.equalsIgnoreCase("RESTAURANT_SUGGESTION")) {
                    return RESTAURANT_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("HOURS")) {
                    return HOURS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("PAGE_PRICE_RANGE")) {
                    return PAGE_PRICE_RANGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("THINGS_TO_DO_SUGGESTION")) {
                    return THINGS_TO_DO_SUGGESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("EMAIL")) {
                    return EMAIL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}
