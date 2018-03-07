package com.facebook.graphql.enums;

/* compiled from: mediaset */
public enum GraphQLAttributionSource {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    WIKIPEDIA,
    WIKIVOYAGE,
    FREEBASE,
    AMEX,
    HARVARD,
    INGRAM,
    RANDOM_HOUSE;

    public static GraphQLAttributionSource fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("WIKIPEDIA")) {
            return WIKIPEDIA;
        }
        if (str.equalsIgnoreCase("WIKIVOYAGE")) {
            return WIKIVOYAGE;
        }
        if (str.equalsIgnoreCase("FREEBASE")) {
            return FREEBASE;
        }
        if (str.equalsIgnoreCase("AMEX")) {
            return AMEX;
        }
        if (str.equalsIgnoreCase("HARVARD")) {
            return HARVARD;
        }
        if (str.equalsIgnoreCase("INGRAM")) {
            return INGRAM;
        }
        if (str.equalsIgnoreCase("RANDOM_HOUSE")) {
            return RANDOM_HOUSE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
