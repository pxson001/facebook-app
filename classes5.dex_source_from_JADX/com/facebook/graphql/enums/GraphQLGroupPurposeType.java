package com.facebook.graphql.enums;

/* compiled from: m_chain_friend_accept */
public enum GraphQLGroupPurposeType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FAMILY,
    CLOSE_FRIENDS,
    NEIGHBORS,
    TEAMMATES,
    FOR_SALE,
    EVENT_PLANNING,
    SUPPORT,
    CLUB,
    PROJECT,
    SORORITY,
    FRATERNITY,
    STUDY_GROUP,
    SCHOOL_CLASS,
    TRAVEL_PLANNING,
    COUPLE,
    PARENTS,
    CUSTOM,
    WORK_TEAM,
    WORK_FEEDBACK,
    WORK_ANNOUNCEMENT,
    WORK_SOCIAL,
    DEPRECATED_22,
    WORK_MULTI_COMPANY;

    public static GraphQLGroupPurposeType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FAMILY")) {
            return FAMILY;
        }
        if (str.equalsIgnoreCase("CLOSE_FRIENDS")) {
            return CLOSE_FRIENDS;
        }
        if (str.equalsIgnoreCase("NEIGHBORS")) {
            return NEIGHBORS;
        }
        if (str.equalsIgnoreCase("TEAMMATES")) {
            return TEAMMATES;
        }
        if (str.equalsIgnoreCase("FOR_SALE")) {
            return FOR_SALE;
        }
        if (str.equalsIgnoreCase("EVENT_PLANNING")) {
            return EVENT_PLANNING;
        }
        if (str.equalsIgnoreCase("SUPPORT")) {
            return SUPPORT;
        }
        if (str.equalsIgnoreCase("CLUB")) {
            return CLUB;
        }
        if (str.equalsIgnoreCase("PROJECT")) {
            return PROJECT;
        }
        if (str.equalsIgnoreCase("SORORITY")) {
            return SORORITY;
        }
        if (str.equalsIgnoreCase("FRATERNITY")) {
            return FRATERNITY;
        }
        if (str.equalsIgnoreCase("STUDY_GROUP")) {
            return STUDY_GROUP;
        }
        if (str.equalsIgnoreCase("SCHOOL_CLASS")) {
            return SCHOOL_CLASS;
        }
        if (str.equalsIgnoreCase("TRAVEL_PLANNING")) {
            return TRAVEL_PLANNING;
        }
        if (str.equalsIgnoreCase("COUPLE")) {
            return COUPLE;
        }
        if (str.equalsIgnoreCase("PARENTS")) {
            return PARENTS;
        }
        if (str.equalsIgnoreCase("CUSTOM")) {
            return CUSTOM;
        }
        if (str.equalsIgnoreCase("WORK_TEAM")) {
            return WORK_TEAM;
        }
        if (str.equalsIgnoreCase("WORK_FEEDBACK")) {
            return WORK_FEEDBACK;
        }
        if (str.equalsIgnoreCase("WORK_ANNOUNCEMENT")) {
            return WORK_ANNOUNCEMENT;
        }
        if (str.equalsIgnoreCase("WORK_SOCIAL")) {
            return WORK_SOCIAL;
        }
        if (str.equalsIgnoreCase("WORK_MULTI_COMPANY")) {
            return WORK_MULTI_COMPANY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
