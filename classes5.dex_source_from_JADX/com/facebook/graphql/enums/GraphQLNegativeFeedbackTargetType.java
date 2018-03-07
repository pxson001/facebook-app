package com.facebook.graphql.enums;

/* compiled from: mLightweightPlacePickerSearchResultsId */
public enum GraphQLNegativeFeedbackTargetType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PAGE,
    GROUP,
    PEOPLE,
    EVENT,
    APP;

    public static GraphQLNegativeFeedbackTargetType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PAGE")) {
            return PAGE;
        }
        if (str.equalsIgnoreCase("GROUP")) {
            return GROUP;
        }
        if (str.equalsIgnoreCase("PEOPLE")) {
            return PEOPLE;
        }
        if (str.equalsIgnoreCase("EVENT")) {
            return EVENT;
        }
        if (str.equalsIgnoreCase("APP")) {
            return APP;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
