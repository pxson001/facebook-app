package com.facebook.graphql.enums;

/* compiled from: link_video_endscreen_icon */
public enum GraphQLTimelineAppCollectionItemType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ADDRESS,
    CURRENT_CITY,
    EDUCATION,
    EMAIL,
    HOMETOWN,
    PHONE_NUMBER,
    RELATIONSHIPS,
    WORK;

    public static GraphQLTimelineAppCollectionItemType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ADDRESS")) {
            return ADDRESS;
        }
        if (str.equalsIgnoreCase("CURRENT_CITY")) {
            return CURRENT_CITY;
        }
        if (str.equalsIgnoreCase("EDUCATION")) {
            return EDUCATION;
        }
        if (str.equalsIgnoreCase("EMAIL")) {
            return EMAIL;
        }
        if (str.equalsIgnoreCase("HOMETOWN")) {
            return HOMETOWN;
        }
        if (str.equalsIgnoreCase("PHONE_NUMBER")) {
            return PHONE_NUMBER;
        }
        if (str.equalsIgnoreCase("RELATIONSHIPS")) {
            return RELATIONSHIPS;
        }
        if (str.equalsIgnoreCase("WORK")) {
            return WORK;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
