package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: mCoverPhoto */
public enum GraphQLPageSuperCategoryType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ACTIVITIES,
    APPLICATIONS,
    BOOKS_MAGAZINES,
    BRANDS_PRODUCTS,
    CELEBRITIES,
    COMPANY_ORGANIZATIONS,
    DEPRECATED_CATEGORIES,
    DRINKABLE,
    DRINKABLE_EXPERIMENT,
    EDIBLE,
    EDIBLE_EXPERIMENT,
    ENTERTAINMENT,
    FOOD_DRINK,
    GEO_HUB,
    GEOGRAPHY,
    GOINGTOABLE,
    GOINGTOABLE_EXPERIMENT,
    LISTENABLE,
    LISTENABLE_EXPERIMENT,
    LOCAL,
    LOCAL_ATTRIBUTES,
    LOCAL_TOP,
    DEPRECATED_23,
    DEPRECATED_24,
    DEPRECATED_25,
    DEPRECATED_26,
    DEPRECATED_27,
    DEPRECATED_28,
    MOVIES,
    MUSIC,
    NEARBY_PLACES,
    NEARBY_PLACES__ARTS,
    NEARBY_PLACES__BAR,
    DEPRECATED_34,
    NEARBY_PLACES__BREAKFAST,
    NEARBY_PLACES__BRUNCH,
    NEARBY_PLACES__CASUAL_DINING,
    NEARBY_PLACES__COFFEE_SHOP,
    DEPRECATED_39,
    NEARBY_PLACES__DESSERT,
    NEARBY_PLACES__DINNER,
    NEARBY_PLACES__ENTERTAINMENT,
    NEARBY_PLACES__FAST_FOOD,
    NEARBY_PLACES__GROCERY,
    NEARBY_PLACES__HOTEL,
    NEARBY_PLACES__LUNCH,
    NEARBY_PLACES__NIGHTLIFE,
    NEARBY_PLACES__OUTDOORS,
    NEARBY_PLACES__PIZZA,
    NEARBY_PLACES__PROFESSIONAL_SERVICES,
    NEARBY_PLACES__RESTAURANT,
    DEPRECATED_52,
    NEARBY_PLACES__SHOPPING,
    NEARBY_PLACES__SIGHTS,
    NON_REVIEWABLE,
    NON_REVIEWABLE_CATEGORIES_FOR_UNOWNED_PAGES,
    OTHER,
    P0__ARTS_ENTERTAINMENT,
    P0__AUTOMOTIVE,
    P0__CITY,
    P0__COMMUNITY_GOVERNMENT,
    P0__LODGING,
    P0__MEDICAL_HEALTH,
    P0__OTHER,
    P0__PLACE_TO_EAT_DRINK,
    P0__PROFESSIONAL_SERVICES,
    P0__PUBLIC_STRUCTURE,
    P0__REGION,
    P0__RELIGIOUS_CENTER,
    P0__RESIDENCE,
    P0__SCHOOL,
    P0__SHOPPING,
    P0__SPA_BEAUTY_PERSONAL_CARE,
    P0__SPORTS_RECREATION,
    P0__TRAVEL_TRANSPORTATION,
    P0__WORKPLACE_OFFICE,
    P0_CATEGORIES,
    PAGE_CATEGORIES,
    PLACE_TOPICS,
    PLAYABLE,
    PLAYABLE_EXPERIMENT,
    READABLE,
    READABLE_EXPERIMENT,
    SPORTS_TEAMS_LEAGUES,
    SUPPORTABLE,
    SUPPORTABLE_EXPERIMENT,
    TOO_BROAD_CATEGORIES,
    TOPIC_LOCAL,
    TRAVELLABLE,
    TRAVELLABLE_EXPERIMENT,
    TV,
    WATCHABLE,
    WATCHABLE_EXPERIMENT,
    WEBSITE_BLOGS;

    public static GraphQLPageSuperCategoryType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 63) {
            case 0:
                if (str.equalsIgnoreCase("TV")) {
                    return TV;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 1:
                if (str.equalsIgnoreCase("NEARBY_PLACES__NIGHTLIFE")) {
                    return NEARBY_PLACES__NIGHTLIFE;
                }
                if (str.equalsIgnoreCase("NEARBY_PLACES__PIZZA")) {
                    return NEARBY_PLACES__PIZZA;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("EDIBLE_EXPERIMENT")) {
                    return EDIBLE_EXPERIMENT;
                }
                if (str.equalsIgnoreCase("OTHER")) {
                    return OTHER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("NEARBY_PLACES__CASUAL_DINING")) {
                    return NEARBY_PLACES__CASUAL_DINING;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (str.equalsIgnoreCase("DRINKABLE_EXPERIMENT")) {
                    return DRINKABLE_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("LOCAL")) {
                    return LOCAL;
                }
                if (str.equalsIgnoreCase("LOCAL_TOP")) {
                    return LOCAL_TOP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("NON_REVIEWABLE_CATEGORIES_FOR_UNOWNED_PAGES")) {
                    return NON_REVIEWABLE_CATEGORIES_FOR_UNOWNED_PAGES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("P0__OTHER")) {
                    return P0__OTHER;
                }
                if (str.equalsIgnoreCase("P0__SPA_BEAUTY_PERSONAL_CARE")) {
                    return P0__SPA_BEAUTY_PERSONAL_CARE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("GOINGTOABLE_EXPERIMENT")) {
                    return GOINGTOABLE_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("GEO_HUB")) {
                    return GEO_HUB;
                }
                if (str.equalsIgnoreCase("P0__REGION")) {
                    return P0__REGION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("LISTENABLE_EXPERIMENT")) {
                    return LISTENABLE_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("NEARBY_PLACES__BAR")) {
                    return NEARBY_PLACES__BAR;
                }
                if (str.equalsIgnoreCase("P0__SCHOOL")) {
                    return P0__SCHOOL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("PLAYABLE_EXPERIMENT")) {
                    return PLAYABLE_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("NEARBY_PLACES__DESSERT")) {
                    return NEARBY_PLACES__DESSERT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("NEARBY_PLACES__DINNER")) {
                    return NEARBY_PLACES__DINNER;
                }
                if (str.equalsIgnoreCase("READABLE_EXPERIMENT")) {
                    return READABLE_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("NEARBY_PLACES__BREAKFAST")) {
                    return NEARBY_PLACES__BREAKFAST;
                }
                if (str.equalsIgnoreCase("P0__ARTS_ENTERTAINMENT")) {
                    return P0__ARTS_ENTERTAINMENT;
                }
                if (str.equalsIgnoreCase("P0__RELIGIOUS_CENTER")) {
                    return P0__RELIGIOUS_CENTER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("NEARBY_PLACES__RESTAURANT")) {
                    return NEARBY_PLACES__RESTAURANT;
                }
                if (str.equalsIgnoreCase("TOPIC_LOCAL")) {
                    return TOPIC_LOCAL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("P0__COMMUNITY_GOVERNMENT")) {
                    return P0__COMMUNITY_GOVERNMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("SUPPORTABLE_EXPERIMENT")) {
                    return SUPPORTABLE_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("NEARBY_PLACES__ENTERTAINMENT")) {
                    return NEARBY_PLACES__ENTERTAINMENT;
                }
                if (str.equalsIgnoreCase("NEARBY_PLACES__HOTEL")) {
                    return NEARBY_PLACES__HOTEL;
                }
                if (str.equalsIgnoreCase("TRAVELLABLE_EXPERIMENT")) {
                    return TRAVELLABLE_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("GEOGRAPHY")) {
                    return GEOGRAPHY;
                }
                if (str.equalsIgnoreCase("P0__SPORTS_RECREATION")) {
                    return P0__SPORTS_RECREATION;
                }
                if (str.equalsIgnoreCase("WATCHABLE_EXPERIMENT")) {
                    return WATCHABLE_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("ACTIVITIES")) {
                    return ACTIVITIES;
                }
                if (str.equalsIgnoreCase("NEARBY_PLACES__COFFEE_SHOP")) {
                    return NEARBY_PLACES__COFFEE_SHOP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("APPLICATIONS")) {
                    return APPLICATIONS;
                }
                if (str.equalsIgnoreCase("NEARBY_PLACES__LUNCH")) {
                    return NEARBY_PLACES__LUNCH;
                }
                if (str.equalsIgnoreCase("P0__MEDICAL_HEALTH")) {
                    return P0__MEDICAL_HEALTH;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("CELEBRITIES")) {
                    return CELEBRITIES;
                }
                if (str.equalsIgnoreCase("NEARBY_PLACES__BRUNCH")) {
                    return NEARBY_PLACES__BRUNCH;
                }
                if (str.equalsIgnoreCase("P0__TRAVEL_TRANSPORTATION")) {
                    return P0__TRAVEL_TRANSPORTATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("BOOKS_MAGAZINES")) {
                    return BOOKS_MAGAZINES;
                }
                if (str.equalsIgnoreCase("BRANDS_PRODUCTS")) {
                    return BRANDS_PRODUCTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("P0__CITY")) {
                    return P0__CITY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 32:
                if (str.equalsIgnoreCase("MOVIES")) {
                    return MOVIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 34:
                if (str.equalsIgnoreCase("NEARBY_PLACES__FAST_FOOD")) {
                    return NEARBY_PLACES__FAST_FOOD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 37:
                if (str.equalsIgnoreCase("COMPANY_ORGANIZATIONS")) {
                    return COMPANY_ORGANIZATIONS;
                }
                if (str.equalsIgnoreCase("FOOD_DRINK")) {
                    return FOOD_DRINK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 38:
                if (str.equalsIgnoreCase("DEPRECATED_CATEGORIES")) {
                    return DEPRECATED_CATEGORIES;
                }
                if (str.equalsIgnoreCase("EDIBLE")) {
                    return EDIBLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 40:
                if (str.equalsIgnoreCase("DRINKABLE")) {
                    return DRINKABLE;
                }
                if (str.equalsIgnoreCase("NEARBY_PLACES")) {
                    return NEARBY_PLACES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 41:
                if (str.equalsIgnoreCase("LOCAL_ATTRIBUTES")) {
                    return LOCAL_ATTRIBUTES;
                }
                if (str.equalsIgnoreCase("PLACE_TOPICS")) {
                    return PLACE_TOPICS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 42:
                if (str.equalsIgnoreCase("P0_CATEGORIES")) {
                    return P0_CATEGORIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 43:
                if (str.equalsIgnoreCase("NEARBY_PLACES__GROCERY")) {
                    return NEARBY_PLACES__GROCERY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 44:
                if (str.equalsIgnoreCase("PAGE_CATEGORIES")) {
                    return PAGE_CATEGORIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 45:
                if (str.equalsIgnoreCase("GOINGTOABLE")) {
                    return GOINGTOABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 46:
                if (str.equalsIgnoreCase("NEARBY_PLACES__ARTS")) {
                    return NEARBY_PLACES__ARTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 47:
                if (str.equalsIgnoreCase("MUSIC")) {
                    return MUSIC;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 48:
                if (str.equalsIgnoreCase("NEARBY_PLACES__SIGHTS")) {
                    return NEARBY_PLACES__SIGHTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 49:
                if (str.equalsIgnoreCase("LISTENABLE")) {
                    return LISTENABLE;
                }
                if (str.equalsIgnoreCase("WEBSITE_BLOGS")) {
                    return WEBSITE_BLOGS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 50:
                if (str.equalsIgnoreCase("NEARBY_PLACES__OUTDOORS")) {
                    return NEARBY_PLACES__OUTDOORS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 51:
                if (str.equalsIgnoreCase("PLAYABLE")) {
                    return PLAYABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 52:
                if (str.equalsIgnoreCase("P0__LODGING")) {
                    return P0__LODGING;
                }
                if (str.equalsIgnoreCase("SPORTS_TEAMS_LEAGUES")) {
                    return SPORTS_TEAMS_LEAGUES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 53:
                if (str.equalsIgnoreCase("P0__SHOPPING")) {
                    return P0__SHOPPING;
                }
                if (str.equalsIgnoreCase("READABLE")) {
                    return READABLE;
                }
                if (str.equalsIgnoreCase("TOO_BROAD_CATEGORIES")) {
                    return TOO_BROAD_CATEGORIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 54:
                if (str.equalsIgnoreCase("P0__PROFESSIONAL_SERVICES")) {
                    return P0__PROFESSIONAL_SERVICES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 55:
                if (str.equalsIgnoreCase("NON_REVIEWABLE")) {
                    return NON_REVIEWABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 56:
                if (str.equalsIgnoreCase("P0__RESIDENCE")) {
                    return P0__RESIDENCE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 57:
                if (str.equalsIgnoreCase("P0__AUTOMOTIVE")) {
                    return P0__AUTOMOTIVE;
                }
                if (str.equalsIgnoreCase("SUPPORTABLE")) {
                    return SUPPORTABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 58:
                if (str.equalsIgnoreCase("TRAVELLABLE")) {
                    return TRAVELLABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 59:
                if (str.equalsIgnoreCase("P0__PLACE_TO_EAT_DRINK")) {
                    return P0__PLACE_TO_EAT_DRINK;
                }
                if (str.equalsIgnoreCase("WATCHABLE")) {
                    return WATCHABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 62:
                if (str.equalsIgnoreCase("ENTERTAINMENT")) {
                    return ENTERTAINMENT;
                }
                if (str.equalsIgnoreCase("NEARBY_PLACES__SHOPPING")) {
                    return NEARBY_PLACES__SHOPPING;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 63:
                if (str.equalsIgnoreCase("NEARBY_PLACES__PROFESSIONAL_SERVICES")) {
                    return NEARBY_PLACES__PROFESSIONAL_SERVICES;
                }
                if (str.equalsIgnoreCase("P0__PUBLIC_STRUCTURE")) {
                    return P0__PUBLIC_STRUCTURE;
                }
                if (str.equalsIgnoreCase("P0__WORKPLACE_OFFICE")) {
                    return P0__WORKPLACE_OFFICE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}
