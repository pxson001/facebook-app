package com.facebook.graphql.enums;

/* compiled from: memory_analytic_counters */
public enum GraphQLActivityTemplateTokenType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ICON,
    OBJECT,
    PERSON,
    PEOPLE,
    PLACE;

    public static GraphQLActivityTemplateTokenType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ICON")) {
            return ICON;
        }
        if (str.equalsIgnoreCase("OBJECT")) {
            return OBJECT;
        }
        if (str.equalsIgnoreCase("PERSON")) {
            return PERSON;
        }
        if (str.equalsIgnoreCase("PEOPLE")) {
            return PEOPLE;
        }
        if (str.equalsIgnoreCase("PLACE")) {
            return PLACE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
